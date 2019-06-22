package com.progdest.meftpay.Utility;

import com.progdest.meftpay.Model.FeaturedProduct;
import com.progdest.meftpay.Model.MPBanner;
import com.progdest.meftpay.Model.MPCart;
import com.progdest.meftpay.Model.MPCategory;
import com.progdest.meftpay.Model.MPOrder;
import com.progdest.meftpay.Model.MPProduct;
import com.progdest.meftpay.Model.UserAddressmodel;

import java.util.ArrayList;

public class AppConfigData {
        public static String app_tokken="";
        public static String site_preference_filename = "com.progdest.meftpay";
        //public static String site_base_url= "http://10.0.2.2:8888/creativigy/just_wills/";
        public static String site_base_url= "http://meftpay.com/dashboard/";
       // public static String site_base_url= "http://meftpay.com/cloud_drops/dashboard/";
        public static String userID = "";
        public static String userName = "";
        public static String userPhone = "";
        public static String userImage = "";
        public static String userTokken = "";
        public static ArrayList<UserAddressmodel> address;
        public static  ArrayList<MPOrder> orders;
        public static  ArrayList<MPCategory> categories;
        public static ArrayList<MPBanner> banner;
        public static ArrayList<MPCart> cart;
        public static ArrayList<MPProduct> featuredProducts;
        public static ArrayList<FeaturedProduct> featuredProducts_demo;
        public static String user_address_id="";
        public static String user_walet_money="";
        public static String user_image_url="";
        public static String category_image_url="";
        public static String product_image_url="";
        public static String banner_image_url="";
        public static String cart_total="";
        public static String shipping_charge="";
}
