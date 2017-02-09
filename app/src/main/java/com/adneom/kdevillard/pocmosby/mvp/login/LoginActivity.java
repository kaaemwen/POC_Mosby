package com.adneom.kdevillard.pocmosby.mvp.login;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.adneom.kdevillard.pocmosby.MyModule;
import com.adneom.kdevillard.pocmosby.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer, new LoginFragment())
                    .commit();
        }

        //this.myService = Application.app().component().myService();
        //Application.app().component().inject(this);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}

