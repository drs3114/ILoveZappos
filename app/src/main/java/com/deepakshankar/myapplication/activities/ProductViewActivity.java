package com.deepakshankar.myapplication.activities;

import android.content.Intent;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.deepakshankar.myapplication.R;
import com.deepakshankar.myapplication.controllers.PicassoImageController;
import com.deepakshankar.myapplication.databinding.ActivityProductViewBinding;
import com.deepakshankar.myapplication.model.Product;
import com.deepakshankar.myapplication.model.Result;

import java.util.List;

public class ProductViewActivity extends AppCompatActivity {

    List<Product> products;
    Product product;
    PicassoImageController imageController;
    ActivityProductViewBinding productViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Result result = (Result) bundle.getSerializable("zapposResults");
        products = result.getResults();
        product = products.get(0);


        productViewBinding = DataBindingUtil.setContentView(this,R.layout.activity_product_view);
        productViewBinding.setProduct(product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search Zappos!");
        setSupportActionBar(toolbar);


        productViewBinding.nestedProductLayout.productName.setText(Html.fromHtml(product.getBrandName()+" "+product.getProductName(), Build.VERSION.SDK_INT));

        ImageView imageView = (ImageView) findViewById(R.id.productImage);
        imageController = new PicassoImageController(this, imageView, product.getThumbnailImageUrl());
        imageController.loadImage();



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goToBuy(View view){
        Uri uri = Uri.parse(product.getProductUrl());
        Intent webPageIntent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(webPageIntent);
    }

}
