package com.jewel_mahmud.www.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.jewel_mahmud.www.retrofit.adapter.MovieAdapter;
import com.jewel_mahmud.www.retrofit.model.Movie;
import com.jewel_mahmud.www.retrofit.model.MovieResponse;
import com.jewel_mahmud.www.retrofit.rest.ApiClient;
import com.jewel_mahmud.www.retrofit.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = MainActivity.class.getSimpleName();

    // Todo - insert your themoviedb.org API KEY here
    private final static String API_KEY = "3aa1a4aeb38b67696f8f502fd2508089";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()){
            showMesssage("Please give the API key");
            return;
        }

        // API interface service
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        final RecyclerView recyclerView = findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Call<MovieResponse> call = apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                int status = response.code();
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MovieAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
                Log.d(TAG, "Number of movies received: "+ movies.size());

            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });



    }

    private void showMesssage(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
