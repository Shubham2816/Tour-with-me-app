package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityIntroBinding;

public class IntroActivity extends BaseActivity {

    ActivityIntroBinding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        binding.introBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }
}