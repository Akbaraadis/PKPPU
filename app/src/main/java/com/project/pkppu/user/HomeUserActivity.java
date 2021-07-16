package com.project.pkppu.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.pkppu.LoginActivity;
import com.project.pkppu.R;

public class HomeUserActivity extends AppCompatActivity {

    Button Skmk, Skpk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeuser);

        getSupportActionBar().hide();

        String nik = getIntent().getStringExtra("nik");

        Skmk = findViewById(R.id.homeuser_skmk);
        Skpk = findViewById(R.id.homeuser_skpk);

        Skmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeUserActivity.this, SkmkActivity.class);
                intent.putExtra("nik", nik);
                startActivity(intent);
            }
        });

        Skpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeUserActivity.this, SkpkActivity.class);
                intent.putExtra("nik", nik);
                startActivity(intent);
            }
        });

    }
}