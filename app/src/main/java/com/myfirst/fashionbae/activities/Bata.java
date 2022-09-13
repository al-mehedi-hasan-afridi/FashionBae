package com.myfirst.fashionbae.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myfirst.fashionbae.R;

import java.util.ArrayList;

public class Bata extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseReference database;
    MyAdapterBata myAdapter;
    ArrayList<BataData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bata);
        getSupportActionBar().hide();

        ImageView backbutton = findViewById(R.id.backbutton_batashop);
        backbutton.setOnClickListener(view -> {
            moveback(view);
        } );

        recyclerView =findViewById(R.id.pBata);

        database= FirebaseDatabase.getInstance().getReference().child("Bata");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        myAdapter = new MyAdapterBata(this,list);
        recyclerView.setAdapter(myAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    BataData data =dataSnapshot.getValue(BataData.class);
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
        startActivity(new Intent(Bata.this, com.myfirst.fashionbae.activities.ShopActivity.class));
    }
}
