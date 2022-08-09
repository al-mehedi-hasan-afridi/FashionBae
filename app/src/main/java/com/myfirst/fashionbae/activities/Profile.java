package com.myfirst.fashionbae.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myfirst.fashionbae.R;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    TextView textViewFirstName,textViewLastName,textViewEmail, textViewPassword;
    EditText resetEmail, resetPassword;
    private FirebaseAuth auth;
    String firstName,lastName,email;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        textViewFirstName = findViewById(R.id.textViewFirstName);
        textViewLastName = findViewById(R.id.textViewLastName);
        textViewEmail = findViewById(R.id.textViewEmail);
        reference = FirebaseDatabase.getInstance().getReference("users");

        auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if(firebaseUser == null){
            Toast.makeText(Profile.this, "Something went wrong! User details aren't available at the moment.", Toast.LENGTH_LONG).show();
        }
        else{
            showUserProfile(firebaseUser);
        }

        TextView changeEmail = findViewById(R.id.changeEmailButton);
        changeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetEmail = new EditText(view.getContext());
                AlertDialog.Builder emailResetDialog = new AlertDialog.Builder(view.getContext());
                emailResetDialog.setTitle("Update Email");
                emailResetDialog.setMessage("Enter Your New Email.");
                emailResetDialog.setView(resetEmail);

                emailResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //extract email and send reset link

                        String mail = resetEmail.getText().toString();

                        if(TextUtils.isEmpty(mail))
                        {
                            Toast.makeText(Profile.this, "New Email is required", Toast.LENGTH_SHORT).show();
                        }
                        else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches())
                        {
                            Toast.makeText(Profile.this, "Provide Valid Email Address", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            updateEmail(firebaseUser);
                        }
                    }
                });
                emailResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //close dialog
                    }
                });

                emailResetDialog.create().show();
            }
        });

        TextView changePassword = findViewById(R.id.changePasswordButton);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword = new EditText(view.getContext());
                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password");
                passwordResetDialog.setMessage("Password should be atleast 6 characters long.");
                passwordResetDialog.setView(resetPassword);

                passwordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String newPassword = resetPassword.getText().toString();

                        if(TextUtils.isEmpty(newPassword))
                        {
                            Toast.makeText(Profile.this, "New Password is required", Toast.LENGTH_SHORT).show();
                        }
                        else if(newPassword.length()<6)
                        {
                            Toast.makeText(Profile.this, "Password is too short", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            updatePassword(firebaseUser);
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
        ImageView backbutton = findViewById(R.id.backbutton_profiletohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

    }


    private void moveback(View view) {
        startActivity(new Intent(Profile.this, com.myfirst.fashionbae.activities.HomePage.class));

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
                   lastName = readUserDetails.lastName;

                   textViewFirstName.setText(firstName);
                   textViewLastName.setText(lastName);

               }
                   email = firebaseUser.getEmail();
                   textViewEmail.setText(email);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this, "Something went wrong!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void updateEmail(FirebaseUser firebaseUser){
        String mail = resetEmail.getText().toString();

        firebaseUser.updateEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isComplete()){
                   // if(!textViewEmail.getText().toString().equals(mail)) {
                    // reference.child(currentUser).child("email").setValue(mail);
                        Toast.makeText(Profile.this, "Email has been changed", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Profile.this, com.myfirst.fashionbae.activities.HomePage.class));
                    }
              //  }
                else{
                    Toast.makeText(Profile.this, "Email has not been changed"+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void updatePassword(FirebaseUser firebaseUser){
        String newPassword = resetPassword.getText().toString();
        firebaseUser.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isComplete()){
                    Toast.makeText(Profile.this, "Password has been changed", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Profile.this, com.myfirst.fashionbae.activities.HomePage.class));
                }
                else {
                    Toast.makeText(Profile.this, "Password has not been changed"+task.getException(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}