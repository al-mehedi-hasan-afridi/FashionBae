package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.myfirst.fashionbae.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    EditText brandname,size,category,address,quantity;
    Button orderbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        brandname=findViewById(R.id.brandname_o);
        size=findViewById(R.id.size_o);
        category=findViewById(R.id.category_o);
        address=findViewById(R.id.address_o);
        quantity=findViewById(R.id.quantity_o);
        orderbtn=findViewById(R.id.orderbtn_o);
        orderbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(OrderActivity.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(OrderActivity.this, com.myfirst.fashionbae.activities.Payment.class));


            }
        });
    }


}