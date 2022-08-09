package com.myfirst.fashionbae.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myfirst.fashionbae.R;
public class ShopHomePage extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    String shopName;
    TextView showShopName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shop_home_page);
        getSupportActionBar().hide();

        auth = FirebaseAuth.getInstance();
        firebaseUser = auth.getCurrentUser();
        showShopName = findViewById(R.id.shopName);

        if(firebaseUser == null){
            Toast.makeText(ShopHomePage.this, "Something went wrong! User details aren't available at the moment.", Toast.LENGTH_LONG).show();
        }
        else{
            showUserProfile(firebaseUser);
        }

        Button addShirt = findViewById(R.id.buttonAddShirt);
        Button addTshirt = findViewById(R.id.buttonAddTshirt);
        Button addPant = findViewById(R.id.buttonAddPant);
        Button addFootwear = findViewById(R.id.buttonAddFootwear);
        Button addGlass = findViewById(R.id.buttonAddGlass);
        Button addJacket = findViewById(R.id.buttonAddJacket);
        Button addPurse = findViewById(R.id.buttonAddPurse);
        Button addWatch = findViewById(R.id.buttonAddWatch);
        ImageView logout = findViewById(R.id.logout_button);

        addShirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddShirt();
            }
        });

        addTshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddTshirt();
            }
        });

        addPant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPant();
            }
        });

        addFootwear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFootwear();
            }
        });

        addGlass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGlass();
            }
        });

        addJacket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openJacket();
            }
        });

        addPurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPurse();
            }
        });

        addWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWatch();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    public void openAddShirt(){
        startActivity(new Intent(ShopHomePage.this, AddShirt.class));
    }
    public void openAddTshirt(){
        startActivity(new Intent(ShopHomePage.this, AddTshirt.class));
    }
    public void openPant(){
        startActivity(new Intent(ShopHomePage.this, AddPant.class));
    }
    public void openFootwear(){
        startActivity(new Intent(ShopHomePage.this, AddFootwear.class));
    }
    public void openGlass(){
        startActivity(new Intent(ShopHomePage.this, AddGlass.class));
    }
    public void openJacket(){
        startActivity(new Intent(ShopHomePage.this, AddJacket.class));
    }
    public void openPurse(){
        startActivity(new Intent(ShopHomePage.this, AddPurse.class));
    }
    public void openWatch(){
        startActivity(new Intent(ShopHomePage.this, AddWatch.class));
    }
    public  void  logout(){
        startActivity(new Intent(ShopHomePage.this, com.myfirst.fashionbae.activities.OnBoardActivity.class));
    }

    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("Shop");
        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ShopHelperClass readShopDetails = snapshot.getValue(ShopHelperClass.class);
                if(readShopDetails != null){

                    shopName = readShopDetails.shopName;

                    showShopName.setText(shopName);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ShopHomePage.this, "Something went wrong!",Toast.LENGTH_LONG).show();
            }
        });
    }
}