package br.com.mrocigno.moving.Models;

import android.app.Activity;

import br.com.mrocigno.moving.Database.Database;

class MY_Model {
    Database db;

    MY_Model(Activity activity) {
        this.db = new Database(activity);
    }
}
