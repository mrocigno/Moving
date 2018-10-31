package br.com.mrocigno.moving.Views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.mrocigno.moving.Database.Session;
import br.com.mrocigno.moving.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import lib.rocigno.usefulthingslib.Session.LoginBuilder.LoginBuilder;

public class DefaultActivity extends AppCompatActivity  {

    Activity activity;

    FrameLayout frmContainer_default;
    LinearLayout llExit_nav, llChange_nav;
    Toolbar toolbar;
    TextView txtUsuario_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default);

        toolbar = findViewById(R.id.toolbar);

        frmContainer_default = findViewById(R.id.frmContainer_default);

        setSupportActionBar(toolbar);

        this.activity = DefaultActivity.this;
    }

    public void setContainerView(int layout){
        View v = getLayoutInflater().inflate(layout, null);
        frmContainer_default.addView(v);
    }

    public void showBackPressed(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    public void showNavigationDrawer(){
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.colorSecodary));

//        NavigationView navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        txtUsuario_nav = findViewById(R.id.txtUsuario_nav);
        llExit_nav = findViewById(R.id.llExit_nav);
        llChange_nav = findViewById(R.id.llChange_nav);

        txtUsuario_nav.setText(Session.getNome());
        llExit_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginBuilder(activity).destroy(new LoginBuilder.DestroyLoginCallback() {
                    @Override
                    public void CallBack() {
                        startActivity(new Intent(activity, LoginActivity.class));
                        finish();
                    }
                });
            }
        });

        llChange_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity, AlterarSenhaActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case android.R.id.home:{
                onBackPressed();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
