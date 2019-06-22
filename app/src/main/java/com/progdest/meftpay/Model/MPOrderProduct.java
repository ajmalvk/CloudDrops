package com.progdest.meftpay.Model;

public class MPOrderProduct {
    String id,product,product_name,count,unit,unit_price,price,note,image;

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

    public String getUnit_price() {
        return unit_price;
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

    public MPOrderProduct(String id, String product, String product_name, String count, String unit, String unit_price, String price, String note, String image) {
        this.id = id;
        this.product = product;
        this.product_name = product_name;
        this.count = count;
        this.unit = unit;
        this.unit_price = unit_price;
        this.price = price;
        this.note = note;
        this.image = image;
    }
}
