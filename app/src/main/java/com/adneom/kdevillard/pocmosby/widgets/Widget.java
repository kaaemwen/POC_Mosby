package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by kdevillard on 21-11-16.
 */

public abstract class Widget implements Serializable{
    int id;
    String name;
    int dimHeigth;
    int dimWidth;
    int img;

    abstract void sayHello();
    public abstract String getName();
    public abstract int getId();
    public abstract int getImg();
}
