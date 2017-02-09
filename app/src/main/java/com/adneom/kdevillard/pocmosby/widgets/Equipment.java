package com.adneom.kdevillard.pocmosby.widgets;

import android.graphics.drawable.Drawable;

import com.adneom.kdevillard.pocmosby.R;

/**
 * Created by kdevillard on 21-11-16.
 */

public class Equipment extends Widget{
    private String equipmentName;
    private String number;

    public Equipment() {}

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I'm an equipment widget !");
    }

    @Override
    public String getName() {
        return "Equipment widget";
    }

    @Override
    public int getId() {
        return 3;
    }

    @Override
    public int getImg() {
        return R.drawable.widget_equipment;
    }
}
