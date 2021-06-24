package com.rtsoftworld.mvvm_android_sample.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.rtsoftworld.mvvm_android_sample.Service.Model.Result;
import com.rtsoftworld.mvvm_android_sample.Service.Repository.MovieRepository;

import java.util.List;

public class TopMovieListViewModel extends AndroidViewModel {

    private MovieRepository mRepo;

    public TopMovieListViewModel(@NonNull Application application) {
        super(application);
        mRepo = MovieRepository.getInstance(application);
    }

    public MutableLiveData<List<Result>> getTopRatedMovieList()
    {
        return mRepo.getTopRatedMovieLists();
    }
}
