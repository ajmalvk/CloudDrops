package com.progdest.meftpay.Model;

public class MPSubscriptionProduct {
    String name;
    String id;
    String category_id;
    String sub_category_id;
    String sub_sub_category_id;
    String price;
    String discount_price;
    String discount_percentage;
    String image;
    String description;
    String unit;
    Boolean is_selected=false;

    public MPSubscriptionProduct(String name, String id, String category_id, String sub_category_id, String sub_sub_category_id, String price, String discount_price, String discount_percentage, String image, String description, String unit, Boolean is_selected) {
        this.name = name;
        this.id = id;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.sub_sub_category_id = sub_sub_category_id;
        this.price = price;
        this.discount_price = discount_price;
        this.discount_percentage = discount_percentage;
        this.image = image;
        this.description = description;
        this.unit = unit;
        this.is_selected = is_selected;
    }

    public MPSubscriptionProduct(String name, String id, String category_id, String sub_category_id, String sub_sub_category_id, String price, String discount_price, String discount_percentage, String image, String description, String unit) {
        this.name = name;
        this.id = id;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.sub_sub_category_id = sub_sub_category_id;
        this.price = price;
        this.discount_price = discount_price;
        this.discount_percentage = discount_percentage;
        this.image = image;
        this.description = description;
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public String getSub_category_id() {
        return sub_category_id;
    }

    public String getSub_sub_category_id() {
        return sub_sub_category_id;
    }

    public String getPrice() {
        return price;
    }

    public String getDiscount_price() {
        return discount_price;
    }

    public String getDiscount_percentage() {
        return discount_percentage;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }

    public Boolean getIs_selected() {
        return is_selected;
    }

    public void setIs_selected(Boolean is_selected) {
        this.is_selected = is_selected;
    }
}
