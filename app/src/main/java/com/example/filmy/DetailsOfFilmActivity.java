package com.example.filmy;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailsOfFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_film);
        Intent intent = getIntent();
        ImageView imageView = findViewById(R.id.posterImage);
        TextView description = findViewById(R.id.description);
        TextView actors = findViewById(R.id.actors);
        Glide.with(this)
                .load(intent.getStringExtra("poster"))
                .into(imageView);
        description.setText(intent.getStringExtra("description"));
        actors.setText(intent.getStringExtra("actors"));
    }
}