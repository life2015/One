package com.twtstudio.one;

import android.app.Application;
import android.content.Context;

/**
 * Created by jcy on 2016/5/9.
 */
public class OneApp extends Application {
    public static Context context;

    public static Context getContext() {
        return context;
    }
}
