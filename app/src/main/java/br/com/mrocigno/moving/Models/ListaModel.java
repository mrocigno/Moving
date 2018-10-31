package br.com.mrocigno.moving.Models;

import android.app.Activity;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.Database;
import br.com.mrocigno.moving.Database.DatabaseValues;

public class ListaModel extends MY_Model {
    Activity activity;

    public ListaModel(Activity activity) {
        super(activity);
        this.activity = activity;
    }

    public ArrayList<DatabaseValues> getUsers(){
        return db.getValues("SELECT * FROM " + Database.getTABLE());
    }

}
