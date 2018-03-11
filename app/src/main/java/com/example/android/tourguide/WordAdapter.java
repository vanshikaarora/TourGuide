package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by This PC on 07-03-2018.
 */

public class WordAdapter extends ArrayAdapter {
    private int mColorResourceId;
    private ArrayList<Word> words;
    public WordAdapter(Context context, ArrayList<Word> words, int colorResourceId){
        super(context,0, words);
        this.words=words;

        mColorResourceId=colorResourceId;
    }
    @Override
   public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = words.get(position);
        TextView restaurantName = (TextView) listItemView.findViewById(R.id.Restaurant_name);
        restaurantName.setText(currentWord.getName());
        TextView foodType = (TextView) listItemView.findViewById(R.id.food_type);
        foodType.setText(currentWord.getType());
        TextView rate = (TextView) listItemView.findViewById(R.id.res_rating);
        rate.setText(currentWord.getRating());
        TextView hotelName=(TextView) listItemView.findViewById(R.id.Restaurant_name);
        hotelName.setText(currentWord.getName());
        TextView hotelPrice =(TextView) listItemView.findViewById(R.id.Hotel_price);
        hotelPrice.setText(currentWord.getPrice());
        TextView HfoodType = (TextView) listItemView.findViewById(R.id.food_type);
        HfoodType.setText(currentWord.getType());
        TextView Hrate = (TextView) listItemView.findViewById(R.id.res_rating);
        Hrate.setText(currentWord.getRating());
        return listItemView;

    }

}
