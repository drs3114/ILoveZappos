package com.deepakshankar.ilovezappos.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.MenuItem;
import android.widget.ImageView;

import com.deepakshankar.ilovezappos.R;
import com.deepakshankar.ilovezappos.controllers.PicassoImageController;
import com.deepakshankar.ilovezappos.databinding.ActivityViewSharedBinding;
import com.deepakshankar.ilovezappos.model.Product;
import com.deepakshankar.ilovezappos.model.Result;

public class ViewSharedActivity extends AppCompatActivity {
    Result result;
    Product product;
    PicassoImageController imageController;
    ActivityViewSharedBinding activityViewSharedBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_shared);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        result = (Result) bundle.getSerializable("zapposResults");
        product = result.getResults().get(0);
        activityViewSharedBinding = DataBindingUtil.setContentView(this, R.layout.activity_view_shared);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(Html.fromHtml(product.getBrandName() + " " + product.getProductName()));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //activityViewSharedBinding.productName.setText(Html.fromHtml(product.getBrandName() + " " + product.getProductName()));

        ImageView imageView = (ImageView) findViewById(R.id.productImage);
        imageController = new PicassoImageController(this, imageView, product.getThumbnailImageUrl());
        imageController.resizeAndloadImage(600, 600);

        activityViewSharedBinding.originalPrice.setText("Original Price: "+product.getOriginalPrice());
        activityViewSharedBinding.discount.setText("Discount: "+product.getPercentOff());
        activityViewSharedBinding.productPrice.setText("Price: "+product.getPrice());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent searchIntent = new Intent(this,SearchActivity.class);
                searchIntent.putExtra("zapposResults", result);
                searchIntent.putExtra("cart", getIntent().getExtras().getSerializable("cart"));
                searchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(searchIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
