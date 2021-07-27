package com.example.videoshow.AppConfiguration;

import android.app.Application;

import androidx.multidex.MultiDex;

public class AppConf extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MultiDex.install(this);
    }
}
