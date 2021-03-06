package com.deepakshankar.ilovezappos.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.deepakshankar.ilovezappos.R;
import com.deepakshankar.ilovezappos.controllers.PicassoImageController;
import com.deepakshankar.ilovezappos.model.Cart;
import com.deepakshankar.ilovezappos.model.CartItem;

import java.util.List;

/**
 * This is the activity that is used to get the cart.
 * @author Deepak Shankar
 */
public class CartActivity extends AppCompatActivity {
    Cart cart;
    List<CartItem> items;
    PicassoImageController imageController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.cartToolBar);
        toolbar.setTitle("Items in your Cart");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        cart = (Cart) bundle.getSerializable("cart");
        items = cart.getItems();



        ListView listView = (ListView) findViewById(R.id.cartItemsList);
        listView.setAdapter(new CartAdapter<CartItem>(this, R.layout.cart_item, items));
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                Intent parentActivity = new Intent(this, ProductViewActivity.class);
                parentActivity.putExtra("zapposResults", getIntent().getExtras().getSerializable("zapposResults"));
                parentActivity.putExtra("cart",cart);
                parentActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(parentActivity);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * This class is used to populate the list in the cart layout.
     * @param <CartItem>
     */
    public class CartAdapter<CartItem> extends ArrayAdapter<CartItem> {
        Context context;
        int id;


        public CartAdapter(Context context, int id, List<CartItem> cartItems) {
            super(context, id, cartItems);
            this.context = context;
            this.id = id;

        }
        public View getView(int position, View v, ViewGroup grp){
            LayoutInflater lf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            RelativeLayout layout = (RelativeLayout)lf.inflate(R.layout.cart_item,null);
            TextView cartProductName = (TextView)layout.findViewById(R.id.cartProdudctName);
            TextView cartProductQty = (TextView)layout.findViewById(R.id.cartProductQuantity);
            cartProductName.setText(Html.fromHtml(items.get(position).getItem().getProductName()));
            cartProductQty.setText(""+items.get(position).getQuantity());
            ImageView cartProductImage = (ImageView)layout.findViewById(R.id.cartProductImage);
            imageController = new PicassoImageController(getBaseContext(), cartProductImage, items.get(position).getItem().getThumbnailImageUrl());
            imageController.loadImage();
            return layout;
        }


    }
}
