package br.com.mrocigno.moving.Presenters;

import br.com.mrocigno.moving.Models.LoginModel;
import br.com.mrocigno.moving.Views.CadastroActivity;
import br.com.mrocigno.moving.Views.ListaActivity;
import br.com.mrocigno.moving.Views.MainActivity;

public class LoginPresenter {

    private LoginInterface loginInterface;
    private LoginModel loginModel;

    public LoginPresenter(LoginInterface loginInterface, LoginModel loginModel) {
        this.loginInterface = loginInterface;
        this.loginModel = loginModel;
    }

    public void loginAction(String email, String pass){
        if(loginModel.logar(email, pass)){
            loginInterface.nextScreen(MainActivity.class);
        }else{
            loginInterface.showMsg("Email/Senha incorretos");
        }
    }

    public void screenCadastrar(){
        loginInterface.nextScreen(CadastroActivity.class);
    }
    public void screenLista(){
        loginInterface.nextScreen(ListaActivity.class);
    }
}
