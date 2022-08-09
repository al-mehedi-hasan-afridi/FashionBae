package com.myfirst.fashionbae.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myfirst.fashionbae.R;

import java.util.ArrayList;

public class Pant extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapterPant myAdapter;
    ArrayList<PantData> list;
    Button addTocartBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pant);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_panttohome);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

        recyclerView =findViewById(R.id.pPant);
        addTocartBtn=findViewById(R.id.addtocartbutton);

        database= FirebaseDatabase.getInstance().getReference().child("Pant");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myAdapter =new MyAdapterPant(this,list);
        recyclerView.setAdapter(myAdapter);

      //  addTocartBtn.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View view) {
         //       Intent intent=new Intent(Pant.this,AddToCart.class);
                //intent.put;


            //    startActivity(intent);
          //  }
      //  });

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    PantData data =dataSnapshot.getValue(PantData.class);
                    list.add(data);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void moveback(View view){
        startActivity(new Intent(Pant.this, com.myfirst.fashionbae.activities.HomePage.class));
    }
}