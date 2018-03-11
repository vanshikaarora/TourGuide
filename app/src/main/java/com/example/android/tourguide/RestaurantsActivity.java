package com.example.android.tourguide;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestaurantsActivity extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Food factory","Fast food","4.5"));
        words.add(new Word("Yellow chilli","Main course", " 4.9"));
        words.add(new Word("Temptations","Restaurant Lounge","4.8"));
        words.add(new Word("Hong Kong","Chineeze","4.6"));
        words.add(new Word("Aranya's","Luxurious Restaurant","4.8"));
        words.add(new Word("Sonotel","Family Restaurant","4.6"));
        words.add(new Word("Area 51","Club","4.3"));
        WordAdapter adapter = new WordAdapter(this, words, R.color.colorRestaurant);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);}
        public void navigate(View view){
            /**Uri gmmIntentUri = Uri.parse("geo:23.7957,86.4304");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);*/
            //Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7957,86.4304?z=17"));
            //startActivity(mapIntent);
            //mapIntent.setPackage("com.google.android.apps.maps");
            //startActivity(mapIntent);
            Uri gmmIntentUri = Uri.parse("geo:23.7957,86.4304?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);
        }
        public void call(View view){
            Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9999999999"));
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(RestaurantsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(RestaurantsActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
                }
                else
                {
                    startActivity(in);
                }
            }
            else
            {
                startActivity(in);
            }
        }

    }


