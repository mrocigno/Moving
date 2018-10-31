package br.com.mrocigno.moving.Presenters;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Models.ListaModel;

public class ListaPresenter {

    ListaInterface listaInterface;
    ListaModel listaModel;

    public ListaPresenter(ListaInterface listaInterface, ListaModel listaModel) {
        this.listaInterface = listaInterface;
        this.listaModel = listaModel;
    }

    public void fillArray(){
        ArrayList<DatabaseValues> values = listaModel.getUsers();
        listaInterface.onLoad(values);
    }

}
