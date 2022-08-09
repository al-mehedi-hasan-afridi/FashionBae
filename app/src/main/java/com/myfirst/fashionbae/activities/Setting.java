package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.myfirst.fashionbae.R;

public class Setting extends AppCompatActivity {

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_settings);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_settingtohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }

    private void moveback(View view) {
        startActivity(new Intent(Setting.this, com.myfirst.fashionbae.activities.HomePage.class));

    }
}