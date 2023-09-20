package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("news?cate=&hot=false&offset=0&limit=30&with_content=true")
    Call<List<NewsItem>> getNews();
}
