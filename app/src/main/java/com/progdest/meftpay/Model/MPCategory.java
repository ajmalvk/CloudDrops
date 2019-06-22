package com.progdest.meftpay.Model;

import java.util.ArrayList;

public class MPCategory {
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

    public MPCategory(String name, String id, String description, String image) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.image = image;
    }

    public MPCategory(String name, String id, String description, String image, ArrayList<MPProduct> products) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.image = image;
        this.products = products;
    }
}
