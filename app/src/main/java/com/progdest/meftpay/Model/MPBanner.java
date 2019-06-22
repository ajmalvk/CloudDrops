package com.progdest.meftpay.Model;

public class MPBanner {
    String id,name,image;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public MPBanner(String id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }
}
