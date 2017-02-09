package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

import com.adneom.kdevillard.pocmosby.R;

/**
 * Created by kdevillard on 21-11-16.
 */

public class DataCenter extends Widget {
    private String address;

    public DataCenter() {}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm a DataCenter widget !");
    }

    @Override
    public String getName() {
        return "Datacenter widget";
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public int getImg() {
        return R.drawable.widget_datacenter;
    }
}
