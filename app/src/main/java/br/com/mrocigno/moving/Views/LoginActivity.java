package br.com.mrocigno.moving.Views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.mrocigno.moving.Models.LoginModel;
import br.com.mrocigno.moving.Presenters.LoginPresenter;
import br.com.mrocigno.moving.R;
import br.com.mrocigno.moving.Presenters.LoginInterface;
import br.com.mrocigno.moving.Utils.Utils;
import butterknife.BindView;
import butterknife.ButterKnife;
import lib.rocigno.usefulthingslib.CustomViews.Views.AutoValidateEditText;
import lib.rocigno.usefulthingslib.CustomViews.Views.AutoValidateLinearLayout;

public class LoginActivity extends AppCompatActivity implements LoginInterface {

    Activity activity;

    @BindView(R.id.avllMain_login)
    AutoValidateLinearLayout avllMain_login;

    @BindView(R.id.btnEntrar_login)
    Button btnEntrar_login;

    @BindView(R.id.avetEmail_login)
    AutoValidateEditText avetEmail_login;

    @BindView(R.id.avetSenha_login)
    AutoValidateEditText avetSenha_login;

    @BindView(R.id.txtCadastro_login)
    TextView txtCadastro_login;

    @BindView(R.id.txtLista_login)
    TextView txtLista_login;

    public LoginPresenter loginPresenter;
    public LoginModel loginModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        activity = LoginActivity.this;

        loginModel = new LoginModel(LoginActivity.this);
        loginPresenter = new LoginPresenter(this, loginModel);

        btnEntrar_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAction();
            }
        });

        txtCadastro_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.screenCadastrar();
            }
        });

        txtLista_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.screenLista();
            }
        });

        avetSenha_login.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                loginAction();
                return true;
            }
        });

        Utils.verifiePermissions(activity);
    }

    public void loginAction(){
        if (avllMain_login.isValidate()) {
            String user = avetEmail_login.getText().toString().trim();
            String pass = avetSenha_login.getText().toString().trim();
            loginPresenter.loginAction(user, pass);
        }
    }

    @Override
    public void nextScreen(Class classe) {
        startActivity(new Intent(activity, classe));
        if (classe == MainActivity.class) {
            finish();
        }
    }

    @Override
    public void showMsg(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }

}
