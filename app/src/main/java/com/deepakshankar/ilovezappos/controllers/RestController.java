package com.deepakshankar.ilovezappos.controllers;

import android.util.Log;

import com.deepakshankar.ilovezappos.model.Result;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DeepakShankar on 2/3/2017.
 */

/**
 * This is the REST API controller that is used to get the results from the Zappos API using retrofit.
 * @author Deepak Shankar
 */
public class RestController implements Callback<Result> {

    private static final String API = "https://api.zappos.com";
    private static final String key = "b743e26728e16b81da139182bb2094357c31d331";
    public Result result;

    public Result getResult() {
        return result;
    }



    public Result fetch(String term){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API).addConverterFactory(GsonConverterFactory.create()).build();
        ZapposAPI zapposAPI = retrofit.create(ZapposAPI.class);
        Call<Result> call = zapposAPI.getResults(term,key);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        if(response.isSuccessful()){

            this.result = response.body();
            Log.d("RestController","total: "+result.getTotalResultCount());
        }
    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {

    }
}
