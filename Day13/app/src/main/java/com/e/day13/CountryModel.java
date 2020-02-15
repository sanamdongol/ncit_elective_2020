package com.e.day13;

public class CountryModel {
    private String name;
    private String place;
    private String url;

    public CountryModel(String name, String place, String url) {
        this.name = name;
        this.place = place;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
