package com.jewel_mahmud.www.retrofit.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jewel_mahmud.www.retrofit.R;
import com.jewel_mahmud.www.retrofit.model.Movie;

import java.util.List;

/**
 * Created by fiber on 01-Mar-18.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public MovieAdapter(List<Movie> movies, int rowLayout, Context context){
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.movieTtile.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout;
        TextView movieTtile;
        TextView data;
        TextView movieDescription;
        TextView rating;

        public MovieViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.movies_layout);
            movieTtile = itemView.findViewById(R.id.title);
            data = itemView.findViewById(R.id.subtitle);
            movieDescription = itemView.findViewById(R.id.description);
            rating = itemView.findViewById(R.id.rating);
        }
    }
}
