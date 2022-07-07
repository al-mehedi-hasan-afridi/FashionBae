package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.myfirst.fashionbae.R;

public class Glasses extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_glasses);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_glasstohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

        Button addtocart = findViewById(R.id.addtocartbutton);
        addtocart.setOnClickListener(view -> {
            clicked(view);
        } );
    }

    public void moveback(View view){
        startActivity(new Intent(Glasses.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
    public void clicked(View view){
        Toast.makeText(Glasses.this, "Product added to cart", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Glasses.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}