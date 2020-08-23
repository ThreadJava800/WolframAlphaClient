package com.example.wolframalphaclient.API;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface WolframAPI {

    @GET("query")
    Call<RSSModel> getAnswer(@Query("input") String request,
                             @Query("appid") String appId);
}
