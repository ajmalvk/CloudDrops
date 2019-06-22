package com.progdest.meftpay.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class SubSubCategoryModel{

    public SubSubCategoryModel(String sub_sub_category_id, String sub_category_id, String category_id, String sub_sub_category_name, String sub_sub_category_name_ml, String sub_sub_category_name_ar, String sub_sub_category_image) {
        this.sub_sub_category_id = sub_sub_category_id;
        this.sub_category_id = sub_category_id;
        this.category_id = category_id;
        this.sub_sub_category_name = sub_sub_category_name;
        this.sub_sub_category_name_ml = sub_sub_category_name_ml;
        this.sub_sub_category_name_ar = sub_sub_category_name_ar;
        this.sub_sub_category_image = sub_sub_category_image;
    }
    String sub_sub_category_id;
    String sub_category_id;
    String category_id;
    String sub_sub_category_name;
    String sub_sub_category_name_ml;
    String sub_sub_category_name_ar;
    String sub_sub_category_image;

    public String getSub_sub_category_id() {
        return sub_sub_category_id;
    }

    public void setSub_sub_category_id(String sub_sub_category_id) {
        this.sub_sub_category_id = sub_sub_category_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public void setSub_category_id(String sub_category_id) {
        this.sub_category_id = sub_category_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getSub_sub_category_name() {
        return sub_sub_category_name;
    }

    public void setSub_sub_category_name(String sub_sub_category_name) {
        this.sub_sub_category_name = sub_sub_category_name;
    }

    public String getSub_sub_category_name_ml() {
        return sub_sub_category_name_ml;
    }

    public void setSub_sub_category_name_ml(String sub_sub_category_name_ml) {
        this.sub_sub_category_name_ml = sub_sub_category_name_ml;
    }

    public String getSub_sub_category_name_ar() {
        return sub_sub_category_name_ar;
    }

    public void setSub_sub_category_name_ar(String sub_sub_category_name_ar) {
        this.sub_sub_category_name_ar = sub_sub_category_name_ar;
    }

    public String getSub_sub_category_image() {
        return sub_sub_category_image;
    }

    public void setSub_sub_category_image(String sub_sub_category_image) {
        this.sub_sub_category_image = sub_sub_category_image;
    }

    protected SubSubCategoryModel(Parcel in) {
        sub_sub_category_id = in.readString();
        sub_category_id = in.readString();
        category_id = in.readString();
        sub_sub_category_name = in.readString();
        sub_sub_category_name_ml = in.readString();
        sub_sub_category_name_ar = in.readString();
        sub_sub_category_image = in.readString();
    }

}
