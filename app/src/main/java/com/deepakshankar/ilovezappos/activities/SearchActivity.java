package com.deepakshankar.ilovezappos.activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;

import com.deepakshankar.ilovezappos.R;
import com.deepakshankar.ilovezappos.controllers.RestController;
import com.deepakshankar.ilovezappos.model.Cart;
import com.deepakshankar.ilovezappos.model.Result;

import java.util.concurrent.ExecutionException;


/**
 * This is the activity that is used to search the zappos api and get the products.
 * @author Deepak Shankar
 */
public class SearchActivity extends AppCompatActivity {

    Result result;
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Search Zappos!");
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        cart = (Cart) bundle.getSerializable("cart");
    }

    public void searchZappos(View view) {
        EditText searchText = (EditText) findViewById(R.id.search_term);
        String term = searchText.getText().toString();
        Log.d("SearchActivity", "Search term: " + term);
        try {
            result = new SearchActivityHelper().execute(term).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (result == null) {
            Toast.makeText(this, "No results Found!", Toast.LENGTH_LONG).show();
        } else {
            Log.d("SearchActivity", "Result Found Total: " + result.getTotalResultCount());
            Intent productViewIntent = new Intent(getBaseContext(), ProductViewActivity.class);
            productViewIntent.putExtra("zapposResults", result);
            productViewIntent.putExtra("cart", cart);

            startActivity(productViewIntent);
        }


    }

    private class SearchActivityHelper extends AsyncTask<String, Void, Result> {
        RestController restController = new RestController();
        Result result;

        @Override
        protected Result doInBackground(String... params) {
            String term = params[0];
            result = restController.fetch(term);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_view_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.viewShared:
                Intent viewSharedIntent = new Intent(this,GetSharedProductsActivity.class);
                viewSharedIntent.putExtra("zapposResults", result);
                viewSharedIntent.putExtra("cart", cart);
                startActivity(viewSharedIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
