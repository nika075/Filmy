package com.example.filmy;

import com.google.gson.annotations.SerializedName;

public class JSONResponse {

    private Movie[] moviz;

    public Movie[] getMoviz() {
        return moviz;
    }

    public void setMoviz(Movie[] moviz) {
        this.moviz = moviz;
    }
}