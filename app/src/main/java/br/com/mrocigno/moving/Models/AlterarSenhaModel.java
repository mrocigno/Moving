package br.com.mrocigno.moving.Models;

import android.app.Activity;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.Database;
import br.com.mrocigno.moving.Database.DatabaseValues;

public class AlterarSenhaModel extends MY_Model {

    public AlterarSenhaModel(Activity activity) {
        super(activity);
    }

    public void updatePass(DatabaseValues dbv) {
        db.updatePass(dbv);
    }

    public boolean verifieCurrentPass(String currentPass, int id) {
        ArrayList<DatabaseValues> values = db.getValues("SELECT * FROM " + Database.getTABLE() + " WHERE " + Database.getPASSWORD() + " = '" + currentPass + "' AND " + Database.getID() + " = " + id);
        return values.size() > 0;
    }

}
