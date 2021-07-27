package com.example.videoshow.api;

import android.util.Log;

import com.example.videoshow.models.Category;
import com.example.videoshow.models.News;
import com.example.videoshow.models.Videos;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviseCaller {

    IService iService;

    public WebserviseCaller() {
        iService = ApiClient.getRetrofit().create(IService.class);

    }


    public void getBestVideos(IMessageListener listener) {

        Call<List<Videos>> getBestVideos = iService.getBestVideos();

        getBestVideos.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                listener.responseMessage(response.body());
            }

            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                listener.errorResponseMassage(t.getMessage().toString());
                Log.e("", "");

            }
        });


    }

    public void getNewVideos(IMessageListener listener) {

        Call<List<Videos>> getNewVideos = iService.getNewVideos();

        getNewVideos.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                listener.responseMessage(response.body());
                Log.e("", "");
            }

            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                listener.errorResponseMassage(t.getMessage().toString());
                Log.e("", "");

            }
        });
    }

    public void getNews(IMessageListener listener) {

        Call<List<News>> getNews = iService.getNews();

        getNews.enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                listener.responseMessage(response.body());
                Log.e("", "");
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                listener.errorResponseMassage(t.getMessage().toString());
                Log.e("", "");

            }
        });
    }

    public void getAllCategory(IMessageListener listener){

        Call<List<Category>> catList=iService.getCategory();

        catList.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {

                listener.responseMessage(response.body());
                Log.e("", "");

            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

                listener.errorResponseMassage(t.getMessage().toString());
                Log.e("", "");

            }
        });


    }


    public void getSpecial(IMessageListener listener) {

        Call<List<Videos>> getSpecial = iService.getSpecial();

        getSpecial.enqueue(new Callback<List<Videos>>() {
            @Override
            public void onResponse(Call<List<Videos>> call, Response<List<Videos>> response) {
                listener.responseMessage(response.body());
                Log.e("", "");
            }

            @Override
            public void onFailure(Call<List<Videos>> call, Throwable t) {
                listener.errorResponseMassage(t.getMessage().toString());
                Log.e("", "");

            }
        });
    }


}
