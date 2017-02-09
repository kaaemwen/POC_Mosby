package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

import com.adneom.kdevillard.pocmosby.R;

/**
 * Created by kdevillard on 21-11-16.
 */

public class Indicator extends Widget {
    private String propertyName;
    private String propertyValue;

    public Indicator(){}

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyName(){
        return propertyName;
    }

    public String getPropertyValue(){
        return propertyValue;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm an Indicator widget !");
    }

    @Override
    public String getName() {
        return "Indicator widget";
    }

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public int getImg() {
        return R.drawable.widget_indicator;
    }
}
