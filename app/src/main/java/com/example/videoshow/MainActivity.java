package com.example.videoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.videoshow.Activity.VideoPlayActivity;
import com.example.videoshow.Adopter.TabsAdopter;
import com.example.videoshow.Fragment.CategoryFragment;
import com.example.videoshow.Fragment.FavoriteFragment;
import com.example.videoshow.Fragment.HomeFragment;
import com.example.videoshow.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new FavoriteFragment());
        TabsAdopter adopter = new TabsAdopter(getSupportFragmentManager(), fragmentList);
        binding.pager.setAdapter(adopter);




        setSupportActionBar(binding.toolbarTool);



        binding.btmNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.item_home:

                        binding.pager.setCurrentItem(0);
                        binding.btmNav.getMenu().getItem(0).setChecked(true);

                        break;


                    case R.id.item_category:
                        binding.pager.setCurrentItem(1);
                        binding.btmNav.getMenu().getItem(1).setChecked(true);

                        break;

                    case R.id.item_favorite:
                        binding.pager.setCurrentItem(2);
                        binding.btmNav.getMenu().getItem(2).setChecked(true);

                        break;


                }

                return false;
            }
        });

        binding.pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {

                    case 0:
                        binding.btmNav.getMenu().getItem(0).setChecked(true);

                        break;


                    case 1:

                        binding.btmNav.getMenu().getItem(1).setChecked(true);
                        break;


                    case 2:
                        binding.btmNav.getMenu().getItem(2).setChecked(true);

                        break;

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menuflew,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){



            case R.id.Exit:

                finishAffinity();
                break;


        }


        return super.onOptionsItemSelected(item);
    }
}