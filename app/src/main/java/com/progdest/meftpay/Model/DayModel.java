package com.progdest.meftpay.Model;

public class DayModel {
    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }

    public Boolean getDay_selected() {
        return day_selected;
    }

    public void setDay_selected(Boolean day_selected) {
        this.day_selected = day_selected;
    }

    public DayModel(String day_name, Boolean day_selected) {
        this.day_name = day_name;
        this.day_selected = day_selected;
    }

    String day_name;
    Boolean day_selected;
}
