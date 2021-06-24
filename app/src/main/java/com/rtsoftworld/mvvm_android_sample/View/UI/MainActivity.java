package com.rtsoftworld.mvvm_android_sample.View.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.rtsoftworld.mvvm_android_sample.R;
import com.rtsoftworld.mvvm_android_sample.Service.Model.Result;
import com.rtsoftworld.mvvm_android_sample.View.Adapter.TopMovieListAdapter;
import com.rtsoftworld.mvvm_android_sample.ViewModel.TopMovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TopMovieListViewModel mViewModel;
    private TopMovieListAdapter topMovieListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);


        mViewModel = new ViewModelProvider(this).get(TopMovieListViewModel.class);
        mViewModel.getTopRatedMovieList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {

                topMovieListAdapter = new TopMovieListAdapter(MainActivity.this,results);
                recyclerView.setLayoutManager(gridLayoutManager);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(topMovieListAdapter);

            }

        });


    }
}