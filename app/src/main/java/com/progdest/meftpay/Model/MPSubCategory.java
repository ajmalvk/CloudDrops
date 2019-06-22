package com.progdest.meftpay.Model;

import java.util.ArrayList;

public class MPSubCategory {
    String name,id,description,image;
    ArrayList<MPProduct> products;

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

    public ArrayList<MPProduct> getProducts() {
        return products;
    }

    public MPSubCategory(String name, String id, String description, String image, ArrayList<MPProduct> products) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.image = image;
        this.products = products;
    }
}
