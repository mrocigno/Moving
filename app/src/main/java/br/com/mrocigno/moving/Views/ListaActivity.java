package br.com.mrocigno.moving.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Models.ListaModel;
import br.com.mrocigno.moving.Presenters.ListaInterface;
import br.com.mrocigno.moving.Presenters.ListaPresenter;
import br.com.mrocigno.moving.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ListaActivity extends DefaultActivity implements ListaInterface {

    @BindView(R.id.rcyLista_lista)
    RecyclerView rcyLista_lista;

    ListaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContainerView(R.layout.activity_lista);
        ButterKnife.bind(this);
        showBackPressed();

        presenter = new ListaPresenter(this, new ListaModel(activity));

        presenter.fillArray();
    }

    @Override
    public void onLoad(ArrayList<DatabaseValues> values) {
        rcyLista_lista.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        rcyLista_lista.setAdapter(new ListaAdapter(activity, values));
    }

    @Override
    public void nextScreen(Class classe) {
        startActivity(new Intent(activity, classe));
    }

    class ListaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        Activity activity;
        ArrayList<DatabaseValues> itens;

        ListaAdapter(Activity activity, ArrayList<DatabaseValues> itens) {
            this.activity = activity;
            this.itens = itens;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new Holder(LayoutInflater.from(activity).inflate(R.layout.cell_lista, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            Holder holder = (Holder) viewHolder;
            holder.setData(itens.get(i));
        }

        @Override
        public int getItemCount() {
            return itens.size();
        }

        class Holder extends RecyclerView.ViewHolder{

            TextView txtID_celllista, txtEmail_celllista, txtUser_celllista;

            Holder(@NonNull View itemView) {
                super(itemView);
                txtID_celllista = itemView.findViewById(R.id.txtID_celllista);
                txtEmail_celllista = itemView.findViewById(R.id.txtEmail_celllista);
                txtUser_celllista = itemView.findViewById(R.id.txtUser_celllista);
            }

            public void setData(DatabaseValues item){
                txtID_celllista.setText(String.valueOf(item.getID()));
                txtEmail_celllista.setText(item.getEmail());
                txtUser_celllista.setText(item.getUser());
            }
        }
    }
}
