package br.com.mrocigno.moving.Views;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.mrocigno.moving.Models.SplashModel;
import br.com.mrocigno.moving.Presenters.SplashPresenter;
import br.com.mrocigno.moving.R;
import br.com.mrocigno.moving.Presenters.SplashInterface;

public class SplashActivity extends AppCompatActivity implements SplashInterface {

    public SplashPresenter presenter;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        activity = SplashActivity.this;
        presenter = new SplashPresenter(this, new SplashModel(activity));

        initCountdown();
    }

    @Override
    public void nextScreen(Class classe) {
        startActivity(new Intent(activity, classe));
        finish();
    }

    private void initCountdown(){
        new Thread(){
            @Override
            public void run() {
                try{
                    sleep(1000);
                    presenter.nextScreen();
                }catch (Exception ignore){}
            }
        }.start();
    }
}
