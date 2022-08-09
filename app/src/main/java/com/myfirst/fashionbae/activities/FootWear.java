package com.myfirst.fashionbae.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
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

import java.util.ArrayList;

public class FootWear extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapterFootwear myAdapter;
    ArrayList<FootWearData> list;
    FirebaseAuth auth;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Button button;
    TextView brandName,price,size;
    String BrandName,Price,Size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_foot_wear);
        getSupportActionBar().hide();
        ImageView backbutton = findViewById(R.id.backbutton_footweartohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

        recyclerView =findViewById(R.id.pFootwear);

        database= FirebaseDatabase.getInstance().getReference().child("Footwear");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myAdapter =new MyAdapterFootwear(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    FootWearData data=dataSnapshot.getValue(FootWearData.class);
                    list.add(data);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        /**brandName = findViewById(R.id.Bname);
        price = findViewById(R.id.Price);
        size = findViewById(R.id.size);
        button = findViewById(R.id.addtocartbutton);

       // rootNode = FirebaseDatabase.getInstance();
      //  reference = rootNode.getReference("Footwear");
      //  reference = FirebaseDatabase.getInstance().getReference().child("Footwear");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Cart");

                BrandName = brandName.getText().toString();
                Price = price.getText().toString();
                Size = size.getText().toString();

                //Get all the values from text fields
                FootWearData footwearData = new FootWearData(BrandName,Price,Size);
                reference.push().setValue(footwearData);

                Toast.makeText(FootWear.this, "Footwear is added to cart.", Toast.LENGTH_SHORT).show();
               // startActivity(new Intent(FootWear.this, com.myfirst.fashionbae.activities.ShopHomePage.class));
            }
        }); */

        //{


           // rootNode = FirebaseDatabase.getInstance();
           // reference = rootNode.getReference("Cart");

          //  FootWearData footWearData = new FootWearData(BrandName,Price,Size);
          //  FirebaseUser firebaseUser = auth.getCurrentUser();


            /**database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String s = snapshot.getValue().toString();
                    Log.i("Our Value", s);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            }); */

           /** database.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                        DataSnapshot dataSnapshot = (DataSnapshot) snapshot.getChildren();
                        String brandNameDb=String.valueOf(dataSnapshot.child("brandName").getValue());
                        String priceDb=String.valueOf(dataSnapshot.child("price").getValue());
                        String sizeDb=String.valueOf(dataSnapshot.child("size").getValue());
                        FootWearData footWearData = new FootWearData(brandNameDb,priceDb,sizeDb);

                        String currentUser = (String)firebaseUser.getUid();
                        database.child(currentUser).setValue(footWearData);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            }); */

            //showUserProfile(firebaseUser);

       // });
    }

    /**private void showUserProfile(FirebaseUser firebaseUser) {
        String userID = firebaseUser.getUid();

        rootNode = FirebaseDatabase.getInstance();
        reference = rootNode.getReference("Cart");
        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                FootWearData readUserDetails = snapshot.getValue(FootWearData.class);
                if(readUserDetails != null){
                    FootWearData footWearData = new FootWearData(BrandName,Price,Size);
                    String currentUser = (String)firebaseUser.getUid();
                    reference.child(currentUser).setValue(footWearData);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FootWear.this, "Something went wrong!",Toast.LENGTH_LONG).show();
            }
        });
    } */

    public void moveback(View view){
        startActivity(new Intent(FootWear.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}