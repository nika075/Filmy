package com.example.filmy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {

    private Context mContext;
    private List<Movie> movieList;

    public Adaptery(Context mContext, List<Movie> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(movieList.get(position).getTitle());
        holder.direction.setText(movieList.get(position).getDirection());
        //getting data from the nested json object
        holder.duration.setText(movieList.get(position).getMoreDetails().getDuration());
        holder.category.setText(movieList.get(position).getMoreDetails().getCategory());
        holder.release.setText(movieList.get(position).getMoreDetails().getRelease());

        //Adding Glide Library to display the image
        Glide.with(mContext)
                .load(movieList.get(position).getPoster())
                .into(holder.img);
        System.out.println("poster!!"+movieList.get(position).getPoster());
        //setting the rating bar value
        holder.ratingBar.setRating(movieList.get(position).getRating()/2);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }






    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView duration;
        ImageView img;
        RatingBar ratingBar;
        TextView direction;
        TextView category;
        TextView release;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.textView2);
            duration = itemView.findViewById(R.id.textView3);
            img = itemView.findViewById(R.id.imageView);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            direction = itemView.findViewById(R.id.textView6);
            category = itemView.findViewById(R.id.textView4);
            release = itemView.findViewById(R.id.textView);

        }
    }

}
