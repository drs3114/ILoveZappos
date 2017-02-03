package com.deepakshankar.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.EditText;

import com.deepakshankar.myapplication.controllers.rest.RestController;
import com.deepakshankar.myapplication.model.Result;


public class SearchActivity extends AppCompatActivity {
    RestController restController = new RestController();
    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



    }

    public void searchZappos(View view)  {
        EditText searchText = (EditText) findViewById(R.id.search_term);
        String term = searchText.getText().toString();
        Log.d("SearchActivity","Search term: "+term);
        restController.start(term);
        result = restController.getResult();
        Intent listIntent = new Intent(getBaseContext(),ListActivity.class);
        listIntent.putExtra("zapposResults",result);
        startActivity(listIntent);

    }





}
