package com.umniah.app1;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends ArrayAdapter {

    private ArrayList<Movie> movies;
    public MovieAdapter(@NonNull Context context, int resource ,ArrayList<Movie> movies) {
        super(context, resource);
        this.movies = movies;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.activity_listmovies,parent);
        ImageView iv = (ImageView) convertView.findViewById(R.id.imageView);
        iv.setBackgroundResource(movies.get(position).getImageId());
        TextView tv = (TextView) convertView.findViewById(R.id.textView5);
        tv.setText(movies.get(position).getTitle());
        return convertView;
    }
}
