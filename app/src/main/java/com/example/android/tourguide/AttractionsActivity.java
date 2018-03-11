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

public class AttractionsActivity extends AppCompatActivity {
    private static final int REQUEST_PHONE_CALL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attractions);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Bhatinda Waterfalls","A powerful waterfall cascades over dramatic rock formations at this natural tourist attraction.","Vill-Tetangabad,Post-Karitand,PS-Dist-, Putki, Dhanbad, Jharkhand 828129","3.9"));
        words.add(new Word("Petrified Wood" ,"Age: 25,00,00,000 years","Sardar Patel Nagar, Dhanbad, Jharkhand 826004","4.6"));
        words.add(new Word("Hill Top"," Tourist attraction in Chittaranjan, India","Chittaranjan, West Bengal 713365","4.2"));
        words.add(new Word("Biridge Of Kandedi-Pandedih", "Tourist attraction in India","Dhanbad, Jharkhand 828402","4.0"));
        words.add(new Word("Sai Aquarium Point","Aquarium in Dhanbad, India","Main Road, Saraidhela, Dhanbad, Jharkhand 828127","3.2"));
        words.add(new Word("TATA colliery","Tourist attraction in Belatand, India","Belatand, Jharkhand 828103","3.9"));
        words.add(new Word("Aranyer Dinratri Tourism","Tourist attraction in Puapur, India","Puapur, West Bengal 713324","3.6"));
        WordAdapter2 adapter = new WordAdapter2(this,words,R.color.colorAttractions);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);}
    public void navigate(View view){
        /**Uri gmmIntentUri = Uri.parse("geo:23.7957,86.4304");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);*/
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600 Amphitheatre Parkway, Mountain+View, California");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
    public void call(View view){
        Intent in = new Intent(Intent.ACTION_CALL, Uri.parse("tel:999999999"));
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(AttractionsActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(AttractionsActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
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

