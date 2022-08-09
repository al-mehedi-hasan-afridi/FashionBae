package com.myfirst.fashionbae.activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.myfirst.fashionbae.R;

public class AddPant extends AppCompatActivity {

    EditText bName, pRice, sIze;
    Button addPant;
    String BName, PRice, SIze, PantPic;
    FirebaseDatabase rootNode;
    ImageView addPantPic;
    DatabaseReference reference;
    Uri imageUri;
    StorageReference fileRef, imageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_add_pant);
        getSupportActionBar().hide();

        bName = findViewById(R.id.brandName);
        pRice = findViewById(R.id.price);
        sIze = findViewById(R.id.size);
        addPant = findViewById(R.id.addPant);
        addPantPic = findViewById(R.id.addPantPic);
        ImageView backbutton = findViewById(R.id.backbutton_addPanttoShophome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );


        addPantPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent();
                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, 2);
            }
        });

        addPant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Pant");

                BName = bName.getText().toString();
                PRice = pRice.getText().toString();
                SIze = sIze.getText().toString();

                imageReference = FirebaseStorage.getInstance().getReference();
                PantPic = addPantPic.toString();
                if(imageUri != null){
                    uploadToFirebase(imageUri);
                } else{
                    Toast.makeText(AddPant.this, "Please select image", Toast.LENGTH_SHORT).show();
                }
                //Get all the values from text fields
                AddPantData addPantData = new AddPantData(BName,PRice,SIze,PantPic);
                reference.push().setValue(addPantData);

                Toast.makeText(AddPant.this, "Pant is added.", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddPant.this, com.myfirst.fashionbae.activities.ShopHomePage.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 2 && resultCode == RESULT_OK && data != null){

            imageUri = data.getData();
            addPantPic.setImageURI(imageUri);
        }
    }

    public void uploadToFirebase(Uri uri){
        fileRef = imageReference.child(System.currentTimeMillis() + "." + getFileExtension(uri));

        fileRef.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                    }
                });
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(AddPant.this, "Uploading failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String getFileExtension(Uri mUri){
        ContentResolver cr = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cr.getType(mUri));
    }

    public void moveback(View view){
        startActivity(new Intent(AddPant.this, com.myfirst.fashionbae.activities.ShopHomePage.class));
    }
}