package com.deepakshankar.myapplication.activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

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

        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search Zappos!");
        setSupportActionBar(toolbar);
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
            Toast.makeText(this,"No results Found!",Toast.LENGTH_LONG).show();
        }
        else{
            Log.d("SearchActivity","Result Found Total: "+result.getTotalResultCount());
            Intent productViewIntent = new Intent(getBaseContext(),ProductViewActivity.class);
            productViewIntent.putExtra("zapposResults",result);

        startActivity(productViewIntent);
        }


    }

    private class SearchActivityHelper extends AsyncTask<String, Void, Result>{
        RestController restController = new RestController();
        Result result;
        @Override
        protected Result doInBackground(String... params) {
            String term = params[0];
            result=restController.fetch(term);
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
