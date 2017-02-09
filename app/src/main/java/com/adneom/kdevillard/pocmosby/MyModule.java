package com.adneom.kdevillard.pocmosby;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kdevillard on 23-11-16.
 */
@Module
public class MyModule {
    //Contient tous les @Provides permettant de créer des dépendances aux services


    @Provides
    public MyService provideMyService(){
        return new MyService();
    }
}
