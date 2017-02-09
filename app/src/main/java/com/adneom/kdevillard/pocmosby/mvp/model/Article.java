package com.adneom.kdevillard.pocmosby.mvp.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by kdevillard on 18-11-16.
 */

public class Article implements Serializable {

    protected String title;
    protected String description;
    protected Drawable photo;

    public Article(String title, String description, Drawable photo){
        this.title = title;
        this.description = description;
        this.photo = photo;
    }

    public Article(Article art){
        this.title = art.getTitle();
        this.description = art.getDescription();
        this.photo = art.getPhoto();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Drawable getPhoto() {
        return photo;
    }
}
