package com.twtstudio.one;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.orhanobut.hawk.Hawk;
import com.twtstudio.one.dao.AppDataBase;

/**
 * Created by jcy on 2016/5/9.
 */
public class OneApp extends Application {
    public static Context context;

    private static AppDataBase db = null;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this,AppDataBase.class,"myDataBase").build();
        Hawk.init(this).build();
//        Log.d("22","build!");

    }

    public static Context getContext() {
        return context;
    }

    public static AppDataBase getDb() {
        return db;
    }
}

