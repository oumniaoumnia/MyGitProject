package com.umniah.app1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityOne extends AppCompatActivity {

        //@BindView(R.id.listView1)
        //ListView lv;
        @BindView(R.id.text)
        TextView tv;

        @BindView(R.id.imageView4)
        ImageView im;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

       /* Bundle extras = getIntent().getExtras();
        String login = new String(extras.getString("login"));
        String pass = new String(extras.getString("pass"));
        if (login == "oumnia" && pass == "admin") {
            setContentView(R.layout.activity_one);
            ButterKnife.bind(this);
           /* fragmentOne fragment = new fragmentOne();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragment).commit();
        }*/

    }
    //String[] array = {"Android","Iphone", "WindowsMobile","Blackberry","WebOS","Ubuntu"};

    class DownloadFileTask extends AsyncTask<URL,Integer, ArrayList<Bitmap>> {
        @Override
        protected ArrayList<Bitmap> doInBackground(URL... urls) {
            ArrayList<Bitmap> images = new ArrayList<Bitmap>();
            for (int i = 0; i < urls.length; i++) {
                try {
                    images.add(BitmapFactory.decodeStream(urls[i].openConnection().getInputStream()));
                    publishProgress(new Integer(i), new Integer(urls.length));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return images;
        }

        protected void onProgressUpdate(Integer... progress) {
            Context context = getApplicationContext();
            Toast.makeText(getApplicationContext(), "finished" + progress[0] + "/" + progress[1], Toast.LENGTH_SHORT).show();
        }

        protected void onpostExecute(ArrayList<Bitmap> images) {
            im.setImageBitmap(images.get(0));
        }
    }
        private void loadImage() throws MalformedURLException {

            URL url1 = new URL("https://images.unsplash.com/photo-1535498730771-e735b998cd64?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
            URL url2 = new URL("https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500");

            new DownloadFileTask().execute(url1,url2);
        }


       /* test fragment = new test();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainer,fragment).commit();*/

        //fragment.changesmtg("helloooo");
        /*ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview,array);

        lv.setAdapter(adapter);*/

    }


