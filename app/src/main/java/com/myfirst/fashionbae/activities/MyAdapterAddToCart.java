package com.myfirst.fashionbae.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.myfirst.fashionbae.R;

import java.util.ArrayList;

public class MyAdapterAddToCart extends RecyclerView.Adapter<MyAdapterAddToCart.MyViewHolder>{

    Context context;
    ArrayList<AddToCartData> list;

    public MyAdapterAddToCart(Context context, ArrayList<AddToCartData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterAddToCart.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemaddtocart,parent,false);
        return new MyAdapterAddToCart.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterAddToCart.MyViewHolder holder, int position) {
        AddToCartData addToCart=list.get(position);
        holder.brandName.setText(addToCart.getBrandName());
        holder.price.setText(addToCart.getPrice());
        holder.size.setText(addToCart.getSize());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView brandName,price,size;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            brandName =itemView.findViewById(R.id.Bname);
            price=itemView.findViewById(R.id.Price);
            size = itemView.findViewById(R.id.size);
        }
    }
}
