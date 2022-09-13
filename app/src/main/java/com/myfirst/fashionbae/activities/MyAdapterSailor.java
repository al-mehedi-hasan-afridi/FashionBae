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

public class MyAdapterSailor extends RecyclerView.Adapter<MyAdapterSailor.MyViewHolder> {
    Context context;
    ArrayList<SailorData> list;

    public MyAdapterSailor(Context context, ArrayList<SailorData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterSailor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemsailor,parent,false);
        return new MyAdapterSailor.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterSailor.MyViewHolder holder, int position) {
        SailorData sailor=list.get(position);
        holder.brandName.setText(sailor.getBrandName());
        holder.size.setText(sailor.getSize());
        holder.price.setText(sailor.getPrice());


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
