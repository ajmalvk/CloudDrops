package com.progdest.meftpay.Model;

import java.util.ArrayList;

public class SubCategoryModel {

    public SubCategoryModel(String sub_category_id, String category_id, String sub_category_name, String sub_category_name_ml, String sub_category_name_ar, String sub_category_image, ArrayList<SubSubCategoryModel> sub_sub_category_items) {
        this.sub_category_id = sub_category_id;
        this.category_id = category_id;
        this.sub_category_name = sub_category_name;
        this.sub_category_name_ml = sub_category_name_ml;
        this.sub_category_name_ar = sub_category_name_ar;
        this.sub_category_image = sub_category_image;
        this.sub_sub_category_items = sub_sub_category_items;
    }

    String sub_category_id;
    String category_id;
    String sub_category_name;
    String sub_category_name_ml;
    String sub_category_name_ar;
    String sub_category_image;
    ArrayList<SubSubCategoryModel> sub_sub_category_items;

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

    public String getSub_category_name() {
        return sub_category_name;
    }

    public void setSub_category_name(String sub_category_name) {
        this.sub_category_name = sub_category_name;
    }

    public String getSub_category_name_ml() {
        return sub_category_name_ml;
    }

    public void setSub_category_name_ml(String sub_category_name_ml) {
        this.sub_category_name_ml = sub_category_name_ml;
    }

    public String getSub_category_name_ar() {
        return sub_category_name_ar;
    }

    public void setSub_category_name_ar(String sub_category_name_ar) {
        this.sub_category_name_ar = sub_category_name_ar;
    }

    public String getSub_category_image() {
        return sub_category_image;
    }

    public void setSub_category_image(String sub_category_image) {
        this.sub_category_image = sub_category_image;
    }

    public ArrayList<SubSubCategoryModel> getSub_sub_category_items() {
        return sub_sub_category_items;
    }

    public void setSub_sub_category_items(ArrayList<SubSubCategoryModel> sub_sub_category_items) {
        this.sub_sub_category_items = sub_sub_category_items;
    }
}
