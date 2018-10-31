package br.com.mrocigno.moving.Presenters;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Models.CadastroModel;

public class CadastroPresenter  {

    private CadastroInterface cadastroInterface;
    private CadastroModel cadastroModel;

    public CadastroPresenter(CadastroInterface cadastroInterface, CadastroModel cadastroModel) {
        this.cadastroInterface = cadastroInterface;
        this.cadastroModel = cadastroModel;
    }

    private boolean verifieData(DatabaseValues dbv){
        boolean noErrors = true;
        if(cadastroModel.verifieUser(dbv.getUser())){
            cadastroInterface.setUserError("Usuário já cadastrado");
            noErrors = false;
        }

        if(cadastroModel.verifieEmail(dbv.getEmail())){
            cadastroInterface.setEmailError("Email já cadastrado");
            noErrors = false;
        }

        return noErrors;
    }

    public void cadastrar(DatabaseValues dbv){
        if(verifieData(dbv)){
            cadastroModel.cadastrar(dbv);
            cadastroInterface.onSiginFinish();
        }
    }
}
