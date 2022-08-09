package com.myfirst.fashionbae.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
        TextView forgotPassword = findViewById(R.id.textViewForgotPassword);
        forgotPassword.setPaintFlags(forgotPassword.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        Button button=findViewById(R.id.logInButton);
        button.setOnClickListener(view -> {
            logIn(view);
        });
        TextView buttonSignUp = findViewById(R.id.textViewAsSignUpButton);
        buttonSignUp.setPaintFlags(buttonSignUp.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        buttonSignUp.setOnClickListener(view -> {
            signup(view);
        } );
        ImageView backbutton = findViewById(R.id.backbutton);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText emailforNewPassword = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password ");
                passwordResetDialog.setMessage("Enter Your Email To Receive Reset Link.");
                passwordResetDialog.setView(emailforNewPassword);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //extract email and send reset link

                        String emailForNewPassword = emailforNewPassword.getText().toString();
                        if (TextUtils.isEmpty(emailForNewPassword)) {
                            Toast.makeText(LoginActivity.this, "Email is required to change password", Toast.LENGTH_SHORT).show();
                        }
                        else if(!Patterns.EMAIL_ADDRESS.matcher(emailForNewPassword).matches())
                        {
                            Toast.makeText(LoginActivity.this, "Provide Valid Email Address", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            auth.sendPasswordResetEmail(emailForNewPassword).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(LoginActivity.this, " Password Reset Link Sent To Your Email.", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(LoginActivity.this, "Error! Reset Link Is Not Sent." + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                });

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //close dialog
                    }
                });

                passwordResetDialog.create().show();
            }
        });
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