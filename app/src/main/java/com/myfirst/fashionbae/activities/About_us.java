package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.myfirst.fashionbae.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class About_us extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_aboutus_home);

        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
        clickListener();
    }

    private void clickListener() {
        ImageView Contact_us = findViewById(R.id.contactus);
        ImageView Return_policy = findViewById(R.id.return_policy);

        Contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openContactus();
            }
        });
        Return_policy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReturnpolicy();
            }
        });
    }
    public  void  openContactus(){
        startActivity(new Intent(About_us.this, Contact_us.class));
    }

    public  void  openReturnpolicy(){
        startActivity(new Intent(About_us.this, Return_policy.class));
    }


    public void moveback(View view){
        startActivity(new Intent(About_us.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}
