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

public class MyAdapterCatseye extends RecyclerView.Adapter<MyAdapterCatseye.MyViewHolder> {

    Context context;
    ArrayList<CatseyeData> list;

    public MyAdapterCatseye(Context context, ArrayList<CatseyeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterCatseye.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemcatseye,parent,false);
        return new MyAdapterCatseye.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CatseyeData catseye=list.get(position);
        holder.brandName.setText(catseye.getBrandName());
        holder.size.setText(catseye.getSize());
        holder.price.setText(catseye.getPrice());


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
