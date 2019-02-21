package com.example.uvesports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new D1Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_D1);
            toolbar.setTitle("DOUBLE 1");
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_D1:
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new D1Fragment()).commit();
                toolbar.setTitle("DOUBLE 1");*/
                startActivity(new Intent(MainActivity.this,D1List.class));
                break;
            case R.id.nav_doubleOrNothing:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DoubleornothingFragment()).commit();
                toolbar.setTitle("DOUBLE OR NOTHING");
                break;
            case R.id.nav_elite3:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Elite3Fragment()).commit();
                toolbar.setTitle("ELITE 3");
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
