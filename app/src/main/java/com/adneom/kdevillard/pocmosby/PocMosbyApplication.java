package com.adneom.kdevillard.pocmosby;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by kdevillard on 17-11-16.
 */

public class PocMosbyApplication extends android.app.Application {
    protected MyComponent myComponent;
    protected static Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        //Création du component pour le stocker dans l'application
        myComponent = DaggerMyComponent.builder()
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public static Application app() {
        return application;
    }

    //permet aux activités via .getApplication().appComponent() de récupérer le AppComponent
    public MyComponent component() {
        return myComponent;
    }
}
