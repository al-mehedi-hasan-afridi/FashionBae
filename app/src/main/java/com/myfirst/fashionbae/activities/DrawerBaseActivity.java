package com.myfirst.fashionbae;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.WindowManager;

import com.google.android.material.navigation.NavigationView;
import com.myfirst.fashionbae.activities.HomePage;

public class DrawerBaseActivity extends AppCompatActivity {

    /** DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar; */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();
        /** //shows drawer icons colors
        NavigationView navigationDrawer = findViewById(R.id.nav_view);
        navigationDrawer.setItemIconTintList(null);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(DrawerBaseActivity.this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState(); */


    }
}