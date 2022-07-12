package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.myfirst.fashionbae.R;
import com.myfirst.fashionbae.activities.HomePage;
import com.myfirst.fashionbae.activities.MainActivity;

public class Navigation_Drawer_Setting extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_navigation_drawer_settings);
        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.drawer_layout);

    }
}