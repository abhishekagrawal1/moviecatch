package com.abhishek.moviecatch.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by abhishekagrawal on 10/18/16.
 */
public class Movie {

    String posterPath;
    String backdropPath;
    String originalTitle;
    String overView;

    public Movie(JSONObject jsonObject) throws JSONException{
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        originalTitle = jsonObject.getString("original_title");
        overView = jsonObject.getString("overview");
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array){
        ArrayList<Movie> results = new ArrayList<>();

        for(int i=0; i<array.length();i++){
            try{
                results.add(new Movie(array.getJSONObject(i)));
            }catch (JSONException ex){
                ex.printStackTrace();
            }
        }
        return results;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverView() {
        return overView;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }
}
