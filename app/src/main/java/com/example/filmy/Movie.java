package com.example.filmy;

import com.google.gson.annotations.SerializedName;

public class Movie {
    //Model Class
    private int id;
    private String title;
    private float rating;
    private String direction;
    private String poster;

    //different name from json, so need to serialize it
    @SerializedName("Details")
    private MoreDetails moreDetails;

    @SerializedName("MoreData")
    private MoreData moreData;

    public MoreData getMoreData() {
        return moreData;
    }

    public void setMoreData(MoreData moreData) {
        this.moreData = moreData;
    }

    public Movie(int id, String title, float rating, String direction, String poster, MoreDetails moreDetails, MoreData moreData) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.direction = direction;
        this.poster = poster;
        this.moreDetails = moreDetails;
        this.moreData = moreData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public MoreDetails getMoreDetails() {
        return moreDetails;
    }

    public void setMoreDetails(MoreDetails moreDetails) {
        this.moreDetails = moreDetails;
    }


}
