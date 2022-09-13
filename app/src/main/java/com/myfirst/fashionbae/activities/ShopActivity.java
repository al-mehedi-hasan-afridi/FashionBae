package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.myfirst.fashionbae.R;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myfirst.fashionbae.R;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shop);
        getSupportActionBar().hide();
        ImageView backbutton = findViewById(R.id.backbutton_shoptohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

        clicklistener();
    }

    public void moveback(View view){
        startActivity(new Intent(ShopActivity.this, com.myfirst.fashionbae.activities.HomePage.class));
    }

    public void clicklistener(){
        RelativeLayout Esctacy = findViewById(R.id.esctasy);
        RelativeLayout Yellow = findViewById(R.id.yellow);
        RelativeLayout Lareve = findViewById(R.id.lareve);
        RelativeLayout Catseye = findViewById(R.id.catseye);
        RelativeLayout Artisti = findViewById(R.id.artisti);
        RelativeLayout Sailor = findViewById(R.id.sailor);
        RelativeLayout Bata = findViewById(R.id.bata);


        Esctacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openesctasy();
            }
        });



        Yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openyellow();
            }
        });


        Lareve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlareve();
            }
        });



        Catseye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opencatseye();
            }
        });

        Artisti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openartisti();
            }
        });

        Sailor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensailor();
            }
        });

        Bata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openbata();
            }
        });





    }

    public void openesctasy(){

        startActivity(new Intent(ShopActivity.this, Esctasy.class));
    }

    public void openyellow(){

        startActivity(new Intent(ShopActivity.this, Yellow.class));
    }

    public void openlareve(){

        startActivity(new Intent(ShopActivity.this, Lareve.class));
    }

    public void opencatseye(){

        startActivity(new Intent(ShopActivity.this, Catseye.class));
    }

    public void openartisti(){

        startActivity(new Intent(ShopActivity.this, Artisti.class));
    }

    public void opensailor(){

        startActivity(new Intent(ShopActivity.this, Sailor.class));
    }



    public void openbata(){

        startActivity(new Intent(ShopActivity.this, Bata.class));
    }




}