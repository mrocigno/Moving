package br.com.mrocigno.moving.Presenters;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.DatabaseValues;

public interface ListaInterface extends DefaultInterface {
    void onLoad(ArrayList<DatabaseValues> values);
}
