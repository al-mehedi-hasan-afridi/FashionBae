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

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.siEmail);
        password=findViewById(R.id.siPass);
        Button button=findViewById(R.id.logInButton);
        button.setOnClickListener(view -> {
            logIn(view);
        });
        TextView buttonSignUp = findViewById(R.id.textViewAsSignUpButton);
        buttonSignUp.setOnClickListener(view -> {
            signup(view);
        } );
        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
    }

    public void logIn(View view){
        String userEmail=email.getText().toString();
        String userPass=password.getText().toString();
        if(TextUtils.isEmpty(userEmail)){
            Toast.makeText(LoginActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();

            return;

        }
        if(TextUtils.isEmpty(userPass)){
            Toast.makeText(LoginActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();

            return;

        }
        if(userPass.length()<6){
            Toast.makeText(LoginActivity.this, "Password is too short", Toast.LENGTH_SHORT).show();
            return;

        }
        auth.signInWithEmailAndPassword(userEmail,userPass)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, HomePage.class));
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        }
                    }
                });

    }
    public void signup(View view){
        startActivity(new Intent(LoginActivity.this, com.myfirst.fashionbae.activities.SignInActivity.class));
    }
    public void moveback(View view){
        startActivity(new Intent(LoginActivity.this, com.myfirst.fashionbae.activities.MainActivity.class));
    }

}