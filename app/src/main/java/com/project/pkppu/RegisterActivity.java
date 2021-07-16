package com.project.pkppu;

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

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    Button regisbtn;
    EditText nik, full_name, email, password, address, phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().hide();

        regisbtn = findViewById(R.id.regis_btn);
        nik = findViewById(R.id.regis_nik);
        full_name = findViewById(R.id.regis_nama);
        email = findViewById(R.id.regis_email);
        password = findViewById(R.id.regis_password);
        address = findViewById(R.id.regis_alamat);
        phone_number = findViewById(R.id.regis_notelp);

        regisbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postData();
            }
        });

    }

    void postData(){

        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://192.168.0.110/api_ku/add_user.php";
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Toast.makeText(getApplicationContext(),"Registrasi Berhasil",Toast.LENGTH_SHORT).show();
                        Intent intent =new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("nik", nik.getText().toString());
                params.put("full_name", full_name.getText().toString());
                params.put("email", email.getText().toString());
                params.put("password", password.getText().toString());
                params.put("address", address.getText().toString());
                params.put("phone_number", phone_number.getText().toString());
                params.put("id_role", "2");

                return params;
            }
        };
        queue.add(postRequest);
    }
}