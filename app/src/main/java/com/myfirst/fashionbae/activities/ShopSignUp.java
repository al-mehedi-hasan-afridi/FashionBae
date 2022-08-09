package com.myfirst.fashionbae.activities;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.myfirst.fashionbae.R;
public class ShopSignUp extends AppCompatActivity {

    EditText name,email,password;
    private FirebaseAuth auth;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    ShopHelperClass helperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shop_sign_up);
        getSupportActionBar().hide();

        auth=FirebaseAuth.getInstance();
        name=findViewById(R.id.sName);
        email=findViewById(R.id.sEmail);
        password=findViewById(R.id.sPass);
        Button button = findViewById(R.id.signInButton);
        button.setOnClickListener(view1 -> {
            signup(view1);
        });
        TextView buttonLogIn = findViewById(R.id.textViewAsLogInButton);
        buttonLogIn.setPaintFlags(buttonLogIn.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        buttonLogIn.setOnClickListener(view -> {
            logIn(view);
        } );
        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }

    public void signup(View view){
        String userName=name.getText().toString();
        String userEmail=email.getText().toString();
        String userPass=password.getText().toString();

        if(TextUtils.isEmpty(userName)){
            Toast.makeText(ShopSignUp.this, "Enter First Name", Toast.LENGTH_SHORT).show();
            return;
        }
        else if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(ShopSignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();

            return;

        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches())
        {
            Toast.makeText(ShopSignUp.this, "Provide Valid Email Address", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userPass)){
            Toast.makeText(ShopSignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();

            return;

        }
        else if(userPass.length()<6) {
            Toast.makeText(ShopSignUp.this, "Password is too short", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(ShopSignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                                    Toast.makeText(ShopSignUp.this, "Successful.", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(ShopSignUp.this, ShopLogIn.class));

                                    //generating users using signup information in firebase realtime database
                                    rootNode = FirebaseDatabase.getInstance();
                                    reference = rootNode.getReference("Shop");

                                    //Get all the values from text fields
                                    helperClass = new ShopHelperClass(userName,userEmail,userPass);
                                    String currentUser = (String)firebaseUser.getUid();
                                    reference.child(currentUser).setValue(helperClass);

                            // Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(SignInActivity.this, com.myfirst.fashionbae.activities.MainActivity.class));
                        }
                        else {
                            Toast.makeText(ShopSignUp.this, "Failed"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public void logIn(View view){
        startActivity(new Intent(ShopSignUp.this, ShopLogIn.class));
    }

    public void moveback(View view){
        startActivity(new Intent(ShopSignUp.this, com.myfirst.fashionbae.activities.MainActivity.class));
    }
}
