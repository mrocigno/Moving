package br.com.mrocigno.moving.Models;

import android.app.Activity;

import br.com.mrocigno.moving.Database.Session;
import lib.rocigno.usefulthingslib.Session.LoginBuilder.LoginBuilder;
import lib.rocigno.usefulthingslib.Session.LoginBuilder.UserModel;

public class SplashModel extends LoginBuilder {

    public SplashModel(Activity activity) {
        super(activity);
    }

    private boolean verifie;

    public boolean verifieIfLoged() {
        isLoged(new isLogedCallback() {
            @Override
            public void onIsLoged(UserModel userModel) {
                Session.setNome(userModel.getUser_name());
                Session.setEmail(userModel.getUser());
                Session.setId(userModel.getId());
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
