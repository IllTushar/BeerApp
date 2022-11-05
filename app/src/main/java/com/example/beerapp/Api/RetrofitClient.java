package com.example.beerapp.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit;
    private String BASE_URL ="https://random-data-api.com/api/v2/";
    public Retrofit getRetrofit(){
        if (retrofit==null){
          retrofit = new Retrofit.Builder()
                  .addConverterFactory(GsonConverterFactory.create())
                  .baseUrl(BASE_URL)
                  .build();
        }
        return retrofit;
    }
}
