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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videoshow.Activity.VideoPlayActivity;
import com.example.videoshow.R;
import com.example.videoshow.models.Videos;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoSpecialAdopter extends RecyclerView.Adapter<VideoSpecialAdopter.VideoVH> {


    List<Videos>videosList;
    Context context;
    public VideoSpecialAdopter(List<Videos>videosList, Context context){
        this.context=context;
        this.videosList=videosList;
    }


    @NonNull
    @Override
    public VideoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.video_roww,null);
        return new VideoVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoVH holder, int position) {


        Videos videos=videosList.get(position);

        holder.title_spVid.setText(videos.getTitle());
        holder.dec_spVid.setText(videos.getDescription());
        holder.seen_spVid.setText(videos.getView());
        holder.vid_time.setText(videos.getTime());


        Picasso.get().load(videos.getIcon()).into(holder.img_spVid);

        holder.Constraint_vid.setOnClickListener(new View.OnClickListener() {
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



        AppCompatTextView title_spVid,dec_spVid,seen_spVid,vid_time;
        AppCompatImageView img_spVid;
        ConstraintLayout Constraint_vid;

        public VideoVH(@NonNull View itemView)
        {
            super(itemView);


            img_spVid=itemView.findViewById(R.id.img_spVid);
            title_spVid=itemView.findViewById(R.id.title_spVid);
            dec_spVid=itemView.findViewById(R.id.dec_spVid);
            seen_spVid=itemView.findViewById(R.id.seen_spVid);
            Constraint_vid=itemView.findViewById(R.id.Constraint_vid);
            vid_time=itemView.findViewById(R.id.vid_time);

        }
    }
}
