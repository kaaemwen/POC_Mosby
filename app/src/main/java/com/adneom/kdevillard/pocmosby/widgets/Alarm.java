package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

import com.adneom.kdevillard.pocmosby.R;

/**
 * Created by kdevillard on 21-11-16.
 */

public class Alarm extends Widget {
    private String hour;

    public Alarm(){
        this.id = 1;
        this.name = "Alarm widget";
        this.img = R.drawable.widget_alarm;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getHour(){
        return hour;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm an alarm widget");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public int getImg() {
        return this.img;
    }

}
