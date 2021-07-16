package com.project.pkppu.admin.skmk;

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
import com.project.pkppu.admin.skpk.DetailSkpkActivity;
import com.project.pkppu.admin.skpk.SkpkAdminActivity;

import java.util.HashMap;
import java.util.Map;

public class DetailSkmkActivity extends AppCompatActivity {

    EditText rtrw, ktp, ktp2, kk, nik, status, makam, materai;
    Button pending, approve;

    String no_req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_skmk);

        getSupportActionBar().setTitle("Detail");

        rtrw = findViewById(R.id.detail_skmk_rtrw);
        ktp = findViewById(R.id.detail_skmk_ktp);
        ktp2 = findViewById(R.id.detail_skmk_ktp_pengurus);
        kk = findViewById(R.id.detail_skmk_kk);
        makam = findViewById(R.id.detail_skmk_makam);
        materai = findViewById(R.id.detail_skmk_materai);
        nik = findViewById(R.id.detail_skmk_nik);
        status = findViewById(R.id.detail_skmk_status);

        pending = findViewById(R.id.detail_skmk_pending);
        approve = findViewById(R.id.detail_skmk_approve);

        getIncomingIntent();

        Toast.makeText(DetailSkmkActivity.this, no_req, Toast.LENGTH_SHORT).show();

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
        if (getIntent().hasExtra("no_req_skmk")) {

            String no_req2 = getIntent().getStringExtra("no_req_skmk");
            String kk_alm = getIntent().getStringExtra("kk_alm");
            String ktp_alm = getIntent().getStringExtra("ktp_alm");
            String sk_rtrw = getIntent().getStringExtra("sk_rtrw");
            String ktp_pengurus = getIntent().getStringExtra("ktp_pengurus");
            String file_makam = getIntent().getStringExtra("file_makam");
            String file_s_materai = getIntent().getStringExtra("file_s_materai");
            String nik2 = getIntent().getStringExtra("nik");
            String status2 = getIntent().getStringExtra("status");

            kk.setText(kk_alm);
            ktp.setText(ktp_alm);
            rtrw.setText(sk_rtrw);
            nik.setText(nik2);
            status.setText(status2);
            ktp2.setText(ktp_pengurus);
            makam.setText(file_makam);
            materai.setText(file_s_materai);

            no_req = no_req2;
        }
    }

    void approveData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/update_skmk.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"Data Berhasil Diperbaharui",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(DetailSkmkActivity.this, SkmkAdminActivity.class);
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
                params.put("no_req_skmk", no_req);
                params.put("status", "approve");

                return params;
            }
        };
        queue.add(postRequest);
    }

    void pendingData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/update_skmk.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(),"Data Berhasil Diperbaharui",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(DetailSkmkActivity.this, SkmkAdminActivity.class);
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
                params.put("no_req_skmk", no_req);
                params.put("status", "pending");

                return params;
            }
        };
        queue.add(postRequest);
    }

}