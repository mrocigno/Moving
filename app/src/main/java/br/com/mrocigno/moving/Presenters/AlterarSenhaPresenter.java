package br.com.mrocigno.moving.Presenters;

import br.com.mrocigno.moving.Database.DatabaseValues;
import br.com.mrocigno.moving.Models.AlterarSenhaModel;

public class AlterarSenhaPresenter {

    AlterarSenhaInterface alterarSenhaInterface;
    AlterarSenhaModel alterarSenhaModel;

    public AlterarSenhaPresenter(AlterarSenhaInterface alterarSenhaInterface, AlterarSenhaModel alterarSenhaModel) {
        this.alterarSenhaInterface = alterarSenhaInterface;
        this.alterarSenhaModel = alterarSenhaModel;
    }

    public void updatePass(DatabaseValues dbv){
        if(alterarSenhaModel.verifieCurrentPass(dbv.getUser(), dbv.getID())){
            alterarSenhaModel.updatePass(dbv);
            alterarSenhaInterface.onUpdatePass();
        }else{
            alterarSenhaInterface.setCurrentPassError("Senha atual incorreta");
        }
    }

}
