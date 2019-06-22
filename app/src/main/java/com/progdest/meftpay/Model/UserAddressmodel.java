package com.progdest.meftpay.Model;

public class UserAddressmodel {
    public UserAddressmodel(String id, String address_title, String name, String locality, String address_line1, String address_line2, String post, String pin, String area, String city, String landmark, String phone, String latitude, String longitude, Boolean main_address, Boolean office_address, Boolean stairs_available, Boolean lift_availbe, String flat_floor, String flat_number) {
        this.id = id;
        this.address_title = address_title;
        this.name = name;
        this.locality = locality;
        this.address_line1 = address_line1;
        this.address_line2 = address_line2;
        this.post = post;
        this.pin = pin;
        this.area = area;
        this.city = city;
        this.landmark = landmark;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.main_address = main_address;
        this.office_address = office_address;
        this.stairs_available = stairs_available;
        this.lift_availbe = lift_availbe;
        this.flat_floor = flat_floor;
        this.flat_number = flat_number;
    }

    String id;
    String address_title;
    String name;
    String locality;
    String address_line1;
    String address_line2;
    String post;
    String pin;
    String area;
    String city;
    String landmark;
    String phone;
    String latitude;
    String longitude;
    Boolean main_address;
    Boolean office_address;
    Boolean stairs_available;
    Boolean lift_availbe;
    String flat_floor;
    String flat_number;

    public Boolean getOffice_address() {
        return office_address;
    }

    public Boolean getStairs_available() {
        return stairs_available;
    }

    public Boolean getLift_availbe() {
        return lift_availbe;
    }

    public String getFlat_floor() {
        return flat_floor;
    }

    public String getFlat_number() {
        return flat_number;
    }





    public String getId() {
        return id;
    }

    public String getAddress_title() {
        return address_title;
    }

    public String getName() {
        return name;
    }

    public String getLocality() {
        return locality;
    }

    public String getAddress_line1() {
        return address_line1;
    }

    public String getAddress_line2() {
        return address_line2;
    }

    public String getPost() {
        return post;
    }

    public String getPin() {
        return pin;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getPhone() {
        return phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public Boolean getMain_address() {
        return main_address;
    }


}
