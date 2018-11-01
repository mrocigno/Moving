package br.com.mrocigno.moving.Presenters;

public interface AlterarSenhaInterface extends DefaultInterface {
    void onUpdatePass();

    void setCurrentPassError(String msg);
}
