package com.deepakshankar.ilovezappos.controllers;

import com.deepakshankar.ilovezappos.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DeepakShankar on 2/3/2017.
 */

public interface ZapposAPI {

    @GET("/Search")
    Call<Result> getResults(@Query("term") String term, @Query("key") String key);
}
