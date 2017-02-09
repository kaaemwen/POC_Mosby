package com.adneom.kdevillard.pocmosby.mvp.model;

/**
 * Created by kdevillard on 17-11-16.
 */

public class AccountManager {
    private AuthCredentials currentAccount;

    public boolean doLogin(AuthCredentials credentials) {
        if (credentials.getUsername().equals("") || credentials.getPassword().equals("")){
            return false;
        }
        currentAccount = new AuthCredentials(credentials.getUsername(), credentials.getPassword());
        return true;
    }

    public AuthCredentials getCurrentAccount() {
        return currentAccount;
    }

    public boolean isUserAuthenticated() {
        return currentAccount != null;
    }
}
