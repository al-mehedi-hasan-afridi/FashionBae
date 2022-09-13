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

public class MyAdapterBata extends RecyclerView.Adapter<MyAdapterBata.MyViewHolder> {
    Context context;
    ArrayList<BataData> list;

    public MyAdapterBata(Context context, ArrayList<BataData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterBata.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itembata,parent,false);
        return new MyAdapterBata.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterBata.MyViewHolder holder, int position) {
        BataData bata=list.get(position);
        holder.brandName.setText(bata.getBrandName());
        holder.size.setText(bata.getSize());
        holder.price.setText(bata.getPrice());


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
