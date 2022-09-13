package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.myfirst.fashionbae.R;

public class Payment extends AppCompatActivity {
    String[] Payment_methods;
    private Spinner spinner;
    private Button btnorder;
    private TextView showmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_payment);
        Payment_methods=getResources().getStringArray(R.array.PaymentMethods);
        spinner= (Spinner) findViewById(R.id.spinner1);
        btnorder=(Button)findViewById(R.id.buttonpayment);
        showmsg=(TextView) findViewById(R.id.ordermessage);

        ArrayAdapter<String> adapterorder = new ArrayAdapter<String>(this,R.layout.payment_view,R.id.textsample,Payment_methods);
        spinner.setAdapter(adapterorder);

        btnorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Payment.this, "Success", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Payment.this, com.myfirst.fashionbae.activities.HomePage.class));


            }
        });
    }
}
