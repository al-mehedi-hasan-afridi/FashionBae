package com.myfirst.fashionbae.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.myfirst.fashionbae.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();

        //shows drawer icons colors
        NavigationView navigationDrawer = findViewById(R.id.nav_view);
        navigationDrawer.setItemIconTintList(null);
        final DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ImageView navigationDrawerImage = findViewById(R.id.navigationdrawerimage);
        navigationDrawerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        clickListener();

    }

     public void clickListener(){
        LinearLayout Shirt=findViewById(R.id.shirt);
        LinearLayout TShirt=findViewById(R.id.tshirt);
        LinearLayout Pant= findViewById(R.id.pant);
        LinearLayout FootWear= findViewById(R.id.footwear);
        LinearLayout Glass= findViewById(R.id.sunglass);
        LinearLayout Jacket= findViewById(R.id.jacket);
        LinearLayout Purse= findViewById(R.id.purse);
        LinearLayout Watch= findViewById(R.id.watch);
        RelativeLayout Shop = findViewById(R.id.homepageShops);

        Shirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openShirt();
            }
        });
        TShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTshirt();
            }
        });
         //need to create a class
         Pant.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openPant();
             }
         });
         FootWear.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openFootWear();
             }
         });
         Glass.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openGlass();
             }
         });
         Jacket.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openJacket();
             }
         });
         //need to create a class
         Purse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openPurse();
             }
         });
         //need to create a class
         Watch.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openWatch();
             }
         });
         Shop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openShop();
             }
         });
    }

    public  void openTshirt(){
        startActivity(new Intent(HomePage.this, Tshirt.class));

    }
    public  void openShirt(){
        startActivity(new Intent(HomePage.this, Shirt.class));

    }

    public  void openPant(){
        startActivity(new Intent(HomePage.this, Pant.class));

    }
    public  void openFootWear(){
        startActivity(new Intent(HomePage.this, FootWear.class));

    }
    public  void openJacket(){
        startActivity(new Intent(HomePage.this, Jackets.class));

    }
    public  void openGlass(){
        startActivity(new Intent(HomePage.this, Glasses.class));

    }
    public  void openPurse(){
        startActivity(new Intent(HomePage.this, Purse.class));

    }
    public  void openWatch(){
        startActivity(new Intent(HomePage.this, Watch.class));

    }
     public void openShop(){

        startActivity(new Intent(HomePage.this, ShopActivity.class));
     }
}