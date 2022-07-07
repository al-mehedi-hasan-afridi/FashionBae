package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.myfirst.fashionbae.R;

public class Jackets extends AppCompatActivity {

    public RadioGroup radioGroup;
    public RadioButton radioButtonShirtSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jackets);
        getSupportActionBar().hide();

        radioGroup = findViewById(R.id.radiogroupShirt);
        int shirtSize = radioGroup.getCheckedRadioButtonId();
        radioButtonShirtSize = findViewById(shirtSize);

        ImageView backbutton = findViewById(R.id.backbutton_jackettohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }
    public void moveback(View view){
        startActivity(new Intent(Jackets.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}