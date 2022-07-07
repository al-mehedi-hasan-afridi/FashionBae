package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.myfirst.fashionbae.R;

public class Watch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_watch);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_watchtohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }
    public void moveback(View view){
        startActivity(new Intent(Watch.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}