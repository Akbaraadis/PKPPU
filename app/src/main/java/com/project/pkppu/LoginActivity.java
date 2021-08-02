package com.project.pkppu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.project.pkppu.admin.HomeAdminActivity;
import com.project.pkppu.user.HomeUserActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    Button loginbtn;
    TextView tvdaftar;
    EditText email, password;

    int role = 0;
    String nik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        loginbtn = findViewById(R.id.login_btn);
        tvdaftar = findViewById(R.id.login_daftar);

        email = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = email.getText().toString();
                String text2 = password.getText().toString();

                if(text1.isEmpty() || text2.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Email / Password belum diisi", Toast.LENGTH_SHORT).show();
                }
                else{
                    postDataUsingVolley();
                }
            }
        });

        tvdaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }

    private void postDataUsingVolley() {
        // url to post our data
        String url = "http://192.168.0.110/api_ku/login.php";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);

        // on below line we are calling a string
        // request method to post the data to our API
        // in this we are calling a post method.
        StringRequest request = new StringRequest(Request.Method.POST, url, new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject respObj = new JSONObject(response);

                    role = respObj.getInt("role");
                    nik = respObj.getString("nik");

                    Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_SHORT).show();

                    tohomepage();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // method to handle errors.
                Toast.makeText(LoginActivity.this, "Email atau Password salah", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();

                params.put("email", email.getText().toString());
                params.put("password", password.getText().toString());

                return params;
            }
        };
        queue.add(request);
    }

    private void tohomepage(){
        if(role == 2){
            Intent intent =new Intent(LoginActivity.this, HomeUserActivity.class);
            intent.putExtra("nik", nik);
            startActivity(intent);
            finish();
        }

        if(role == 1){
            Intent intent2 =new Intent(LoginActivity.this, HomeAdminActivity.class);
            intent2.putExtra("nik", nik);
            startActivity(intent2);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}