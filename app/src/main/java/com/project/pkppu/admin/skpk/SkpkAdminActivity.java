package com.project.pkppu.admin.skpk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.project.pkppu.R;
import com.project.pkppu.admin.HomeAdminActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SkpkAdminActivity extends AppCompatActivity {

    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Skpk> skpkList;
    private RecyclerView.Adapter adapter;

    private String url = "http://192.168.0.110/api_ku/get_skpk.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skpk_admin);

        mList = findViewById(R.id.main_list);

        skpkList = new ArrayList<>();
        adapter = new SkpkAdapter(getApplicationContext(),skpkList);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dividerItemDecoration = new DividerItemDecoration(mList.getContext(), linearLayoutManager.getOrientation());

        mList.setHasFixedSize(true);
        mList.setLayoutManager(linearLayoutManager);
        mList.addItemDecoration(dividerItemDecoration);
        mList.setAdapter(adapter);

        getSupportActionBar().hide();

        getData();
    }

    private void getData() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);

                        Skpk skpk = new Skpk();
                        skpk.setNo_req_skpk(jsonObject.getString("no_req_skpk"));
                        skpk.setKk_alm(jsonObject.getString("kk_alm"));
                        skpk.setKtp_alm(jsonObject.getString("ktp_alm"));
                        skpk.setSk_rtrw(jsonObject.getString("sk_rtrw"));
                        skpk.setnik(jsonObject.getString("nik"));
                        skpk.setstatus(jsonObject.getString("status"));

                        skpkList.add(skpk);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        progressDialog.dismiss();
                    }
                }
                adapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", error.toString());
                progressDialog.dismiss();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SkpkAdminActivity.this, HomeAdminActivity.class);
        startActivity(intent);
        finish();
    }
}