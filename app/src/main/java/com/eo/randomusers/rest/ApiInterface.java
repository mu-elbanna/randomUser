package com.eo.randomusers.rest;


import com.eo.randomusers.model.UsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("api/")
    Call<UsersResponse> getUsersList(@Query("results") int count);

}