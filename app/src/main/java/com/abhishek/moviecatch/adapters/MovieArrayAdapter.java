package com.abhishek.moviecatch.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.abhishek.moviecatch.R;
import com.abhishek.moviecatch.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by abhishekagrawal on 10/18/16.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the data item for the position
        Movie movie = getItem(position);

        //check if the existing view is being reused
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        //get references
        ImageView imageView = (ImageView) convertView.findViewById(R.id.IvMovieImage);
        TextView textViewTitle = (TextView) convertView.findViewById(R.id.TvTitle);
        TextView textViewOverview = (TextView) convertView.findViewById(R.id.TvOverview);

        //populate the data
        int orientation = getContext().getResources().getConfiguration().orientation;
        if(orientation== Configuration.ORIENTATION_PORTRAIT){
            Picasso.with(getContext()).load(movie.getPosterPath()).into(imageView);
        }else{
            Picasso.with(getContext()).load(movie.getBackdropPath()).into(imageView);
        }

        textViewTitle.setText(movie.getOriginalTitle());
        textViewOverview.setText(movie.getOverView());

        return convertView;
    }
}
