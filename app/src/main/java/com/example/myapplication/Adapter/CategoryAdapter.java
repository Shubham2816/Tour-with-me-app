package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Model.CategoryModel;
import com.example.myapplication.databinding.ViewholderCategoryBinding;
import com.google.firebase.database.core.view.View;
import com.bumptech.glide.Glide;


import java.time.Instant;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.Viewholder> {

    private final List<CategoryModel> items;
    private Context context;
    private AdapterView.OnItemClickListener onItemClickListener;

    public CategoryAdapter(List<CategoryModel> items) {
        this.items = items; this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public CategoryAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context =parent.getContext();
        ViewholderCategoryBinding binding =ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false);

        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.Viewholder holder, int position) {
CategoryModel item = items.get(position);
holder.binding.title.setText(item.getName());

        Glide.with(context)
        .load(item.getImagePath())
        .into(holder.binding.pic);


        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                // Pass the clicked item to the onItemClickListener
                onItemClickListener.onItemClick(null, v, position, v.getId());
            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        private final ViewholderCategoryBinding binding;
        public Viewholder(ViewholderCategoryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
