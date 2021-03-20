package com.example.hacknu2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


public class HomeActivity extends AppCompatActivity {

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding viewpager, creating adapter for showing right fragment and setting it to that
        //and setting tabLayout with the viewPager

//        ViewPager viewPager = findViewById(R.id.viewPager);
//
//        CategoryAdapter categoryAdapter = new CategoryAdapter(this, getSupportFragmentManager());
//
//        viewPager.setAdapter(categoryAdapter);
//
//        TabLayout tabLayout = findViewById(R.id.tabLayout);
//
//        tabLayout.setupWithViewPager(viewPager);

    }

}

