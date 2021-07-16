package com.project.pkppu.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.project.pkppu.LoginActivity;
import com.project.pkppu.R;
import com.project.pkppu.admin.skmk.SkmkAdminActivity;
import com.project.pkppu.admin.skpk.SkpkAdminActivity;
import com.project.pkppu.user.SkpkActivity;

public class HomeAdminActivity extends AppCompatActivity {

    Button btn_skpk, btn_skmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        getSupportActionBar().hide();

        btn_skmk = findViewById(R.id.homeadmin_skmk);
        btn_skpk = findViewById(R.id.homeadmin_skpk);

        btn_skpk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAdminActivity.this, SkpkAdminActivity.class);
                startActivity(intent);
            }
        });

        btn_skmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAdminActivity.this, SkmkAdminActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}