package com.progdest.meftpay.Model;

import java.util.ArrayList;

public class CategoryModel {

    public CategoryModel(String category_id, String category_name, String category_name_ml, String category_name_ar, int category_image, ArrayList<SubCategoryModel> sub_category_items) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_name_ml = category_name_ml;
        this.category_name_ar = category_name_ar;
        this.category_image = category_image;
        this.sub_category_items = sub_category_items;
    }
    String category_id;
    String category_name;
    String category_name_ml;
    String category_name_ar;
    int category_image;
    ArrayList<SubCategoryModel> sub_category_items;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name_ml() {
        return category_name_ml;
    }

    public void setCategory_name_ml(String category_name_ml) {
        this.category_name_ml = category_name_ml;
    }

    public String getCategory_name_ar() {
        return category_name_ar;
    }

    public void setCategory_name_ar(String category_name_ar) {
        this.category_name_ar = category_name_ar;
    }

    public int getCategory_image() {
        return category_image;
    }

    public void setCategory_image(int category_image) {
        this.category_image = category_image;
    }

    public ArrayList<SubCategoryModel> getSub_category_items() {
        return sub_category_items;
    }

    public void setSub_category_items(ArrayList<SubCategoryModel> sub_category_items) {
        this.sub_category_items = sub_category_items;
    }
}
