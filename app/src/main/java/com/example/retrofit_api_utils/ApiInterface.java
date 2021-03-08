package com.example.retrofit_api_utils;

import com.example.Utils.Urls;
import com.example.module.Articles;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by
 * Dilipkumar R. Kaklotar
 * [ Senior Android Developer ]
 * Mobile: +91 8000722607
 * Skype: dilipkaklotar
 * Created On 2019-06-13.
 */
public interface ApiInterface {

    @GET("/v2/top-headlines?sources=techcrunch&apiKey=29b45a7757e04d63b188ff6777eefb34")
    Call<Articles> getArticles();

}
