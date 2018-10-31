package br.com.mrocigno.moving.Models;

import android.app.Activity;

import lib.rocigno.usefulthingslib.Session.LoginBuilder.LoginBuilder;
import lib.rocigno.usefulthingslib.Session.LoginBuilder.UserModel;

public class SplashModel extends LoginBuilder {

    Activity activity;

    public SplashModel(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    private boolean verifie;
    public boolean verifieIfLoged(){
        isLoged(new isLogedCallback() {
            @Override
            public void onIsLoged(UserModel userModel) {
                verifie = true;
            }

            @Override
            public void onIsNotLoged() {
                verifie = false;
            }
        });
        return verifie;
    }
}
