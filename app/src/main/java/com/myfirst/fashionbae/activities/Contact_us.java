package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.myfirst.fashionbae.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Contact_us extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_contact_us);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_contactus_aboutus);

        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }

    public void moveback(View view){
        startActivity(new Intent(Contact_us.this, com.myfirst.fashionbae.activities.About_us.class));
    }
}
