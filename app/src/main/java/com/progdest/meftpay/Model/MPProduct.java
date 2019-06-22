package com.progdest.meftpay.Model;

public class MPProduct {
    String name;
    String id;
    String category_id;
    String sub_category_id;
    String sub_sub_category_id;
    String price;
    String discount_price;
    String stock;
    String sale_type;
    String buy_price;
    String image;
    String description;
    String short_description;
    String category_name;
    String sub_category_name;
    String sub_sub_category_name;


    String store_name;
    String unit;

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

    public String getStock() {
        return stock;
    }

    public String getSale_type() {
        return sale_type;
    }

    public String getBuy_price() {
        return buy_price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getShort_description() {
        return short_description;
    }

    public String getCategory_name() {
        return category_name;
    }

    public String getSub_category_name() {
        return sub_category_name;
    }

    public String getSub_sub_category_name() {
        return sub_sub_category_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getUnit() {
        return unit;
    }


    public MPProduct(String name, String id, String category_id, String sub_category_id, String sub_sub_category_id, String price, String discount_price, String stock, String sale_type, String buy_price, String image, String description, String short_description,String category_name,String sub_category_name,String sub_sub_category_name,String store_name,String unit) {
        this.name = name;
        this.id = id;
        this.category_id = category_id;
        this.sub_category_id = sub_category_id;
        this.sub_sub_category_id = sub_sub_category_id;
        this.price = price;
        this.discount_price = discount_price;
        this.stock = stock;
        this.sale_type = sale_type;
        this.buy_price = buy_price;
        this.image = image;
        this.description = description;
        this.short_description = short_description;
        this.category_name=category_name;
        this.sub_category_name=sub_category_name;
        this.sub_sub_category_name=sub_sub_category_name;
        this.store_name=store_name;
        this.unit=unit;
    }
}
