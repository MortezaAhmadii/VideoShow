package com.example.videoshow.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.videoshow.Adopter.VideoSpecialAdopter;
import com.example.videoshow.R;
import com.example.videoshow.database.VideoDatabase;
import com.example.videoshow.databinding.FragmentCategoryBinding;
import com.example.videoshow.databinding.FragmentFavoriteBinding;

import java.util.List;


public class FavoriteFragment extends Fragment {


    VideoDatabase videoDatabase;
    public FavoriteFragment() {
        // Required empty public constructor
    }

    FragmentFavoriteBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentFavoriteBinding.inflate(getLayoutInflater());
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onResume() {
        super.onResume();


        videoDatabase=VideoDatabase.getInstance(getActivity());

        VideoSpecialAdopter adopter=new VideoSpecialAdopter(videoDatabase.idao().getVideoList(),getActivity());
        binding.recyFavorite.setAdapter(adopter);
        binding.recyFavorite.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }
}