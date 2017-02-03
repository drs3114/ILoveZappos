package com.deepakshankar.myapplication.controllers.rest;

import com.deepakshankar.myapplication.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DeepakShankar on 2/3/2017.
 */

public class RestController implements Callback<Result> {

    private static final String API = "https://api.zappos.com";
    private static final String key = "b743e26728e16b81da139182bb2094357c31d331";
    protected Result result;

    public Result getResult() {
        return result;
    }

    public RestController(){
        if(result==null){
            result = new Result();
        }
    }

    public void start(String term){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(API).addConverterFactory(GsonConverterFactory.create()).build();
        ZapposAPI zapposAPI = retrofit.create(ZapposAPI.class);
        Call<Result> call = zapposAPI.getResults(term,key);
        call.enqueue(this);
    }
    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {
        if(response.isSuccessful()){
            result = response.body();
        }
    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {

    }
}
