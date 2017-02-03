package com.deepakshankar.myapplication.rest.service;

import com.deepakshankar.myapplication.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DeepakShankar on 1/28/2017.
 */

public interface ZapposApiService {

    @GET("/Search?key=b743e26728e16b81da139182bb2094357c31d331")
    Call<Result> fetchResults(@Query("term") String term);
}
