package com.progdest.meftpay.Fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.gson.JsonObject;
import com.progdest.meftpay.Adapter.BannerAdapter;
import com.progdest.meftpay.Adapter.DaysAdapter;
import com.progdest.meftpay.Adapter.MainCategoryAdapter;
import com.progdest.meftpay.Adapter.ProductAdapter;
import com.progdest.meftpay.Adapter.ProductAdapterSubscription;
import com.progdest.meftpay.Model.DayModel;
import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.Model.MPCart;
import com.progdest.meftpay.Model.MPCategory;
import com.progdest.meftpay.Model.MPOrder;
import com.progdest.meftpay.Model.MPOrderProduct;
import com.progdest.meftpay.Model.MPProduct;
import com.progdest.meftpay.R;
import com.progdest.meftpay.Utility.Api;
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


public class SubscriptionFragment extends android.support.v4.app.Fragment {


    ViewPager viewPager;
    BannerAdapter banner_dapter;
    RecyclerView RV_days,RV_trending_products;
    private LinearLayoutManager mLayoutManager;
    ArrayList<FeaturedProduct> featuredProducts_list;
    ArrayList<String> imageBanner=new ArrayList<String>();
    public static SubscriptionFragment newInstance(){
        SubscriptionFragment fragment=new SubscriptionFragment();
        return fragment;
    }
    ProgressDialog progress;
    String tokken;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        final View home_fragment;
        home_fragment = inflater.inflate(R.layout.subscription_fragment, container, false);
        RV_trending_products = home_fragment.findViewById(R.id.RV_trending_products);
        RV_days = home_fragment.findViewById(R.id.RV_days);
        loadTrendingProducts();
        loadDays();
        return  home_fragment;

    }



    private void loadTrendingProducts() {
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        mLayoutManager.setReverseLayout(false);
        RV_trending_products.setLayoutManager(mLayoutManager);
        ProductAdapterSubscription tAdapter = new ProductAdapterSubscription(AppConfigData.featuredProducts_demo, getActivity());
        RV_trending_products.setAdapter(tAdapter);
        RV_trending_products.smoothScrollToPosition(0);
    }
    private void loadDays() {
        DayModel mon = new DayModel("Mon",false);
        DayModel tue = new DayModel("Tue",false);
        DayModel wen = new DayModel("Wen",false);
        DayModel thu = new DayModel("Thu",false);
        DayModel fri = new DayModel("Fri",false);
        DayModel sat = new DayModel("Sat",false);
        DayModel sun = new DayModel("Sun",false);
        ArrayList<DayModel> days = new ArrayList<>();
        days.add(mon);
        days.add(tue);
        days.add(wen);
        days.add(thu);
        days.add(fri);
        days.add(sat);
        days.add(sun);
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        mLayoutManager.setReverseLayout(false);
        RV_days.setLayoutManager(mLayoutManager);
        DaysAdapter tAdapter = new DaysAdapter(days, getActivity());
        RV_days.setAdapter(tAdapter);
        RV_days.smoothScrollToPosition(0);
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