
package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView restaurants = (TextView) findViewById(R.id.restaurants);
        restaurants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent restaurantsIntent = new Intent(MainActivity.this, RestaurantsActivity.class);
                startActivity(restaurantsIntent);
            }
        });
        TextView hotels =(TextView) findViewById(R.id.hotels);
        hotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hotelsIntent = new Intent(MainActivity.this, HotelsActivity.class);
                startActivity(hotelsIntent);
            }
        });
        TextView attractions = (TextView)  findViewById(R.id.attractions);
        attractions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent attractionsIntent = new Intent (MainActivity.this, AttractionsActivity.class);
                startActivity(attractionsIntent);
            }
        });
        TextView citymap = (TextView) findViewById(R.id.citymap);
        citymap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Uri gmmIntentUri = Uri.parse("geo:23.7957,86.4304");
                //Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:23.7957,86.4304?z=17"));
                //startActivity(mapIntent);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


    }
}
