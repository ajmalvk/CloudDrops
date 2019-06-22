package com.progdest.meftpay;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.WindowManager;
import com.google.gson.JsonObject;
import com.progdest.meftpay.Fragments.CartFragment;
import com.progdest.meftpay.Fragments.HomeFragment;
import com.progdest.meftpay.Fragments.ProfileFragment;
import com.progdest.meftpay.Fragments.SubscriptionFragment;
import com.progdest.meftpay.Model.MPCart;
import com.progdest.meftpay.Model.MPProduct;
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

public class HomeActivity extends AppCompatActivity {
    ProgressDialog progress;
    String tokken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeFragment.newInstance());
        transaction.commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.home_nav:
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.subscribe_nav:
                    selectedFragment = SubscriptionFragment.newInstance();
                    break;
                case R.id.track_order_nav:
                    selectedFragment = HomeFragment.newInstance();
                    break;
                case R.id.cart_na:
                    selectedFragment = CartFragment.newInstance();
                    break;
                case R.id.account_nav:
                    selectedFragment = ProfileFragment.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_layout, selectedFragment);
            transaction.commit();
            return true;
        }
    };

    ///get home data

    /// Get Products by sub sub Category
    public void get_product_category(String category_id){


        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfigData.site_base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        Api api = retrofit.create(Api.class);
        Call<JsonObject> call =  api.getProductsByCategory(AppConfigData.userTokken,category_id);

        ////
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progress.dismiss();
                JsonObject object=response.body();
                String jstr=object.toString();
                Log.d("alldata",jstr.toString());
                JSONObject obj=null;
                try {
                    obj=new JSONObject(jstr);
                    int status=obj.getInt("status");
                    if(status==1) {
                        ArrayList<MPProduct> products=new ArrayList<>();
                        JSONArray feas=obj.getJSONArray("products");
                        for(int i=0;i<feas.length();i++){
                            JSONObject fea=feas.getJSONObject(i);
                            products.add(new MPProduct(fea.getString("name"),fea.getString("id"),fea.getString("category"),fea.getString("sub"),fea.getString("sub_sub"),fea.getString("price"),fea.getString("discount_price"),fea.getString("stock"),fea.getString("sale_type"),"",fea.getString("image"),fea.getString("description"),fea.getString("short_description"),fea.getString("category_name"),fea.getString("sub_category_name"),fea.getString("sub_sub_category_name"),fea.getString("store_name"),fea.getString("unit")));
                        }

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


    /// Get Products by sub sub Category
    public void add_cart(String product_id,String count){


        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AppConfigData.site_base_url)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();
        Api api = retrofit.create(Api.class);
        Call<JsonObject> call =  api.addCart(AppConfigData.userTokken,product_id,count);

        ////
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                progress.dismiss();
                JsonObject object=response.body();
                String jstr=object.toString();
                Log.d("alldata",jstr.toString());
                JSONObject obj=null;
                try {
                    obj=new JSONObject(jstr);
                    int status=obj.getInt("status");
                    if(status==1) {
                            AppConfigData.cart_total=obj.getString("cart_total");
                            AppConfigData.shipping_charge = obj.getString("shipping_total");
                        AppConfigData.cart=new ArrayList<>();
                        JSONArray cart=obj.getJSONArray("cart");
                        for (int i=0;i<cart.length();i++){
                                JSONObject car=cart.getJSONObject(i);
                                AppConfigData.cart.add(new MPCart(car.getString("id"),car.getString("product"),car.getString("product_name"),car.getString("quantity"),car.getString("unit"),car.getString("product_price"),"",car.getString("product_image"),"",""));
                            }

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
 /*   JSONArray subs=cat.getJSONArray("sub_categories");
    ArrayList<MPSubCategoryRemoved> subCategories=new ArrayList<>();
                                for(int j=0;j<subs.length();j++){
        JSONObject sub=subs.getJSONObject(j);
        ArrayList<MPSubCategory> subSubCategories=new ArrayList<>();
        JSONArray subSubs=sub.getJSONArray("sub_sub_categories");
        for(int k=0;k<subSubs.length();k++){
            JSONObject subSub=subSubs.getJSONObject(k);
            ArrayList<MPProduct> products=new ArrayList<>();
            subSubCategories.add(new MPSubCategory(subSub.getString("name"),subSub.getString("id"),subSub.getString("decription"),subSub.getString("image"),products));
        }
        subCategories.add(new MPSubCategoryRemoved(sub.getString("name"),sub.getString("id"),sub.getString("decription"),sub.getString("image"),subSubCategories));
    }*/


}
