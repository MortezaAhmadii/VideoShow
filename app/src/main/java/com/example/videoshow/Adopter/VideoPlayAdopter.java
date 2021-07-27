package com.example.videoshow.Adopter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoshow.Activity.VideoPlayActivity;
import com.example.videoshow.R;
import com.example.videoshow.models.Videos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoPlayAdopter extends RecyclerView.Adapter<VideoPlayAdopter.VideoVH> {


    List<Videos>videosList;
    Context context;
    public VideoPlayAdopter(List<Videos>videosList, Context context){
        this.context=context;
        this.videosList=videosList;
    }


    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.videoplay_row,null);
        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {


        Videos videos=videosList.get(position);

        holder.title_vid.setText(videos.getTitle());
        holder.dec_cid.setText(videos.getDescription());
        holder.seen_video.setText(videos.getView());
        holder.video_time.setText(videos.getTime());


        Picasso.get().load(videos.getIcon()).into(holder.img_play_vid);

        holder.card_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, VideoPlayActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("VideoObj",videos);
                context.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return videosList.size();
    }


    public class VideoVH extends RecyclerView.ViewHolder {



        AppCompatTextView title_vid,dec_cid,seen_video,video_time;
        AppCompatImageView img_play_vid;
        ConstraintLayout card_click;

        public VideoVH(@NonNull View itemView)
        {
            super(itemView);


            img_play_vid=itemView.findViewById(R.id.img_play_vid);
            title_vid=itemView.findViewById(R.id.title_vid);
            dec_cid=itemView.findViewById(R.id.dec_cid);
            seen_video=itemView.findViewById(R.id.seen_video);
            card_click=itemView.findViewById(R.id.card_click);
            video_time=itemView.findViewById(R.id.video_time);

        }
    }
}
