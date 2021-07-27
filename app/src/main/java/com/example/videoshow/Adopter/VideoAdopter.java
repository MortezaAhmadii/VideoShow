package com.example.videoshow.Adopter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoshow.Activity.VideoPlayActivity;
import com.example.videoshow.R;
import com.example.videoshow.models.Videos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdopter extends RecyclerView.Adapter<VideoAdopter.VideoVH> {


    List<Videos>videosList;
    Context context;
    public VideoAdopter(List<Videos>videosList,Context context){
        this.context=context;
        this.videosList=videosList;
    }


    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.video_row,null);
        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {


        Videos videos=videosList.get(position);

        holder.video_title.setText(videos.getTitle());
        holder.video_dec.setText(videos.getDescription());
        holder.view_vid.setText(videos.getView());
        holder.Video_time.setText(videos.getTime());

        Picasso.get().load(videos.getIcon()).into(holder.img_video);

        holder.vid_relative.setOnClickListener(new View.OnClickListener() {
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



        AppCompatTextView video_title,video_dec,view_vid,Video_time;
        AppCompatImageView img_video;
        RelativeLayout vid_relative;

        public VideoVH(@NonNull View itemView)
        {
            super(itemView);


            img_video=itemView.findViewById(R.id.img_video);
            video_title=itemView.findViewById(R.id.video_title);
            video_dec=itemView.findViewById(R.id.video_dec);
            view_vid=itemView.findViewById(R.id.view_vid);
            vid_relative=itemView.findViewById(R.id.vid_relative);
            Video_time=itemView.findViewById(R.id.Video_time);

        }
    }
}
