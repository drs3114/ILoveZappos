package com.deepakshankar.ilovezappos.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.deepakshankar.ilovezappos.R;
import com.deepakshankar.ilovezappos.controllers.PicassoImageController;
import com.deepakshankar.ilovezappos.databinding.ActivityProductViewBinding;
import com.deepakshankar.ilovezappos.model.Cart;
import com.deepakshankar.ilovezappos.model.CartItem;
import com.deepakshankar.ilovezappos.model.Product;
import com.deepakshankar.ilovezappos.model.Result;

import java.util.List;

/**
 * This is the activity class that is used to display the first item from the search results.
 *
 * @author Deepak Ravi Shankar
 * @version 1.0
 */
public class ProductViewActivity extends AppCompatActivity {

    Result result;
    List<Product> products;
    Product product;
    PicassoImageController imageController;
    ActivityProductViewBinding productViewBinding;
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_view);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        result = (Result) bundle.getSerializable("zapposResults");
        cart = (Cart) bundle.getSerializable("cart");
        products = result.getResults();
        if (products == null || products.size() == 0) {

            product = new Product();
            product.setBrandName("Oops! No result Found!");
            product.setProductName("");
        } else {
            product = products.get(0);

        }
        productViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search Zappos!");
        setSupportActionBar(toolbar);


        productViewBinding.nestedProductLayout.productName.setText(Html.fromHtml(product.getBrandName() + " " + product.getProductName()));

        if (products != null && products.size() > 0) {
            ImageView imageView = (ImageView) findViewById(R.id.productImage);
            imageController = new PicassoImageController(this, imageView, product.getThumbnailImageUrl());
            imageController.resizeAndloadImage(600, 600);

            productViewBinding.nestedProductLayout.originalPrice.setText("Original Price: "+product.getOriginalPrice());
            productViewBinding.nestedProductLayout.discount.setText("Discount: "+product.getPercentOff());
            productViewBinding.nestedProductLayout.productPrice.setText("Price: "+product.getPrice());
        }

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation floatingButtonAnim = AnimationUtils.loadAnimation(getBaseContext(), R.anim.floating_button_anim);
                fab.startAnimation(floatingButtonAnim);
                if (products != null && products.size() > 0){
                addToCart();
                Snackbar.make(view, "Added to cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();}
                else{
                    Snackbar.make(view, "Nothing to add", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void addToCart() {
        CartItem item = new CartItem();
        item.setItem(product);
        if (cart.getItems().contains(item)) {
            for (CartItem citem : cart.getItems()) {
                if (item.equals(citem)) {
                    citem.setQuantity(citem.getQuantity() + 1);
                    break;
                }
            }

        } else {
            item.setQuantity(item.getQuantity() + 1);
            cart.getItems().add(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.product_view_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cartItems:
                Intent cartIntent = new Intent(getBaseContext(), CartActivity.class);
                cartIntent.putExtra("cart", cart);
                cartIntent.putExtra("zapposResults", result);
                startActivity(cartIntent);
                return true;
            case android.R.id.home:
                Intent searchIntent = new Intent(getBaseContext(), SearchActivity.class);
                searchIntent.putExtra("cart", cart);
                searchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(searchIntent);
                return true;
            case R.id.shareProduct:
                Intent shareIntent = new Intent(getBaseContext(),ShareActivity.class);
                shareIntent.putExtra("cart",cart);
                shareIntent.putExtra("zapposResults", result);
                startActivity(shareIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
