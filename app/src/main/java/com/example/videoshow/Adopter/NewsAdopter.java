package com.example.videoshow.Adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.videoshow.R;
import com.example.videoshow.models.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdopter extends PagerAdapter {

    List<News>newsList;
    Context context;
    public NewsAdopter(List<News>newsList,Context context){
    this.newsList=newsList;
    this.context=context;
    }
    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view.equals(object);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View view= LayoutInflater.from(context).inflate(R.layout.news_row,null);


        AppCompatImageView img_news=view.findViewById(R.id.img_news);


        container.addView(view,0);

        News news=newsList.get(position);
        Picasso.get().load(news.getIcon()).into(img_news);





        return view;
    }
}
