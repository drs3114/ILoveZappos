package com.deepakshankar.myapplication.activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.EditText;

import com.deepakshankar.myapplication.R;
import com.deepakshankar.myapplication.controllers.rest.RestController;
import com.deepakshankar.myapplication.model.Result;

import java.util.concurrent.ExecutionException;


public class SearchActivity extends AppCompatActivity {

    Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        //setSupportActionBar();
        getActionBar().setTitle("Search Zappos!");
        setContentView(R.layout.activity_search);
    }

    public void searchZappos(View view)  {
        EditText searchText = (EditText) findViewById(R.id.search_term);
        String term = searchText.getText().toString();
        Log.d("SearchActivity","Search term: "+term);
        try {
            result = new SearchActivityHelper().execute(term).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(result==null){
            Log.d("SearchActivity","Result Not found");

        }
        else{
            Log.d("SearchActivity","Result Found Total: "+result.getTotalResultCount());
            Intent listIntent = new Intent(getBaseContext(),ListActivity.class);
        listIntent.putExtra("zapposResults",result);

        startActivity(listIntent);
        }


    }

    private class SearchActivityHelper extends AsyncTask<String, Void, Result>{
        RestController restController = new RestController();
        Result result;
        @Override
        protected Result doInBackground(String... params) {
            String term = params[0];
            result=restController.start(term);
            return result;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Result result) {
            super.onPostExecute(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    }
