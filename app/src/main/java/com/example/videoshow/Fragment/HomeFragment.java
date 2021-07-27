package com.example.videoshow.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.videoshow.Adopter.NewsAdopter;
import com.example.videoshow.Adopter.VideoAdopter;
import com.example.videoshow.Adopter.VideoSpecialAdopter;
import com.example.videoshow.R;
import com.example.videoshow.api.IMessageListener;
import com.example.videoshow.api.WebserviseCaller;
import com.example.videoshow.models.News;
import com.example.videoshow.models.Videos;

import java.util.List;


public class HomeFragment extends Fragment {

    WebserviseCaller webserviseCaller;
    RecyclerView recyclerView,recycler_special,recycler_vidSpicial;
    ProgressBar progressBar,progressBar1;
    ViewPager newsPager;
    Toolbar toolbar;

    public HomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view=inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView=view.findViewById(R.id.recycler_newVid);
        recycler_special=view.findViewById(R.id.recycler_special);
        //toolbar=view.findViewById(R.id.toolbar);
        recycler_vidSpicial=view.findViewById(R.id.recycler_vidSpicial);

        progressBar=view.findViewById(R.id.progress);
        progressBar1=view.findViewById(R.id.progressBar1);
        newsPager=view.findViewById(R.id.newsPager);

        webserviseCaller=new WebserviseCaller();
        //((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        progressBar.setVisibility(View.VISIBLE);
        webserviseCaller.getBestVideos(new IMessageListener() {
            @Override
            public void responseMessage(Object responseMessage) {

                Log.e("","");

                progressBar.setVisibility(View.GONE);
                VideoAdopter adopter=new VideoAdopter((List<Videos>)responseMessage,getActivity());
                recyclerView.setAdapter(adopter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));



            }

            @Override
            public void errorResponseMassage(String errorResponceMessage) {

                Log.e("","");

            }
        });


        progressBar1.setVisibility(View.VISIBLE);
        webserviseCaller.getNewVideos(new IMessageListener() {
            @Override
            public void responseMessage(Object responseMessage) {

                Log.e("","");

                progressBar1.setVisibility(View.GONE);
                VideoAdopter adopter=new VideoAdopter((List<Videos>)responseMessage,getActivity());
                recycler_special.setAdapter(adopter);
                recycler_special.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));



            }

            @Override
            public void errorResponseMassage(String errorResponceMessage) {

                Log.e("","");

            }
        });


        webserviseCaller.getNews(new IMessageListener() {
            @Override
            public void responseMessage(Object responseMessage) {

                Log.e("","");

                newsPager.setAdapter(new NewsAdopter((List<News>)responseMessage,getActivity()));



            }

            @Override
            public void errorResponseMassage(String errorResponceMessage) {

                Log.e("","");

            }
        });

        webserviseCaller.getSpecial(new IMessageListener() {
            @Override
            public void responseMessage(Object responseMessage) {

                Log.e("","");
                VideoSpecialAdopter specialVideos=new VideoSpecialAdopter((List<Videos>) responseMessage,getActivity());
                recycler_vidSpicial.setAdapter(specialVideos);
                recycler_vidSpicial.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
            }

            @Override
            public void errorResponseMassage(String errorResponceMessage) {

                Log.e("","");

            }
        });







        return  view;
    }
}