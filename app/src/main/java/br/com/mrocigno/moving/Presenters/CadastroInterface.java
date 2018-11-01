package br.com.mrocigno.moving.Presenters;

public interface CadastroInterface {
    void setUserError(String msg);

    void setEmailError(String msg);

    void onSiginFinish();
}
