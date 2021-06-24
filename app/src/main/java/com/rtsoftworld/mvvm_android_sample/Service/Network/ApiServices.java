package com.rtsoftworld.mvvm_android_sample.Service.Network;

import com.rtsoftworld.mvvm_android_sample.Service.Model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {
    public String TOP_RATED_MOVIE_API_ENDPOINT = "3/movie/top_rated?api_key=0ec301256bd8bdff18154d8b53c4ad8a";
    @GET(TOP_RATED_MOVIE_API_ENDPOINT)
    Call<MovieModel> getTopRatedMovieLists();

}
