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

public class SkmkActivity extends AppCompatActivity {

    Button button;
    EditText tahun, makam, materai, rtrw, ktp_pengurus, ktp_alm, kk_alm;
    LinearLayout l_makam, l_materai, l_rtrw, l_ktp_pengurus, l_ktp_alm, l_kk_alm;

    private static final int PICKFILE_RESULT_CODE = 1;
    private static final int PICKFILE_RESULT_CODE2 = 2;
    private static final int PICKFILE_RESULT_CODE3 = 3;
    private static final int PICKFILE_RESULT_CODE4 = 4;
    private static final int PICKFILE_RESULT_CODE5 = 5;
    private static final int PICKFILE_RESULT_CODE6 = 6;

    String nik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skmk);

        getSupportActionBar().hide();

        tahun = findViewById(R.id.skmk_tahun);
        makam = findViewById(R.id.skmk_makam);
        materai = findViewById(R.id.skmk_pernyataan);
        rtrw = findViewById(R.id.skmk_rtrw);
        ktp_pengurus = findViewById(R.id.skmk_ktppengurus);
        ktp_alm = findViewById(R.id.skmk_ktpalmarhum);
        kk_alm = findViewById(R.id.skmk_kkalmarhum);

        l_makam = findViewById(R.id.skmk_ll_makam);
        l_materai = findViewById(R.id.skmk_ll_pernyataan);
        l_rtrw = findViewById(R.id.skmk_ll_rtrw);
        l_ktp_pengurus = findViewById(R.id.skmk_ll_ktppengurus);
        l_ktp_alm = findViewById(R.id.skmk_ll_ktpalmarhum);
        l_kk_alm = findViewById(R.id.skmk_ll_kkalmarhum);

        button = findViewById(R.id.skmk_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });

        l_makam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE);
            }
        });

        l_materai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE2);
            }
        });

        l_rtrw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE3);
            }
        });

        l_ktp_pengurus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE4);
            }
        });

        l_ktp_alm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE5);
            }
        });

        l_kk_alm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPDF = new Intent(Intent.ACTION_GET_CONTENT);
                intentPDF.setType("application/pdf");
                startActivityForResult(intentPDF, PICKFILE_RESULT_CODE6);
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
                    makam.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE2:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    materai.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE3:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    rtrw.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE4:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    ktp_pengurus.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE5:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    ktp_alm.setText(FilePath+".pdf");
                }
                break;

            case PICKFILE_RESULT_CODE6:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getData().getLastPathSegment();
                    kk_alm.setText(FilePath+".pdf");
                }
                break;
        }
    }

    void postData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/add_skmk.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(getApplicationContext(),"Berhasil",Toast.LENGTH_SHORT).show();
//                        Toast.makeText(this, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                        Intent intent =new Intent(SkmkActivity.this, HomeUserActivity.class);
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
                params.put("thn_meninggal", tahun.getText().toString());
                params.put("file_makam", makam.getText().toString());
                params.put("file_s_materai", materai.getText().toString());
                params.put("file_rtrw", rtrw.getText().toString());
                params.put("ktp_pengurus", ktp_pengurus.getText().toString());
                params.put("ktp_almarhum", ktp_alm.getText().toString());
                params.put("kk_almarhum", kk_alm.getText().toString());
                params.put("status", "new_request");
                params.put("nik", nik);

                return params;
            }
        };
        queue.add(postRequest);
    }
}