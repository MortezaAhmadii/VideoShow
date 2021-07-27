package com.example.videoshow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.videoshow.Adopter.VideoPlayAdopter;
import com.example.videoshow.R;
import com.example.videoshow.api.IMessageListener;
import com.example.videoshow.api.WebserviseCaller;
import com.example.videoshow.database.IDAO;
import com.example.videoshow.database.VideoDatabase;
import com.example.videoshow.databinding.ActivityVideoPlayBinding;
import com.example.videoshow.models.Videos;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;

import java.util.List;


public class VideoPlayActivity extends AppCompatActivity {


    ActivityVideoPlayBinding binding;


    Videos videos;
    Bundle bundle;
    SimpleExoPlayer player;
    WebserviseCaller webserviseCaller;
    VideoDatabase videoDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityVideoPlayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        videoDatabase=VideoDatabase.getInstance(getApplicationContext());

        bundle=getIntent().getExtras();
        videos=bundle.getParcelable("VideoObj");
        player=new SimpleExoPlayer.Builder(getApplicationContext()).build();
        webserviseCaller=new WebserviseCaller();


        Log.e("","");
        binding.txtArr.setText(videos.getTitle());

        binding.backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        binding.playerView.setPlayer(player);

        Uri uri=Uri.parse(videos.getLink());
        MediaItem mediaItem=MediaItem.fromUri(uri);
        player.setMediaItem(mediaItem);
        player.prepare();
        player.play();

        binding.VideoTitle.setText(videos.getTitle());
        binding.vidDecription.setText(videos.getDescription());
        binding.seenVid.setText(videos.getView());

        binding.imgShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                String txt=videos.getTitle();
                i.putExtra(android.content.Intent.EXTRA_TEXT, txt);
                startActivity(Intent.createChooser(i, "Share via"));            }
        });

        webserviseCaller.getSpecial(new IMessageListener() {
            @Override
            public void responseMessage(Object responseMessage) {
                Log.e("","");
                VideoPlayAdopter adopter=new VideoPlayAdopter((List<Videos>) responseMessage,getApplicationContext());
                binding.recycleSpecialPlayActivity.setAdapter(adopter);
                LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);
                binding.recycleSpecialPlayActivity.setLayoutManager(linearLayoutManager);

                Log.e("","");
            }

            @Override
            public void errorResponseMassage(String errorResponceMessage) {

            }
        });
        Log.e("","");


        if (videoDatabase.idao().isExist(Integer.parseInt(videos.getId()))){
            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
            Log.e("","");


        }else{

            binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
            Log.e("","");

        }




        binding.imgFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("","");
                if (videoDatabase.idao().isExist(Integer.parseInt(videos.getId()))){

                    binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24);
                    videoDatabase.idao().deleteVideo(Integer.parseInt(videos.getId()));


                }else {



                    binding.imgFavorite.setImageResource(R.drawable.ic_baseline_favorite_24);
                    videoDatabase.idao().insert(videos);



                }

                Log.e("","");




            }
        });
    }





    @Override
    protected void onStop() {
        super.onStop();



        if (player!=null){

            player.stop(true);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();



    }
}