package com.deepakshankar.myapplication.controllers;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by DeepakShankar on 2/5/2017.
 */

public class PicassoImageController  {
    ImageView imageView;
    Context context;
    String imageUrl;

    public void loadImage(){
        Picasso.with(this.context).load(imageUrl).into(imageView);
    }
}
