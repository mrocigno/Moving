package br.com.mrocigno.moving.Models;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.Database;
import br.com.mrocigno.moving.Database.DatabaseValues;

public class AlterarSenhaModel extends MY_Model {

    Activity activity;

    public AlterarSenhaModel(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public void updatePass(DatabaseValues dbv){
        db.updatePass(dbv);
    }

    public boolean verifieCurrentPass(String currentPass, int id){
        Toast.makeText(activity, currentPass + "  " + id, Toast.LENGTH_LONG).show();
        ArrayList<DatabaseValues> values = db.getValues("SELECT * FROM " + Database.getTABLE() + " WHERE " + Database.getPASSWORD() + " = '" + currentPass + "' AND " + Database.getID() + " = " + id);
        return values.size() > 0;
    }

}
