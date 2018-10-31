package br.com.mrocigno.moving.Models;

import android.app.Activity;
import android.widget.Toast;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Database.Session;
import lib.rocigno.usefulthingslib.Session.LoginBuilder.LoginBuilder;

public class LoginModel extends MY_Model {

    private Activity activity;

    public LoginModel(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public boolean logar(String user, String pass){
        DatabaseValues dbv = db.getUser(user, pass);
        if(dbv != null){
            createSession(user, pass);
            Session.setNome(dbv.getUser());
            Session.setEmail(dbv.getEmail());
            Session.setId(dbv.getID());
            return true;
        }else{
            return false;
        }

    }

    public void createSession(String user, String pass){
        new LoginBuilder(activity).create(0, user,"", pass,"");
    }

}
