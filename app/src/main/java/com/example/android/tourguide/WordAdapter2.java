package com.example.android.tourguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by This PC on 11-03-2018.
 */

public class WordAdapter2 extends ArrayAdapter {
    private int mColorResourceId;
    private ArrayList<Word> words;

    public WordAdapter2(Context context, ArrayList<Word> words, int colorResourceId) {
        super(context, 0, words);
        this.words = words;
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item1, parent, false);
            Word currentWord = words.get(position);
            TextView attractionName = (TextView) listItemView.findViewById(R.id.att_name);
            attractionName.setText(currentWord.getName());
            TextView Arate = (TextView) listItemView.findViewById(R.id.att_rating);
            Arate.setText(currentWord.getPrice());
            TextView des = (TextView) listItemView.findViewById(R.id.description);
            des.setText(currentWord.getType());
            TextView add = (TextView) listItemView.findViewById(R.id.address);
            add.setText(currentWord.getRating());

        }
        return listItemView;
    }
}