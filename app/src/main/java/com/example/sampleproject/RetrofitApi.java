package com.example.sampleproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("posts")
    Call<List<Product>> getProduct();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    RetrofitApi apiService = retrofit.create(RetrofitApi.class);
}
