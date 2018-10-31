package br.com.mrocigno.moving.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Models.CadastroModel;
import br.com.mrocigno.moving.Presenters.CadastroInterface;
import br.com.mrocigno.moving.Presenters.CadastroPresenter;
import br.com.mrocigno.moving.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import lib.rocigno.usefulthingslib.CustomViews.Views.AutoValidateEditText;
import lib.rocigno.usefulthingslib.CustomViews.Views.AutoValidateLinearLayout;

public class CadastroActivity extends DefaultActivity implements CadastroInterface {

    @BindView(R.id.btnSigin_cadastro)
    Button btnSigin_cadastro;

    @BindView(R.id.avetEmail_cadastro)
    AutoValidateEditText avetEmail_cadastro;

    @BindView(R.id.avetUser_cadastro)
    AutoValidateEditText avetUser_cadastro;

    @BindView(R.id.avetPass_cadastro)
    AutoValidateEditText avetPass_cadastro;

    @BindView(R.id.avetCPass_cadastro)
    AutoValidateEditText avetCPass_cadastro;

    @BindView(R.id.avllMain_cadastro)
    AutoValidateLinearLayout avllMain_cadastro;

    CadastroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContainerView(R.layout.activity_cadastro);
        ButterKnife.bind(this);

        presenter = new CadastroPresenter(this, new CadastroModel(activity));

        showBackPressed();

        btnSigin_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(avllMain_cadastro.isValidate()){
                    String user = avetUser_cadastro.getText().toString().trim();
                    String pass = avetPass_cadastro.getText().toString().trim();
                    String email = avetEmail_cadastro.getText().toString().trim();
                    presenter.cadastrar(new DatabaseValues(0,user,pass,email ));
                }
            }
        });

    }


    @Override
    public void setUserError(String msg) {
        avetUser_cadastro.setError(msg);
    }

    @Override
    public void setEmailError(String msg) {
        avetEmail_cadastro.setError(msg);
    }

    @Override
    public void onSiginFinish() {
        Toast.makeText(activity, "Cadastrado com sucesso!", Toast.LENGTH_LONG).show();
        finish();
    }
}
