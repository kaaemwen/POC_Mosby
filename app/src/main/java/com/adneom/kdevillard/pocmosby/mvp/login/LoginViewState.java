package com.adneom.kdevillard.pocmosby.mvp.login;

import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

/**
 * Created by kdevillard on 17-11-16.
 */

public class LoginViewState implements ViewState<LoginView>{
    final int STATE_SHOW_LOGIN_FORM = 0;
    final int STATE_SHOW_LOADING = 1;
    final int STATE_SHOW_ERROR = 2;
    final int STATE_SHOW_SUCCESFULL_LOGIN = 3;

    int state = STATE_SHOW_LOGIN_FORM;

    public void setShowLoginForm() {
        state = STATE_SHOW_LOGIN_FORM;
    }

    public void setShowError() {
        state = STATE_SHOW_ERROR;
    }

    public void setShowLoading() { state = STATE_SHOW_LOADING; }

    public void setShowSuccessfulLogin() { state = STATE_SHOW_SUCCESFULL_LOGIN; }

    /**
     * Is called from Mosby to apply the view state to the view.
     * We do that by calling the methods from the View interface (like the presenter does)
     */
    @Override public void apply(LoginView view, boolean retained) {
        switch (state) {
            case STATE_SHOW_LOADING:
                view.showLoading();
                break;

            case STATE_SHOW_ERROR:
                view.showError();
                break;

            case STATE_SHOW_LOGIN_FORM:
                view.showLoginForm();
                break;

            case STATE_SHOW_SUCCESFULL_LOGIN:
                view.showSuccessfulLogin();
                break;
        }
    }
}
