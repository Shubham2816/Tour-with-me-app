package com.example.myapplication.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.myapplication.Adapter.PicListAdapter;
import com.example.myapplication.Model.ItemModel;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityDetailBinding;

import java.util.ArrayList;

public class DetailActivity extends BaseActivity {

    ActivityDetailBinding binding;
    private ItemModel object;
    private boolean isFavorite = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getIntentExtra();
        setVariable();
        initList();
    }

    private void initList() {
        ArrayList<String> picList= new ArrayList<>(object.getPic());

        Glide.with(this)
                .load(picList.get(0))
                .into(binding.pic);

        binding.picList.setAdapter(new PicListAdapter(picList,binding.pic));
        binding.picList.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    private void setVariable() {

        binding.titleTxt.setText(object.getTitle());
        binding.priceTxt.setText("$" + object.getPrice());
////        binding.backBtn.setOnClickListener(v -> finish()); // Back button click handler
////        binding.favBtn.setOnClickListener(v -> toggleFavorite()); // Favorite button click handl
//        binding.backBtn.setImageResource(R.drawable.back);



//    binding.favBtn.setImageResource(R.drawable.fav_icon);
//        binding.backBtn.setBackgroundResource(R.drawable.back);
//        binding.backBtn.setOnClickListener(v -> {
//            // Handle back button click
//            finish();  // Close the current activity
//        });



        binding.backBtn.setImageResource(R.drawable.back);
        binding.backBtn.setOnClickListener(v -> {
            // When the back button (image) is clicked, finish the activity
            finish();
        });


        binding.favBtn.setImageResource(R.drawable.fav_icon);
        binding.favBtn.setOnClickListener(v -> {
            // Toggle favorite button click
            toggleFavorite();
        });


        binding.bedTxt.setText("" + object.getBed());
        binding.durationTxt.setText(object.getDuration());
        binding.distanceTxt.setText(object.getDistance());
        binding.descriptionTxt.setText(object.getDescription());
        binding.addressTxt.setText(object.getAddress());
        binding.ratingTxt.setText(object.getScore() + " Rating");
        binding.ratingBar.setRating((float) object.getScore());

        // Set images
        binding.imageView11.setImageResource(R.drawable.hourglass); // Adjust the image as needed
        binding.imageView112.setImageResource(R.drawable.distance);
        binding.imageView101.setImageResource(R.drawable.bed);
    }

    private void toggleFavorite() {
        if (isFavorite) {
            // If it's already a favorite, change the image to the empty heart
            binding.favBtn.setImageResource(R.drawable.fav_icon); // Empty heart icon
            isFavorite = false;
        } else {
            // If it's not a favorite, change the image to the filled heart (red)
            binding.favBtn.setImageResource(R.drawable.star); // Filled heart icon (red)
            isFavorite = true;
        }
    }

    private void getIntentExtra() {
        object=(ItemModel) getIntent().getSerializableExtra("object");
    }
}