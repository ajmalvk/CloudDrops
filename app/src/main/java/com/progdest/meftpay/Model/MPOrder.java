package com.progdest.meftpay.Model;

import java.util.ArrayList;

public class MPOrder {
    String id,store,store_name,store_phone,total,shipping_charge,walet_money,promo_code,promocode_discount,status,created_date,delivery_date,delivery_time;
    ArrayList<MPOrderProduct> products;

    public String getId() {
        return id;
    }

    public String getStore() {
        return store;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getStore_phone() {
        return store_phone;
    }

    public String getTotal() {
        return total;
    }

    public String getShipping_charge() {
        return shipping_charge;
    }

    public String getWalet_money() {
        return walet_money;
    }

    public String getPromo_code() {
        return promo_code;
    }

    public String getPromocode_discount() {
        return promocode_discount;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated_date() {
        return created_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public ArrayList<MPOrderProduct> getProducts() {
        return products;
    }

    public MPOrder(String id, String store, String store_name, String store_phone, String total, String shipping_charge, String walet_money, String promo_code, String promocode_discount, String status, String created_date, String delivery_date, String delivery_time, ArrayList<MPOrderProduct> products) {
        this.id = id;
        this.store = store;
        this.store_name = store_name;
        this.store_phone = store_phone;
        this.total = total;
        this.shipping_charge = shipping_charge;
        this.walet_money = walet_money;
        this.promo_code = promo_code;
        this.promocode_discount = promocode_discount;
        this.status = status;
        this.created_date = created_date;
        this.delivery_date = delivery_date;
        this.delivery_time = delivery_time;
        this.products = products;
    }
}
