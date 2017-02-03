package com.deepakshankar.myapplication.controllers.rest;

import com.deepakshankar.myapplication.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DeepakShankar on 2/3/2017.
 */

public class RestController implements Callback<Result> {
    @Override
    public void onResponse(Call<Result> call, Response<Result> response) {

    }

    @Override
    public void onFailure(Call<Result> call, Throwable t) {

    }
}
