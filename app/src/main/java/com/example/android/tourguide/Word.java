package com.example.android.tourguide;

/**
 * Created by This PC on 07-03-2018.
 */

public class Word {
private String mName;
private String mType;
private String mRating;
    private String mPrice;
public Word(String name, String type, String rating){
    mName=name;
    mType=type;
    mRating=rating;
}
    public Word(String name, String type, String rating,String price){
        mName=name;
        mType=type;
        mRating=rating;
        mPrice=price;
    }
public String getName(){ return mName;}
public String getType() { return  mType;}
public String getRating() { return mRating;}
public String getPrice(){return mPrice;}
}
