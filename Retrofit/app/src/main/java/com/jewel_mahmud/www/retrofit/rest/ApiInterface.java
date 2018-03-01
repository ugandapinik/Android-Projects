package com.jewel_mahmud.www.retrofit.rest;

import com.jewel_mahmud.www.retrofit.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by fiber on 01-Mar-18.
 */

public interface ApiInterface {

    /**
     * The endpoints are defined inside of an interface using special retrofit
     * annotations to encode details about the parameters and request method.
     * In addition, the return value is always a parameterized Call<T> object
     * such as Call<MovieResponse>.
     *
     * For instance, the interface defines each endpoint in the following way.
     *
     */

    @GET("movie/top_rated")
    Call<MovieResponse> getTopRatedMovies(@Query("api_key") String apiKey);


    @GET("movie/{id}")
    Call<MovieResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
