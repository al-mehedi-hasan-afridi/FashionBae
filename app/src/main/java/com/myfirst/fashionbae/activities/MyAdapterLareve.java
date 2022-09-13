package com.myfirst.fashionbae.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.myfirst.fashionbae.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapterLareve extends RecyclerView.Adapter<MyAdapterLareve.MyViewHolder> {
    Context context;
    ArrayList<LareveData> list;

    public MyAdapterLareve(Context context, ArrayList<LareveData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterLareve.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemlareve,parent,false);
        return new MyAdapterLareve.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterLareve.MyViewHolder holder, int position) {
        LareveData lareve=list.get(position);
        holder.brandName.setText(lareve.getBrandName());
        holder.size.setText(lareve.getSize());
        holder.price.setText(lareve.getPrice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView brandName,size,price;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            brandName =itemView.findViewById(R.id.Bname);
            size=itemView.findViewById(R.id.size);
            price=itemView.findViewById(R.id.Price);

        }
    }


}
