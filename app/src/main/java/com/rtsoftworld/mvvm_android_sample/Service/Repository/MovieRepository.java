package com.rtsoftworld.mvvm_android_sample.Service.Repository;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.rtsoftworld.mvvm_android_sample.Service.Model.MovieModel;
import com.rtsoftworld.mvvm_android_sample.Service.Model.Result;
import com.rtsoftworld.mvvm_android_sample.Service.Network.ApiServices;
import com.rtsoftworld.mvvm_android_sample.Service.Network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private MutableLiveData mLiveData;
    private MovieModel movieModel;
    private List<Result> mResult;
    private static Context mContext;
    private static MovieRepository instance;

    public static MovieRepository getInstance(Context context)
    {
        if (instance == null)
        {
            mContext = context;
            instance = new MovieRepository();
        }
        return instance;
    }

    public MutableLiveData<List<Result>> getTopRatedMovieLists()
    {
        if (mLiveData == null)
        {
            mLiveData = new MutableLiveData();
        }

        ApiServices apiServices = RetrofitInstance.getRetrofitInstance().create(ApiServices.class);
        Call<MovieModel> call = apiServices.getTopRatedMovieLists();
        call.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                movieModel = response.body();
                mResult = movieModel.getResults();

                mLiveData.postValue(mResult);


            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        }); //callback

        return mLiveData;

    }


}
