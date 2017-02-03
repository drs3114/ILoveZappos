package com.deepakshankar.myapplication.rest.service;

import com.deepakshankar.myapplication.model.Result;

import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by DeepakShankar on 1/28/2017.
 */

public interface ZapposApiService {

    @GET("/Search?term={term}&key=b743e26728e16b81da139182bb2094357c31d331")
    public void search(@Path("term") String term, Callback<Result> response);
}
