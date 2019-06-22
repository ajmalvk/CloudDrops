package com.progdest.meftpay.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class FeaturedProduct{

    String f_product_id;
    String f_product_name;
    String f_product_name_ml;
    String f_product_unit;
    String f_product_description1;
    String f_product_description2;
    String f_product_description3;
    String f_product_description1_sh;
    String f_product_description2_sh;
    String f_product_description3_sh;
    String f_product_image;
    String f_product_actual_price;
    String f_product_selling_price;
    String f_product_discount;
    String f_product_shop_name;
    String f_product_shop_id;
    String f_product_shop;
    String cart_item_quantity;
    String cart_original_quantity;
    String cart_item_total_price;
    String WH_latitude;
    String WH_longitude;
    String category_id;
    String sub_category_id;
    String sub_sub_category_id;

    public FeaturedProduct(String f_product_id, String f_product_name, String f_product_name_ml, String f_product_unit,
                           String f_product_description1, String f_product_description2, String f_product_description3,
                           String f_product_description1_sh,String f_product_description2_sh, String f_product_description3_sh,
                           String f_product_image, String f_product_actual_price, String f_product_selling_price,
                           String f_product_discount, String f_product_shop_name, String f_product_shop_id,
                           String f_product_shop,String cart_item_quantity,
                           String cart_item_total_price, String cart_original_quantity,String WH_latitude,
                           String WH_longitude,
                           String category_id,
                           String sub_category_id,
                           String sub_sub_category_id) {
        this.f_product_id =   f_product_id;
        this.f_product_name = f_product_name;
        this.f_product_name_ml = f_product_name_ml;
        this.f_product_unit = f_product_unit;
        this.f_product_description1 = f_product_description1;
        this.f_product_description2 = f_product_description2;
        this.f_product_description3 = f_product_description3;
        this.f_product_description1_sh = f_product_description1_sh;
        this.f_product_description2_sh = f_product_description2_sh;
        this.f_product_description3_sh = f_product_description3_sh;
        this.f_product_image = f_product_image;
        this.f_product_actual_price = f_product_actual_price;
        this.f_product_selling_price = f_product_selling_price;
        this.f_product_discount = f_product_discount;
        this.f_product_shop_name = f_product_shop_name;
        this.f_product_shop_id = f_product_shop_id;
        this.f_product_shop = f_product_shop;
        this.cart_item_quantity = cart_item_quantity;
        this.cart_item_total_price = cart_item_total_price;
        this.cart_original_quantity = cart_original_quantity;
        this.WH_latitude = WH_latitude;
        this.WH_longitude = WH_longitude;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.sub_sub_category_id = sub_sub_category_id;
    }


    protected FeaturedProduct(Parcel in) {
        f_product_id = in.readString();
        f_product_name = in.readString();
        f_product_name_ml = in.readString();
        f_product_unit = in.readString();
        f_product_description1 = in.readString();
        f_product_description2 = in.readString();
        f_product_description3 = in.readString();
        f_product_description3_sh = in.readString();
        f_product_description2_sh = in.readString();
        f_product_description1_sh = in.readString();
        f_product_image = in.readString();
        f_product_actual_price = in.readString();
        f_product_selling_price = in.readString();
        f_product_discount = in.readString();
        f_product_shop_name = in.readString();
        f_product_shop_id = in.readString();
        f_product_shop = in.readString();
        cart_item_quantity = in.readString();
        cart_item_total_price = in.readString();
        cart_original_quantity = in.readString();
        WH_latitude = in.readString();
        WH_longitude = in.readString();
        category_id = in.readString();
        sub_category_id = in.readString();
        sub_sub_category_id = in.readString();
    }


    public String getF_product_id() {
        return f_product_id;
    }

    public void setF_product_id(String f_product_id) {
        this.f_product_id = f_product_id;
    }

    public String getF_product_name() {
        return f_product_name;
    }

    public void setF_product_name(String f_product_name) {
        this.f_product_name = f_product_name;
    }

    public String getF_product_unit() {
        return f_product_unit;
    }

    public void setF_product_unit(String f_product_unit) {
        this.f_product_unit = f_product_unit;
    }

    public String getF_product_description1() {
        return f_product_description1;
    }

    public void setF_product_description1(String f_product_description1) {
        this.f_product_description1 = f_product_description1;
    }

    public String getF_product_description2() {
        return f_product_description2;
    }

    public void setF_product_description2(String f_product_description2) {
        this.f_product_description2 = f_product_description2;
    }

    public String getF_product_description3() {
        return f_product_description3;
    }

    public void setF_product_description3(String f_product_description3) {
        this.f_product_description3 = f_product_description3;
    }

    public String getF_product_image() {
        return f_product_image;
    }

    public void setF_product_image(String f_product_image) {
        this.f_product_image = f_product_image;
    }

    public String getF_product_actual_price() {
        return f_product_actual_price;
    }

    public void setF_product_actual_price(String f_product_actual_price) {
        this.f_product_actual_price = f_product_actual_price;
    }

    public String getF_product_selling_price() {
        return f_product_selling_price;
    }

    public void setF_product_selling_price(String f_product_selling_price) {
        this.f_product_selling_price = f_product_selling_price;
    }

    public String getF_product_discount() {
        return f_product_discount;
    }

    public void setF_product_discount(String f_product_discount) {
        this.f_product_discount = f_product_discount;
    }

    public String getF_product_shop_name() {
        return f_product_shop_name;
    }

    public void setF_product_shop_name(String f_product_shop_name) {
        this.f_product_shop_name = f_product_shop_name;
    }

    public String getF_product_name_ml() {
        return f_product_name_ml;
    }

    public void setF_product_name_ml(String f_product_name_ml) {
        this.f_product_name_ml = f_product_name_ml;
    }

    public String getF_product_description1_sh() {
        return f_product_description1_sh;
    }

    public void setF_product_description1_ml(String f_product_description1_sh) {
        this.f_product_description1_sh = f_product_description1_sh;
    }

    public String getF_product_description2_sh() {
        return f_product_description2_sh;
    }

    public void setF_product_description2_sh(String f_product_description2_sh) {
        this.f_product_description2_sh = f_product_description2_sh;
    }

    public String getF_product_description3_sh() {
        return f_product_description3_sh;
    }

    public void setF_product_description3_sh(String f_product_description3_sh) {
        this.f_product_description3_sh = f_product_description3_sh;
    }
    public String getF_product_shop_id() {
        return f_product_shop_id;
    }

    public void setF_product_shop_id(String f_product_shop_id) {
        this.f_product_shop_id = f_product_shop_id;
    }

    public String getF_product_shop() {
        return f_product_shop;
    }

    public void setF_product_shop(String f_product_shop) {
        this.f_product_shop = f_product_shop;
    }


    public String getCart_item_quantity() {
        return cart_item_quantity;
    }

    public void setCart_item_quantity(String cart_item_quantity) {
        this.cart_item_quantity = cart_item_quantity;
    }

    public String getCart_original_quantity() {
        return cart_original_quantity;
    }

    public void setCart_original_quantity(String cart_original_quantity) {
        this.cart_original_quantity = cart_original_quantity;
    }

    public String getCart_item_total_price() {
        return cart_item_total_price;
    }

    public void setCart_item_total_price(String cart_item_total_price) {
        this.cart_item_total_price = cart_item_total_price;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getSub_sub_category_id() {
        return sub_sub_category_id;
    }

    public void setSub_sub_category_id(String sub_sub_category_id) {
        this.sub_sub_category_id = sub_sub_category_id;
    }


}
