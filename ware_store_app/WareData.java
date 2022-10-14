package com.amanpal.warestore;

public class WareData {
    private String ware_name;
    private String ware_Price;
    private String ware_rating;
    private Integer ware_image;

    public WareData(String ware_name, String ware_Price, String ware_rating, Integer ware_image) {
        this.ware_name = ware_name;
        this.ware_Price = ware_Price;
        this.ware_rating = ware_rating;
        this.ware_image = ware_image;
    }

    public String getWare_name() {
        return ware_name;
    }

    public void setWare_name(String ware_name) {
        this.ware_name = ware_name;
    }

    public String getWare_Price() {
        return ware_Price;
    }

    public void setWare_Price(String ware_Price) {
        this.ware_Price = ware_Price;
    }

    public String getWare_rating() {
        return ware_rating;
    }

    public void setWare_rating(String ware_rating) {
        this.ware_rating = ware_rating;
    }

    public Integer getWare_image() {
        return ware_image;
    }

    public void setWare_image(Integer ware_image) {
        this.ware_image = ware_image;
    }
}
