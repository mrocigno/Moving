package br.com.mrocigno.moving.Models;

import android.app.Activity;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Database.Session;
import lib.rocigno.usefulthingslib.Session.LoginBuilder.LoginBuilder;

public class LoginModel extends MY_Model {

    private Activity activity;

    public LoginModel(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public boolean logar(String email, String pass){
        DatabaseValues dbv = db.getUser(email, pass);
        if(dbv != null){
            createSession(dbv);
            Session.setNome(dbv.getUser());
            Session.setEmail(dbv.getEmail());
            Session.setId(dbv.getID());
            return true;
        }else{
            return false;
        }

    }

    private void createSession(DatabaseValues dbv){
        new LoginBuilder(activity).create(dbv.getID(), dbv.getEmail(),dbv.getUser(), dbv.getPassword(),"");
    }

}
