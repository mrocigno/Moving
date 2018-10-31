package br.com.mrocigno.moving.Models;

import android.app.Activity;

import br.com.mrocigno.moving.Database.Database;

public class MY_Model {
    public Database db;

    public MY_Model(Activity activity) {
        this.db = new Database(activity);
    }
}
