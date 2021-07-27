package com.example.videoshow.api;

import com.example.videoshow.models.Category;
import com.example.videoshow.models.News;
import com.example.videoshow.models.Videos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IService {


    @GET("getBestVideos.php")
    Call<List<Videos>> getBestVideos();

    @GET("getNewVideos.php")
    Call<List<Videos>> getNewVideos();


    @GET("getSpecial.php")
    Call<List<Videos>> getSpecialVideos();

    @GET("getCategory.php")
    Call<List<Category>> getCategory();


    @GET("getNews.php")
    Call<List<News>> getNews();

    @GET("getSpecial.php")
    Call<List<Videos>> getSpecial();




}
