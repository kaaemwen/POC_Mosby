package com.adneom.kdevillard.pocmosby.mvp.login;

import android.support.test.espresso.core.deps.guava.eventbus.EventBus;
import android.util.Log;
import android.widget.Toast;

import com.adneom.kdevillard.pocmosby.mvp.model.AccountManager;
import com.adneom.kdevillard.pocmosby.mvp.model.AuthCredentials;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import javax.inject.Inject;

/**
 * Created by kdevillard on 17-11-16.
 */

public class LoginPresenter extends MvpBasePresenter<LoginView>{
    private AccountManager accountManager;
    private AuthCredentials subscriber;
    private EventBus eventBus;
    private boolean loginDone = false;

    @Inject
    public LoginPresenter(AccountManager accountManager, EventBus eventBus) {
        this.accountManager = accountManager;
        this.eventBus = eventBus;
    }

    public void doLogin(AuthCredentials credentials) {

        if (isViewAttached()) {
            getView().showLoading();
        }

        if (credentials.getUsername().equals("") || credentials.getPassword().equals("")){
            getView().showError();
        } else {
            // do the login
            try{
                loginDone = accountManager.doLogin(credentials);
            }catch (Exception e){
                Log.i("ERROR", e.getMessage());
                getView().showError();
            }

            if(!loginDone && isViewAttached()){
                getView().showError();
            }

            if(loginDone && isViewAttached()){
                getView().showSuccessfulLogin();
            }
        }


    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

    @Override
    public void attachView(LoginView view) {
        super.attachView(view);
    }
}
