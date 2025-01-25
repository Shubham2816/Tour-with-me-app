package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Activities.DetailActivity;
import com.example.myapplication.Model.ItemModel;
import com.example.myapplication.databinding.ViewholderPopularBinding;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    public PopularAdapter(ArrayList<ItemModel> items) {
        this.items = items;
        this.context = context;
        this.binding = binding;
    }

    ArrayList<ItemModel> items;

Context context;
ViewholderPopularBinding binding;
    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       binding = ViewholderPopularBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
       context=parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
binding.titleTxt.setText(items.get(position).getTitle());
binding.priceTxt.setText("$"+items.get(position).getPrice()+"/Night");
binding.addressTxt.setText(items.get(position).getAddress());
binding.scoreTxt.setText(""+items.get(position).getScore());

        Glide.with(context)
                .load(items.get(position).getPic().get(0))
                .into(binding.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent= new Intent(context, DetailActivity.class);
                intent.putExtra("object", items.get(position));
                context.startActivity(intent);



            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderPopularBinding binding) {

            super(binding.getRoot());
        }
    }
}
