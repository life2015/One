package com.twtstudio.one.model;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by jcy on 2016/5/10.
 */
public class BitmapSerziable implements Serializable {
    Bitmap bitmap;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public BitmapSerziable() {
    }

}
