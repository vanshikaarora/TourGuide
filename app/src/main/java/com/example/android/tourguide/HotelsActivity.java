package com.example.android.tourguide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Hotel S.G International","4 Star","3.7","Rs. 1386") );
        words.add(new Word("Cocoon","Luxe quarters in a business hotel offering a chic bar & a modern restaurant, plus free breakfast","4.3","Rs. 3948"));
        words.add(new Word("Sonotel Hotel","Free Wi-Fi","4.2","Rs. 4164"));
        words.add(new Word("Skylark Hotel","Free Wi-Fi and Free Breakfast","4.0","Rs. 4495"));
        words.add(new Word("Seventeen Degrees Hotel","Streamlined rooms & suites, plus an international restaurant, a coffee shop & free breakfast.","4.1","Rs. 3648"));
        words.add(new Word("Hotel Madhulika Inn","Free Breakfast and free Wi-Fi","3.7","Rs. 1649"));
        words.add(new Word("Hotel Poddar Regency","3-Star Hotel","4.1","Rs. 1840"));
        WordAdapter adapter = new WordAdapter(this,words,R.color.colorHotel);
        ListView listView=  (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);}
    public void navigate(View view){
        /**Uri gmmIntentUri = Uri.parse("geo:23.7957,86.4304");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);*/
        Uri gmmIntentUri = Uri.parse("geo:23.7957,86.4304?q=hotels");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void call(View view){
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9999999999"));
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(HotelsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(HotelsActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
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

