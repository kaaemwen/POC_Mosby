package com.adneom.kdevillard.pocmosby;

import com.adneom.kdevillard.pocmosby.mvp.login.LoginActivity;

import dagger.Component;

/**
 * Created by kdevillard on 23-11-16.
 */
@Component(modules = {ContextModule.class})
public interface MyComponent {
    //A accès à tous les services et détermine tous les inject afin de renvoyer aux Activity les dépendances demandées
    //MyService myService();

    void inject(LoginActivity loginActivity);
}
