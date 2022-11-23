package com.example.filmy;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("v3/1f9bdb07-0b9b-4514-8531-04ca9a7ea3e0")
    Call<JSONResponse> getMovies();
}
