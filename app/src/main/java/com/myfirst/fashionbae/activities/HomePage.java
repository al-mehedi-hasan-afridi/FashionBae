package com.myfirst.fashionbae.activities;

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

public class HomePage extends AppCompatActivity {

    TextView buttonVerify,resendcode, verifymessage, showFirstName;
    FirebaseAuth auth;
    FirebaseUser firebaseUser;
    String userID;
    String firstName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home_page);
        getSupportActionBar().hide();

        buttonVerify = findViewById(R.id.textAsVerifyButton);
        buttonVerify.setPaintFlags(buttonVerify.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        showFirstName = findViewById(R.id.homepage_firstNametext);
        resendcode = findViewById(R.id.textAsVerifyButton);
        verifymessage = findViewById(R.id.verificationText);
        auth = FirebaseAuth.getInstance();
        userID = auth.getCurrentUser().getUid();
        firebaseUser = auth.getCurrentUser();

        if(!firebaseUser.isEmailVerified()){
            resendcode.setVisibility(View.VISIBLE);
            verifymessage.setVisibility(View.VISIBLE);

            resendcode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    firebaseUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(HomePage.this, "Verification Email has been sent.", Toast.LENGTH_SHORT);
                            startActivity(new Intent(HomePage.this, com.myfirst.fashionbae.activities.LoginActivity.class));
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag","Failure: Verification email has not been sent."+e.getMessage() );
                        }
                    });
                }
            });
        }

        if(firebaseUser == null){
            Toast.makeText(HomePage.this, "Something went wrong! User details aren't available at the moment.", Toast.LENGTH_LONG).show();
        }
        else{
            showUserProfile(firebaseUser);
        }

        clickListener();
    }

     public void clickListener(){
         ImageButton profile = findViewById(R.id.profile_button);
         ImageView cart = findViewById(R.id.cart_button);
         ImageView order = findViewById(R.id.order_button);
         ImageView setting = findViewById(R.id.settings_button);
         ImageView logout = findViewById(R.id.logout_button);
         RelativeLayout Shop = findViewById(R.id.homepageShops);
         LinearLayout Shirt=findViewById(R.id.shirt);
         LinearLayout TShirt=findViewById(R.id.tshirt);
         LinearLayout Pant= findViewById(R.id.pant);
         LinearLayout FootWear= findViewById(R.id.footwear);
         LinearLayout Glass= findViewById(R.id.sunglass);
         LinearLayout Jacket= findViewById(R.id.jacket);
         LinearLayout Purse= findViewById(R.id.purse);
         LinearLayout Watch= findViewById(R.id.watch);
         FloatingActionButton faq = findViewById(R.id.faq_button);

         Shop.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openShop();
             }
         });
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

         profile.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openProfile();
             }
         });

         setting.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openSetting();
             }
         });

         logout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 logout();
             }
         });

         faq.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openFAQ();
             }
         });

         cart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 openAddToCart();
             }
         });

    }

    public void openShop(){

        startActivity(new Intent(HomePage.this, ShopActivity.class));
    }

    public  void openShirt(){
        startActivity(new Intent(HomePage.this, Shirt.class));

    }

    public  void openTshirt(){
        startActivity(new Intent(HomePage.this, Tshirt.class));

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
    public  void  openProfile(){
         startActivity(new Intent(HomePage.this, Profile.class));
     }
    public  void  openSetting(){
        startActivity(new Intent(HomePage.this, Setting.class));
    }
    public  void  logout(){
        startActivity(new Intent(HomePage.this, com.myfirst.fashionbae.activities.OnBoardActivity.class));
    }
    public  void  openFAQ(){
        startActivity(new Intent(HomePage.this, FAQ.class));
    }

    public  void  openAddToCart(){
        startActivity(new Intent(HomePage.this, AddToCart.class));
    }



    private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

        DatabaseReference referenceProfile = FirebaseDatabase.getInstance().getReference("users");
        referenceProfile.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserHelperClass readUserDetails = snapshot.getValue(UserHelperClass.class);
                if(readUserDetails != null){

                    firstName = readUserDetails.firstName;

                    showFirstName.setText(firstName);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(HomePage.this, "Something went wrong!",Toast.LENGTH_LONG).show();
            }
        });
    }

}