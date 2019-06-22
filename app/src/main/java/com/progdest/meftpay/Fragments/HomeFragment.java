package com.progdest.meftpay.Fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.progdest.meftpay.Adapter.BannerAdapter;
import com.progdest.meftpay.Adapter.MainCategoryAdapter;
import com.progdest.meftpay.Adapter.ProductAdapter;
import com.progdest.meftpay.Model.CategoryModel;
import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.Model.MPCart;
import com.progdest.meftpay.Model.MPCategory;
import com.progdest.meftpay.Model.MPOrder;
import com.progdest.meftpay.Model.MPOrderProduct;
import com.progdest.meftpay.Model.MPProduct;
import com.progdest.meftpay.Model.SubCategoryModel;
import com.progdest.meftpay.Model.SubSubCategoryModel;
import com.progdest.meftpay.R;
import com.progdest.meftpay.Utility.Api;
import com.progdest.meftpay.Utility.AppConfig;
import com.progdest.meftpay.Utility.AppConfigData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeFragment extends android.support.v4.app.Fragment {


    ViewPager viewPager;
    BannerAdapter banner_dapter;
    RecyclerView RV_main_category,RV_best_offers,RV_trending_products;
    private LinearLayoutManager mLayoutManager;
    ArrayList<FeaturedProduct> featuredProducts_list;
    ArrayList<String> imageBanner=new ArrayList<String>();
    public static HomeFragment newInstance(){
        HomeFragment fragment=new HomeFragment();
        return fragment;
    }
    ProgressDialog progress;
    String tokken;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View home_fragment;
        home_fragment = inflater.inflate(R.layout.home_fragment, container, false);

        viewPager = home_fragment.findViewById(R.id.banner_view_pager);
        RV_main_category =  home_fragment.findViewById(R.id.RV_main_category);
        RV_best_offers =  home_fragment.findViewById(R.id.RV_best_offers);
        RV_trending_products =  home_fragment.findViewById(R.id.RV_trending_products);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        viewPager.setClipToPadding(false);
        viewPager.setPadding(70,10,70,0);
        viewPager.setPageMargin(20);

        mLayoutManager = new LinearLayoutManager(getActivity());

        imageBanner.add("http://progdest.net/lool/uploads/classifieds/bigbasket-Babycare-03Sep2018_580x1000.jpg");
        imageBanner.add("http://progdest.net/lool/uploads/classifieds/bigbasket-snacks-3aug-2018_580x1000.jpg");
        imageBanner.add("http://progdest.net/lool/uploads/classifieds/HP_RDay_1440X692-12thJan-1024x493.jpg");
        imageBanner.add("http://progdest.net/lool/uploads/classifieds/free-home-delivery-banner-031.jpg");

        banner_dapter = new BannerAdapter(getActivity(), imageBanner,viewPager);
        viewPager.setAdapter(banner_dapter);
        viewPager.setCurrentItem(1);
        progress = new ProgressDialog(getActivity());

        get_home_data();
        loadOffers();
        loadTrendingProducts();
        return  home_fragment;

    }

    public void get_home_data(){
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();
        String second_tokken="L!gMS5UP`eFD73P,s2r.5m7vL'#6+Ue89.yKjQu#gcC%+&T#6-";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfig.site_base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        Api api = retrofit.create(Api.class);
        Log.d("tokken",AppConfigData.userTokken);
        Call<JsonObject> call = api.getHome(AppConfigData.userTokken);
        ////
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progress.dismiss();
                JsonObject object=response.body();
                String jstr=object.toString();
                Log.d("alldata home",jstr.toString());
                JSONObject obj=null;
                try {
                    obj=new JSONObject(jstr);
                    int status=obj.getInt("status");
                    if(status==1) {
                        ///childrens data add
                        AppConfig.getInstance().set_home_data(obj);
                        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
                        mLayoutManager.setReverseLayout(false);
                        RV_main_category.setLayoutManager(mLayoutManager);

                        MainCategoryAdapter mAdapter = new MainCategoryAdapter(AppConfig.categories, getActivity());
                        RV_main_category.setAdapter(mAdapter);
                        RV_main_category.smoothScrollToPosition(0);


                    }
                    else{
                        //Toast.makeText(ChildrensActivity.this, obj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progress.dismiss();
                Log.d("test",t.getMessage());
            }


        });
        ////

    }



    private void loadOffers() {

        FeaturedProduct one = new FeaturedProduct("","Product One","",""
                ,"descrt slkdjf","","","",""
                ,"","","","",""
                ,"","","","","",""
                ,"","","","","");
        FeaturedProduct two = new FeaturedProduct("","Product One","",""
                ,"descrt slkdjf","","","",""
                ,"","","","",""
                ,"","","","","",""
                ,"","","","","");
        FeaturedProduct three = new FeaturedProduct("","Product One","",""
                ,"descrt slkdjf","","","",""
                ,"","","","",""
                ,"","","","","",""
                ,"","","","","");

        FeaturedProduct four = new FeaturedProduct("","Product One","",""
                ,"descrt slkdjf","","","",""
                ,"","","","",""
                ,"","","","","",""
                ,"","","","","");

        FeaturedProduct five = new FeaturedProduct("","Product One","",""
                ,"descrt slkdjf","","","",""
                ,"","","","",""
                ,"","","","","",""
                ,"","","","","");

        featuredProducts_list = new ArrayList<>();
        featuredProducts_list.add(one);
        featuredProducts_list.add(two);
        featuredProducts_list.add(three);
        featuredProducts_list.add(four);
        featuredProducts_list.add(five);
        AppConfigData.featuredProducts_demo = featuredProducts_list;
        LinearLayoutManager offer_LayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        offer_LayoutManager.setReverseLayout(false);
        RV_best_offers.setLayoutManager(offer_LayoutManager);
        ProductAdapter oAdapter = new ProductAdapter(featuredProducts_list, getActivity());
        RV_best_offers.setAdapter(oAdapter);
        RV_best_offers.smoothScrollToPosition(0);
    }

    private void loadTrendingProducts() {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        mLayoutManager.setReverseLayout(false);
        RV_trending_products.setLayoutManager(mLayoutManager);
        ProductAdapter tAdapter = new ProductAdapter(AppConfigData.featuredProducts_demo, getActivity());
        RV_trending_products.setAdapter(tAdapter);
        RV_trending_products.smoothScrollToPosition(0);
    }

    private void loadCategory() {

  /*      SubSubCategoryModel sub_sub = new SubSubCategoryModel("1","2","3","Grocery","","","");
        SubSubCategoryModel sub_sub_one = new SubSubCategoryModel("1","2","3","Grocery","","","");
        sub_sub_category_list = new ArrayList<>();
        sub_sub_category_list.add(sub_sub);
        sub_sub_category_list.add(sub_sub_one);

        SubCategoryModel sub = new SubCategoryModel("","","","Clothes","","",sub_sub_category_list);
        SubCategoryModel sub_one = new SubCategoryModel("","","","Clothes","","",sub_sub_category_list);
        sub_category_list = new ArrayList<>();
        sub_category_list.add(sub);
        sub_category_list.add(sub_one);

        CategoryModel cat= new CategoryModel("","Grocery","","",R.drawable.main_cat_one,sub_category_list);
        CategoryModel cat_one= new CategoryModel("","Electronics","","",R.drawable.main_cat_two,sub_category_list);
        CategoryModel cat_two= new CategoryModel("","Mens Cloth","","",R.drawable.main_cat_three,sub_category_list);
        CategoryModel cat_three= new CategoryModel("","Grocery","","",R.drawable.main_cat_one,sub_category_list);
        CategoryModel cat_four= new CategoryModel("","Electronics","","",R.drawable.main_cat_two,sub_category_list);
        CategoryModel cat_five= new CategoryModel("","Mens Cloth","","",R.drawable.main_cat_three,sub_category_list);

        category_list = new ArrayList<>();
        category_list.add(cat);
        category_list.add(cat_one);
        category_list.add(cat_three);
        category_list.add(cat_two);
        category_list.add(cat_four);
        category_list.add(cat_five);
*/
    }


}