package com.deepakshankar.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.deepakshankar.myapplication.R;
import com.deepakshankar.myapplication.model.Product;
import com.deepakshankar.myapplication.model.Result;

import java.util.List;

public class ProductViewActivity extends AppCompatActivity {

    List<Product> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //ListView productsView = (ListView) findViewById(R.id.productsListView);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Result result = (Result) bundle.getSerializable("zapposResults");
        products = result.getResults();
        ArrayAdapter<Product> productArrayAdapter = new ArrayAdapter<Product>(this,R.layout.products,products);
        //productsView.setAdapter(productArrayAdapter);
       /* productsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/


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

}
