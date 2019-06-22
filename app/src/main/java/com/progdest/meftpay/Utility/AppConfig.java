package com.progdest.meftpay.Utility;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.progdest.meftpay.Adapter.MainCategoryAdapter;
import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.Model.MPBanner;
import com.progdest.meftpay.Model.MPCart;
import com.progdest.meftpay.Model.MPCategory;
import com.progdest.meftpay.Model.MPOrder;
import com.progdest.meftpay.Model.MPOrderProduct;
import com.progdest.meftpay.Model.MPProduct;
import com.progdest.meftpay.Model.MPSubscriptionProduct;
import com.progdest.meftpay.Model.UserAddressmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AppConfig {
    //app config
    private static final AppConfig ourInstance = new AppConfig();
    public static String app_tokken="";
    public static String site_preference_filename = "com.progdest.meftpay";
    //public static String site_base_url= "http://10.0.2.2:8888/creativigy/just_wills/";
    public static String site_base_url= "http://meftpay.com/cloud_drops/";
    // public static String site_base_url= "http://meftpay.com/cloud_drops/dashboard/";
    public static String userID = "";
    public static String userName = "";
    public static String userPhone = "";
    public static String userImage = "";
    public static String userTokken = "";
    public static ArrayList<UserAddressmodel> address=new ArrayList<>();
    public static  ArrayList<MPOrder> orders=new ArrayList<>();
    public static  ArrayList<MPCategory> categories=new ArrayList<>();
    public static ArrayList<MPBanner> banner=new ArrayList<>();
    public static ArrayList<MPCart> cart=new ArrayList<>();
    public static ArrayList<MPProduct> featuredProducts=new ArrayList<>();
    public static ArrayList<FeaturedProduct> featuredProducts_demo=new ArrayList<>();
    public static String user_address_id="";
    public static String user_walet_money="";
    public static String user_image_url="";
    public static String category_image_url="";
    public static String product_image_url="";
    public static String banner_image_url="";
    public static String cart_total="";
    public static String shipping_charge="";
    public static  ArrayList<MPSubscriptionProduct> subscriptionProducts=new ArrayList<>();
    public static ArrayList<UserAddressmodel> userAddress=new ArrayList<>();
    public static AppConfig getInstance() {
        return ourInstance;
    }

    private AppConfig() {
    }

    public void set_home_data(JSONObject obj) {
        try {
            //User
            JSONObject user=obj.getJSONObject("user");
            AppConfig.userID=user.getString("id");
            AppConfig.userName=user.getString("name");
            AppConfig.userPhone=user.getString("phone");
            AppConfig.userImage=user.getString("image");
            AppConfig.user_walet_money=user.getString("walet_money");
            AppConfig.user_address_id=user.getString("address_id");
            AppConfig.product_image_url=obj.getString("product_image_base_url");
            AppConfig.category_image_url=obj.getString("category_image_base_url");
            AppConfig.banner_image_url=obj.getString("banner_image_base_url");
            AppConfig.user_image_url=obj.getString("user_image_base_url");
            AppConfig.cart_total=obj.getString("cart_total");
            AppConfig.shipping_charge = obj.getString("shipping_total");
            AppConfig.categories=new ArrayList<>();
            ArrayList<MPProduct> productsarr=new ArrayList<>();
            //Category
            JSONArray category=obj.getJSONArray("category");
            for(int i=0;i<category.length();i++){
                JSONObject cat=category.getJSONObject(i);
                //Category Product
                productsarr=new ArrayList<>();
                JSONArray feas=cat.getJSONArray("products");
                for(int j=0;j<feas.length();j++){
                        JSONObject fea=feas.getJSONObject(j);
                        productsarr.add(new MPProduct(fea.getString("name"),fea.getString("id"),fea.getString("category"),fea.getString("sub"),fea.getString("sub_sub"),fea.getString("price"),fea.getString("discount_price"),fea.getString("stock"),fea.getString("sale_type"),"",fea.getString("image"),fea.getString("description"),fea.getString("short_description"),fea.getString("category_name"),"","",fea.getString("store_name"),fea.getString("unit")));
                    }
                AppConfig.categories.add(new MPCategory(cat.getString("name"),cat.getString("category_id"),cat.getString("description"),cat.getString("image"),productsarr));

            }
            //Featured Products
            AppConfig.featuredProducts=new ArrayList<>();
            JSONArray feas=obj.getJSONArray("products_featured");
            for(int i=0;i<feas.length();i++){
                JSONObject fea=feas.getJSONObject(i);
                AppConfig.featuredProducts.add(new MPProduct(fea.getString("name"),fea.getString("id"),fea.getString("category"),fea.getString("sub"),fea.getString("sub_sub"),fea.getString("price"),fea.getString("discount_price"),fea.getString("stock"),fea.getString("sale_type"),"",fea.getString("image"),fea.getString("description"),fea.getString("short_description"),fea.getString("category_name"),"","",fea.getString("store_name"),fea.getString("unit")));
            }
            //Home Banner
            AppConfig.banner=new ArrayList<>();
            JSONArray ban=obj.getJSONArray("banner");
            for(int i=0;i<ban.length();i++){
                    JSONObject bn=ban.getJSONObject(i);
                    AppConfig.banner.add(new MPBanner(bn.getString("id"),bn.getString("name"),bn.getString("image")));
                }
            //Subscription Product
            AppConfig.subscriptionProducts=new ArrayList<>();
            JSONArray subs=obj.getJSONArray("product_subscription");
            for(int i=0;i<subs.length();i++){
                    JSONObject ss=subs.getJSONObject(i);
                    AppConfig.subscriptionProducts.add(new MPSubscriptionProduct(ss.getString("name"),ss.getString("id"),"","","",ss.getString("price"),ss.getString("discount_price"),ss.getString("discount_percentage"),ss.getString("image"),ss.getString("description"),ss.getString("unit"),false));
                }
            //User Address
            set_user_address(obj);
            //Set Orders
            set_orders(obj);
            //Set Cart
            set_cart(obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void set_cart(JSONObject obj){
            //Cart
            AppConfig.cart=new ArrayList<>();
            JSONArray cart= null;
            try {
                cart = obj.getJSONArray("cart");
                for (int i=0;i<cart.length();i++){
                        JSONObject car=cart.getJSONObject(i);
                        AppConfig.cart.add(new MPCart(car.getString("id"),car.getString("product"),car.getString("product_name"),car.getString("quantity"),car.getString("unit"),car.getString("product_price"),"",car.getString("product_image"),"",""));
                    }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }


    public void set_orders(JSONObject obj){
            //Orders
            AppConfig.orders=new ArrayList<>();
            JSONArray ords= null;
            try {
                    ords = obj.getJSONArray("orders");
                    for(int i=0;i<ords.length();i++){
                            JSONObject ord=ords.getJSONObject(i);
                            ArrayList<MPOrderProduct> products=new ArrayList<>();
                            JSONArray items=ord.getJSONArray("items");
                            for(int j=0;j<items.length();j++){
                                    JSONObject item=items.getJSONObject(j);
                                    products.add(new MPOrderProduct(item.getString("id"),item.getString("product"),item.getString("product_name"),item.getString("count"),item.getString("unit"),item.getString("unit_price"),item.getString("price"),item.getString("note"),item.getString("image")));
                                }
                            AppConfig.orders.add(new MPOrder(ord.getString("id"),ord.getString("store"),ord.getString("store_name"),ord.getString("store_phone"),ord.getString("total"),ord.getString("shipping_charge"),ord.getString("walet_money"),ord.getString("promo_code"),ord.getString("promocode_discount"),ord.getString("status"),ord.getString("created_date"),ord.getString("delivery_date"),ord.getString("delivery_time_slot"),products));
                        }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    public void set_user_address(JSONObject obj){
            //User Address
            AppConfig.userAddress=new ArrayList<>();
            JSONArray usa= null;
            try {
                usa = obj.getJSONArray("user_address");
                for(int i=0;i<usa.length();i++){
                    JSONObject us=usa.getJSONObject(i);
                    Boolean main_address=false;
                    Boolean office_address=false;
                    Boolean stairs_available=false;
                    Boolean lift_available=false;
                    if(us.getString("office_address").equals("1")){
                        office_address=true;
                    }
                    if(us.getString("stairs_available").equals("1")){
                        stairs_available=true;
                    }
                    if(us.getString("lift_available").equals("1")){
                        lift_available=true;
                    }
                    if(us.getString("address_id").equals(user_address_id)){
                        main_address=true;
                    }
                    AppConfig.userAddress.add(new UserAddressmodel(us.getString("id"),us.getString("title"),us.getString("name"),us.getString("locality"),us.getString("address_line1"),us.getString("address_line2"),us.getString("post"),us.getString("pin"),us.getString("area"),us.getString("city"),us.getString("landmark"),us.getString("phone"),us.getString("latitude"),us.getString("longitude"),main_address,office_address,stairs_available,lift_available,us.getString("flat_floor"),us.getString("flat_number")));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
}
