package com.adneom.kdevillard.pocmosby.mvp.model;

/**
 * Created by kdevillard on 17-11-16.
 */

public class AuthCredentials {
    String username;
    String password;

    public AuthCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }
}
