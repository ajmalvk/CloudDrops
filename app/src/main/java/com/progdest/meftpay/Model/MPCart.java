package com.progdest.meftpay.Model;

public class MPCart {
    String id,product,product_name,count,unit,price,note,image,store_id,store_name;

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public String getProduct_name() {
        return product_name;
    }

    public String getCount() {
        return count;
    }

    public String getUnit() {
        return unit;
    }

    public String getPrice() {
        return price;
    }

    public String getNote() {
        return note;
    }

    public String getImage() {
        return image;
    }

    public String getStore_id() {
        return store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public MPCart(String id, String product, String product_name, String count, String unit, String price, String note, String image, String store_id, String store_name) {
        this.id = id;
        this.product = product;
        this.product_name = product_name;
        this.count = count;
        this.unit = unit;
        this.price = price;
        this.note = note;
        this.image = image;
        this.store_id = store_id;
        this.store_name = store_name;
    }
}
