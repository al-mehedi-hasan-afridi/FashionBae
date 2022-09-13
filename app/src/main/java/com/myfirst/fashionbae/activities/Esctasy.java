package com.myfirst.fashionbae.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myfirst.fashionbae.R;

import java.util.ArrayList;

public class Esctasy extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapterEsctasy myAdapter;
    ArrayList<EsctasyData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_esctasy);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_esctasyshop);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

        recyclerView =findViewById(R.id.pEsctasy);

        database= FirebaseDatabase.getInstance().getReference().child("Esctasy");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myAdapter = new MyAdapterEsctasy(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    EsctasyData data =dataSnapshot.getValue(EsctasyData.class);
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
        startActivity(new Intent(Esctasy.this, com.myfirst.fashionbae.activities.ShopActivity.class));
    }


}
