package com.example.videoshow.database;

import android.util.Log;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.videoshow.models.Videos;

import java.util.List;

@Dao
public interface IDAO {

    @Insert
    long insert(Videos videos);

    @Update
    void update(Videos videos);

    @Delete
    void delete(Videos videos);


    @Query("select * from tbl_video")
    List<Videos>getVideoList();


    @Query("SELECT EXISTS (select * from tbl_video WHERE id = :id)" )
    boolean isExist(int id);

    @Query("delete  FROM tbl_video WHERE id = :id")
    void deleteVideo(int id);



}
