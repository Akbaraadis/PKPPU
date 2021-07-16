package com.project.pkppu.admin.skmk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.project.pkppu.R;
import com.project.pkppu.admin.HomeAdminActivity;
import com.project.pkppu.admin.skpk.SkpkAdminActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SkmkAdminActivity extends AppCompatActivity {

    private RecyclerView mList;

    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;
    private List<Skmk> skmkList;
    private RecyclerView.Adapter adapter;

    private String url = "http://192.168.0.110/api_ku/get_skmk.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skmk_admin);

        mList = findViewById(R.id.main_list);

        skmkList = new ArrayList<>();
        adapter = new SkmkAdapter(getApplicationContext(), skmkList);

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

                        Skmk skmk = new Skmk();
                        skmk.setNo_req_skmk(jsonObject.getString("no_req_skmk"));
                        skmk.setFile_makam(jsonObject.getString("file_makam"));
                        skmk.setFile_s_materai(jsonObject.getString("file_s_materai"));
                        skmk.setFile_rtrw(jsonObject.getString("file_rtrw"));
                        skmk.setKtp_pengurus(jsonObject.getString("ktp_pengurus"));
                        skmk.setKtp_almarhum(jsonObject.getString("ktp_almarhum"));
                        skmk.setKk_almarhum(jsonObject.getString("kk_almarhum"));
                        skmk.setStatus(jsonObject.getString("status"));
                        skmk.setNik(jsonObject.getString("nik"));


                        skmkList.add(skmk);
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
        Intent intent = new Intent(SkmkAdminActivity.this, HomeAdminActivity.class);
        startActivity(intent);
        finish();
    }
}