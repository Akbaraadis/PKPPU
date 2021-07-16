package com.project.pkppu.admin.skpk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.project.pkppu.R;

import java.util.HashMap;
import java.util.Map;

public class DetailSkpkActivity extends AppCompatActivity {

    EditText rtrw, ktp, kk, nik, status;
    Button pending, approve;

    String no_req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_skpk);

        getSupportActionBar().setTitle("Detail");

        rtrw = findViewById(R.id.detail_skpk_rtrw);
        ktp = findViewById(R.id.detail_skpk_ktp);
        kk = findViewById(R.id.detail_skpk_kk);
        nik = findViewById(R.id.detail_skpk_nik);
        status = findViewById(R.id.detail_skpk_status);

        pending = findViewById(R.id.detail_skpk_pending);
        approve = findViewById(R.id.detail_skpk_approve);

        getIncomingIntent();

        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pendingData();
            }
        });

        approve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                approveData();
            }
        });
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("no_req_skpk") && getIntent().hasExtra("kk_alm") && getIntent().hasExtra("ktp_alm") && getIntent().hasExtra("sk_rtrw") && getIntent().hasExtra("nik") && getIntent().hasExtra("status")) {

            String no_req2 = getIntent().getStringExtra("no_req_skpk");
            String kk_alm = getIntent().getStringExtra("kk_alm");
            String ktp_alm = getIntent().getStringExtra("ktp_alm");
            String sk_rtrw = getIntent().getStringExtra("sk_rtrw");
            String nik2 = getIntent().getStringExtra("nik");
            String status2 = getIntent().getStringExtra("status");

            kk.setText(kk_alm);
            ktp.setText(ktp_alm);
            rtrw.setText(sk_rtrw);
            nik.setText(nik2);
            status.setText(status2);

            no_req = no_req2;
        }
    }

    void approveData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/update_skpk.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"Data Berhasil Diperbaharui",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(DetailSkpkActivity.this, SkpkAdminActivity.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "Data Gagal Diperbaharui", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("no_req_skpk", no_req);
                params.put("status", "approve");

                return params;
            }
        };
        queue.add(postRequest);
    }

    void pendingData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/update_skpk.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"Data Berhasil Diperbaharui",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(DetailSkpkActivity.this, SkpkAdminActivity.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "Data Gagal Diperbaharui", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("no_req_skpk", no_req);
                params.put("status", "pending");

                return params;
            }
        };
        queue.add(postRequest);
    }

//    @Override
//    public void onBackPressed() {
//        moveTaskToBack(true);
//        finish();
//    }
}