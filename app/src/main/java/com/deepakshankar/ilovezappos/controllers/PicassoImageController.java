package com.deepakshankar.ilovezappos.controllers;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by DeepakShankar on 2/5/2017.
 */


public class PicassoImageController {
    ImageView imageView;
    Context context;
    String imageUrl;

    /**
     * This is a image controller that is used to initialize the attributes  for Picasso to use while loading images into the required ImageVIew
     *
     * @param context
     * @param imageView
     * @param imageUrl
     */
    public PicassoImageController(Context context, ImageView imageView, String imageUrl) {
        this.context = context;
        this.imageView = imageView;
        this.imageUrl = imageUrl;
    }

    /**
     * This method is used to load the
     */
    public void resizeAndloadImage(int width, int height) {
        Picasso.with(this.context).load(imageUrl).resize(width,height).into(imageView);
    }

    public void loadImage() {
        Picasso.with(this.context).load(imageUrl).into(imageView);
    }
}
