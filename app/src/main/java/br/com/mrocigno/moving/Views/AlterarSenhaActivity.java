package br.com.mrocigno.moving.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Database.Session;
import br.com.mrocigno.moving.Models.AlterarSenhaModel;
import br.com.mrocigno.moving.Presenters.AlterarSenhaInterface;
import br.com.mrocigno.moving.Presenters.AlterarSenhaPresenter;
import br.com.mrocigno.moving.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import lib.rocigno.usefulthingslib.CustomViews.Views.AutoValidateEditText;
import lib.rocigno.usefulthingslib.CustomViews.Views.AutoValidateLinearLayout;

public class AlterarSenhaActivity extends DefaultActivity implements AlterarSenhaInterface {

    @BindView(R.id.avllMain_alterarsenha)
    AutoValidateLinearLayout avllMain_alterarsenha;

    @BindView(R.id.avetCurrentPass_alterarsenha)
    AutoValidateEditText avetCurrentPass_alterarsenha;

    @BindView(R.id.avetPass_alterarsenha)
    AutoValidateEditText avetPass_alterarsenha;

    @BindView(R.id.avetCPass_alterarsenha)
    AutoValidateEditText avetCPass_alterarsenha;

    @BindView(R.id.btnAlterar_alterarsenha)
    Button btnAlterar_alterarsenha;

    AlterarSenhaPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContainerView(R.layout.activity_alterar_senha);
        ButterKnife.bind(this);
        showBackPressed();

        presenter = new AlterarSenhaPresenter(this, new AlterarSenhaModel(activity));

        btnAlterar_alterarsenha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionUpdate();
            }
        });

        avetCPass_alterarsenha.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                actionUpdate();
                return true;
            }
        });
    }

    private void actionUpdate() {
        if (avllMain_alterarsenha.isValidate()) {
            presenter.updatePass(new DatabaseValues(Session.getId(), avetCurrentPass_alterarsenha.getText().toString().trim(), avetPass_alterarsenha.getText().toString().trim(), ""));
        }
    }

    @Override
    public void nextScreen(Class classe) {
        startActivity(new Intent(activity, classe));
    }

    @Override
    public void onUpdatePass() {
        Toast.makeText(activity, "Senha atualizada", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void setCurrentPassError(String msg) {
        avetCurrentPass_alterarsenha.setError(msg);
    }
}
