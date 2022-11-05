package com.example.beerapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.beerapp.Model.ResponseClass;
import com.example.beerapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.myViewHolder>
{
    List<ResponseClass> data;
 Context context;
    public recyclerViewAdapter(Context context, List<ResponseClass> data)
    {
        this.data = data;
        this.context = context;
    }



    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_xml,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position)
    {
       holder.name.setText(data.get(position).getName());
       holder.brand.setText(data.get(position).getBrand());
       holder.alcohol.setText("Alcohol: "+data.get(position).getAlcohol());
//        Picasso.get().load(data.get(position).getUid())
//                .fit().into(holder.beerImage);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
     TextView name,brand,alcohol;
     ImageView beerImage;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.beerName);
        brand = itemView.findViewById(R.id.brandName);
        alcohol = itemView.findViewById(R.id.alcoholPercentage);
        beerImage = itemView.findViewById(R.id.images);
    }
}
}
