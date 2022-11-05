package com.example.beerapp.Api;

import com.example.beerapp.Model.ResponseClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices
{
  @GET("beers?size=10&response_type=json")
    Call<List<ResponseClass>>getData();
}
