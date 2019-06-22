package com.progdest.meftpay.Model;

import java.util.ArrayList;

public class MPSubCategoryRemoved {
    String name,id,description,image;
    ArrayList<MPSubCategory> sub_sub_category;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<MPSubCategory> getSub_sub_category() {
        return sub_sub_category;
    }

    public MPSubCategoryRemoved(String name, String id, String description, String image, ArrayList<MPSubCategory> sub_sub_category) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.image = image;
        this.sub_sub_category = sub_sub_category;
    }
}
