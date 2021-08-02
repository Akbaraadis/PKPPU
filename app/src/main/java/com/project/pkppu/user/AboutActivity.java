package com.project.pkppu.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.project.pkppu.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        getSupportActionBar().hide();
    }
}