package com.example.filmy;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {

    @GET("v3/9c2968bd-7d68-46c8-95fa-c3fecaf6ff62")
    Call<JSONResponse> getMovies();
}
