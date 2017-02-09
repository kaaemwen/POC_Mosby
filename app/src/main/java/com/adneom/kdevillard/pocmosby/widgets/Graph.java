package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

import com.adneom.kdevillard.pocmosby.R;

/**
 * Created by kdevillard on 21-11-16.
 */

public class Graph extends Widget {
    private int AxeX;
    private int AxeY;

    public Graph(){}

    public int getAxeX(){
        return AxeX;
    }

    public int getAxeY(){
        return AxeY;
    }

    public void setAxeX(int axeX) {
        AxeX = axeX;
    }

    public void setAxeY(int axeY) {
        AxeY = axeY;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm a Graph widget !");
    }

    @Override
    public String getName() {
        return "Graph widget";
    }

    @Override
    public int getId() {
        return 4;
    }

    @Override
    public int getImg() {
        return R.drawable.widget_graph;
    }
}
