package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.myfirst.fashionbae.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class FAQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_faq);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_faqtohome);

        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }

    public void moveback(View view){
        startActivity(new Intent(FAQ.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}