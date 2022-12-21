package com.example.filmy;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("v3/1707314f-7a51-4e5c-aa02-be8aae9d4b47")
    Call<JSONResponse> getMovies();
}
