package com.adneom.kdevillard.pocmosby;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kdevillard on 23-11-16.
 */
@Module
public class ContextModule {
    private final Context context;

    /**
     * Nous ajoutons volontairement un constructeur qui prend un Context en entrée,
     * afin de lui fournir au runtime lors de la création de l'Application
     * @param context l'application créée
     */
    public ContextModule(Context context) {
        this.context = context;
    }

    /**
     * Permet à Dagger2 de récupérer le context
     * @return le context de l'application
     */
    @Provides
    Context provideContext() {
        return context;
    }
}
