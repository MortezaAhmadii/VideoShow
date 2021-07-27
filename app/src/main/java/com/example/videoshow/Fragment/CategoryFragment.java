package com.example.videoshow.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.videoshow.Adopter.CategoryAdopter;
import com.example.videoshow.R;
import com.example.videoshow.api.IMessageListener;
import com.example.videoshow.api.WebserviseCaller;
import com.example.videoshow.databinding.FragmentCategoryBinding;
import com.example.videoshow.models.Category;

import java.util.List;


public class CategoryFragment extends Fragment {

    public CategoryFragment() {
        // Required empty public constructor
    }

    FragmentCategoryBinding binding;
    WebserviseCaller webserviseCaller;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding=FragmentCategoryBinding.inflate(getLayoutInflater());
        webserviseCaller=new WebserviseCaller();

        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webserviseCaller.getAllCategory(new IMessageListener() {
            @Override
            public void responseMessage(Object responseMessage) {

            CategoryAdopter categoryAdopter= new CategoryAdopter((List<Category>)responseMessage);
            binding.recyclerCategory.setAdapter(categoryAdopter);
            binding.recyclerCategory.setLayoutManager(new GridLayoutManager(getActivity(),2));


           }

            @Override
            public void errorResponseMassage(String errorResponceMessage) {

            }
        });






    }
}