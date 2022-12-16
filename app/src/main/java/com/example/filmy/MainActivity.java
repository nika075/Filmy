package com.example.filmy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    List<Movie> movieList;
    TextView textView;

    private ServiceGenerator serviceGenerator = ServiceGenerator.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        movieList = new ArrayList<>();

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://run.mocky.io/")
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        MovieApi movieApi = retrofit.create(MovieApi.class);

//        Call<JSONResponse> call = movieApi.getMovies();

        serviceGenerator.getApi().getMovies().enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                JSONResponse jsonResponse = response.body();
                if(response.raw().cacheResponse() != null
                        && response.raw().networkResponse() == null){
                    Log.d("tag", "onResponse: response is from CACHE...");
                }
                movieList = new ArrayList<>(Arrays.asList(jsonResponse.getMoviz()));
                PutDataIntoRecyclerView(movieList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {

            }
        });

    }

    private void PutDataIntoRecyclerView(List<Movie> movieList) {
        Adaptery adaptery = new Adaptery(this,movieList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this,DetailsOfFilmActivity.class);
        intent.putExtra("description", movieList.get(position).getMoreData().getDescription());
        intent.putExtra("actors", movieList.get(position).getMoreData().getActors());
        startActivity(intent);
    }
}