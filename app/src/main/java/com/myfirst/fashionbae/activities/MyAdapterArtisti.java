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

public class MyAdapterArtisti extends RecyclerView.Adapter<MyAdapterArtisti.MyViewHolder>{

    Context context;
    ArrayList<ArtistiData> list;

    public MyAdapterArtisti(Context context, ArrayList<ArtistiData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyAdapterArtisti.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.itemartisti,parent,false);
        return new MyAdapterArtisti.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapterArtisti.MyViewHolder holder, int position) {
        ArtistiData artisti =list.get(position);
        holder.brandName.setText(artisti.getBrandName());
        holder.size.setText(artisti.getSize());
        holder.price.setText(artisti.getPrice());


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
