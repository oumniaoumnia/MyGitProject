package com.umniah.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityTwo extends AppCompatActivity {

    @BindView(R.id.listMovies)
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_two);
            ButterKnife.bind(this);
            ArrayList<Movie> movies = new ArrayList<Movie>();
            movies.add(new Movie("joker",R.drawable.ic_launcher_foreground));
            movies.add(new Movie("titanic",R.drawable.ic_launcher_foreground));
            movies.add(new Movie("joker",R.drawable.ic_launcher_foreground));

            MovieAdapter adapter = new MovieAdapter(getApplicationContext(), R.layout.activity_listmovies,movies);

    }
}
