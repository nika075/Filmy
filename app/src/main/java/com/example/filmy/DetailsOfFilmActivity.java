package com.example.filmy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsOfFilmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_film);
        Intent intent = getIntent();
        TextView description = findViewById(R.id.description);
        TextView actors = findViewById(R.id.actors);
        description.setText(intent.getStringExtra("description"));
        actors.setText(intent.getStringExtra("actors"));
    }
}