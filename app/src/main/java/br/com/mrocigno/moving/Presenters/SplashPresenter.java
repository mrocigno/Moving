package br.com.mrocigno.moving.Presenters;

import br.com.mrocigno.moving.Models.SplashModel;
import br.com.mrocigno.moving.Views.LoginActivity;
import br.com.mrocigno.moving.Views.MainActivity;

public class SplashPresenter {

    private SplashInterface splashInterface;
    private SplashModel splashModel;

    public SplashPresenter(SplashInterface splashInterface, SplashModel splashModel) {
        this.splashInterface = splashInterface;
        this.splashModel = splashModel;
    }

    public void nextScreen() {
        if (splashModel.verifieIfLoged()) {
            splashInterface.nextScreen(MainActivity.class);
        } else {
            splashInterface.nextScreen(LoginActivity.class);
        }
    }

}
