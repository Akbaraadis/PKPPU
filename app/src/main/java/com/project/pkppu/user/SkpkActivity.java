package com.project.pkppu.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

public class SkpkActivity extends AppCompatActivity {

    Button button;
    EditText kk, ktp, sk;
    LinearLayout l_kk, l_ktp, l_sk;

    String nik;

    private static final int PICKFILE_RESULT_CODE = 1;
    private static final int PICKFILE_RESULT_CODE2 = 2;
    private static final int PICKFILE_RESULT_CODE3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skpk);

        getSupportActionBar().hide();

        kk = findViewById(R.id.detail_skpk_kk);
        ktp = findViewById(R.id.detail_skpk_ktp);
        sk = findViewById(R.id.detail_skpk_rtrw);

        l_kk = findViewById(R.id.skpk_ll_kk);
        l_ktp = findViewById(R.id.skpk_ll_ktp);
        l_sk = findViewById(R.id.skpk_ll_rtrw);

        button = findViewById(R.id.skpk_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });

        l_sk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
//                intentPDF.setType("application/pdf");
//                intentPDF.addCategory(Intent.CATEGORY_OPENABLE);

                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE);
            }
        });

        l_ktp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE2);
            }
        });

        l_kk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE3);
            }
        });

        nik = getIntent().getStringExtra("nik");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICKFILE_RESULT_CODE:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    sk.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE2:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    ktp.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE3:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    kk.setText(FilePath+".pdf");
                }
                break;
        }
    }

    void postData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/add_skpk.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_SHORT).show();
//                        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                        Intent intent =new Intent(SkpkActivity.this, HomeUserActivity.class);
                        intent.putExtra("nik", nik);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("kk_alm", kk.getText().toString());
                params.put("ktp_alm", ktp.getText().toString());
                params.put("sk_rtrw", sk.getText().toString());
                params.put("nik", nik);
                params.put("status", "new_request");

                return params;
            }
        };
        queue.add(postRequest);
    }
}