package com.example.filmy;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {

    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    List<Movie> movieList;

    private ServiceGenerator serviceGenerator = ServiceGenerator.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecyclerView);
        movieList = new ArrayList<>();

        serviceGenerator.getApi().getMovies().enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {
                if (response.raw().cacheResponse() != null
                        && response.raw().networkResponse() == null) {
                    Log.d(TAG, "onResponse: response is from CACHE...");
                }

                if (response.raw().networkResponse() != null) {
                    Log.d(TAG, "onResponse: response is from NETWORK...");
                }

                movieList = new ArrayList<>(Arrays.asList(response.body().getMoviz()));
                PutDataIntoRecyclerView(movieList);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ", t);
            }
        });

    }

    private void PutDataIntoRecyclerView(List<Movie> movieList) {
        Adaptery adaptery = new Adaptery(this, movieList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);

    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, DetailsOfFilmActivity.class);
        intent.putExtra("poster", movieList.get(position).getPoster());
        intent.putExtra("description", movieList.get(position).getMoreData().getDescription());
        intent.putExtra("actors", movieList.get(position).getMoreData().getActors());
        startActivity(intent);
    }
}