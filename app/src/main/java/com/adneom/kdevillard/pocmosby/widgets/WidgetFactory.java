package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

/**
 * Created by kdevillard on 21-11-16.
 */

public class WidgetFactory {
    public static Widget getWidget(String type){
        switch (type){
            case "alarm" :
                return new Alarm();
            case "graph" :
                return new Graph();
            case "indicator" :
                return new Indicator();
            case "equipment" :
                return new Equipment();
            case "datacenter" :
                return new DataCenter();
            default :
                return null;
        }
    }
}
