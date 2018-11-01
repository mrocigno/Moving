package br.com.mrocigno.moving.Models;

import android.app.Activity;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.Database;
import br.com.mrocigno.moving.Database.DatabaseValues;

public class CadastroModel extends MY_Model {

    public CadastroModel(Activity activity) {
        super(activity);
    }

    public boolean verifieUser(String user) {
        ArrayList<DatabaseValues> values = db.getValues("SELECT * FROM " + Database.getTABLE() + " WHERE " + Database.getUSER() + " = '" + user + "'");
        return values.size() > 0;
    }

    public boolean verifieEmail(String email) {
        ArrayList<DatabaseValues> values = db.getValues("SELECT * FROM " + Database.getTABLE() + " WHERE " + Database.getEMAIL() + " = '" + email + "'");
        return values.size() > 0;
    }

    public void cadastrar(DatabaseValues dbv) {
        db.insert(dbv);
    }

}
