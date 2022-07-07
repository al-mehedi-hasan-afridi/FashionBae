package com.myfirst.fashionbae.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.myfirst.fashionbae.R;

public class SignInActivity extends AppCompatActivity {
    EditText name,email,password;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();

        auth=FirebaseAuth.getInstance();
        name=findViewById(R.id.sName);
        email=findViewById(R.id.sEmail);
        password=findViewById(R.id.sPass);
        Button button = findViewById(R.id.signInButton);
        button.setOnClickListener(view1 -> {
            signup(view1);
        });
        TextView buttonSignUp = findViewById(R.id.textViewAsLogInButton);
        buttonSignUp.setOnClickListener(view -> {
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
            Toast.makeText(SignInActivity.this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(SignInActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();

            return;

        }
        if(TextUtils.isEmpty(userPass)){
            Toast.makeText(SignInActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();

            return;

        }
        if(userPass.length()<6){
            Toast.makeText(SignInActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
            return;

        }
        auth.createUserWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignInActivity.this, "Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(SignInActivity.this, com.myfirst.fashionbae.activities.MainActivity.class));
                        }
                        else {
                            Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    public void logIn(View view){
        startActivity(new Intent(SignInActivity.this, LoginActivity.class));
    }

    public void moveback(View view){
        startActivity(new Intent(SignInActivity.this, com.myfirst.fashionbae.activities.MainActivity.class));
    }
}