package com.rtsoftworld.mvvm_android_sample.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rtsoftworld.mvvm_android_sample.R;
import com.rtsoftworld.mvvm_android_sample.Service.Model.Result;

import java.util.List;

public class TopMovieListAdapter extends RecyclerView.Adapter<TopMovieListAdapter.MyViewHolder>{

    private Context context;
    private List<Result> movieList;

    public TopMovieListAdapter(Context context, List<Result> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_single_row,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopMovieListAdapter.MyViewHolder holder, int position) {
        holder.mTitle.setText(movieList.get(position).getTitle());
        holder.mRating.setText(movieList.get(position).getVoteAverage().toString());
        holder.mReleaseDate.setText(movieList.get(position).getReleaseDate());
//https://image.tmdb.org/t/p/w500/gNBCvtYyGPbjPCT1k3MvJuNuXR6.jpg
        Glide.with(context).load("https://image.tmdb.org/t/p/w500" + movieList.get(position).getPosterPath()).into(holder.mImageView);


    }

    @Override
    public int getItemCount() {
        if (movieList != null)
        {
            return movieList.size();
        }
        else
            return 0;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView mTitle, mRating, mReleaseDate;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = itemView.findViewById(R.id.title);
            mRating = itemView.findViewById(R.id.rating);
            mReleaseDate = itemView.findViewById(R.id.release_date);

            mImageView = itemView.findViewById(R.id.myImageView);

        }
    }

}





