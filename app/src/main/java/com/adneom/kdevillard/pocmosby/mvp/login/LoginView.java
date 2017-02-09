package com.adneom.kdevillard.pocmosby.mvp.login;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by kdevillard on 17-11-16.
 */

public interface LoginView extends MvpView {
    // Shows the login form
    void showLoginForm();

    // Called if username / password is incorrect
    void showError();

    // Shows a loading animation while checking auth credentials
    void showLoading();

    // Called if sign in was successful. Finishes the activity. User is authenticated afterwards.
    void showSuccessfulLogin();
}
