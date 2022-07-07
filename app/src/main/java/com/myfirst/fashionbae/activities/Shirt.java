package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.myfirst.fashionbae.R;
public class Shirt extends AppCompatActivity {

    public RadioGroup radioGroup;
    public RadioButton radioButtonShirtSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shirt);
        getSupportActionBar().hide();

        //user can choose only one radio button
        radioGroup = findViewById(R.id.radiogroupShirt);
        int shirtSize = radioGroup.getCheckedRadioButtonId();
        radioButtonShirtSize = findViewById(shirtSize);

        ImageView backbutton = findViewById(R.id.backbutton_shirttohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }
    public void moveback(View view){
        startActivity(new Intent(Shirt.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}