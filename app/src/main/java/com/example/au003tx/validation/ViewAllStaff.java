package com.example.au003tx.validation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewAllStaff extends AppCompatActivity {

    List<productStaff> productList;
    RecyclerView recyclerView;
    CustomListViewStaff adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_staff);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        loadProducts();
    }


    private void loadProducts() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.43.103/Services/ViewStaffDetails.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.d("responseinview", response);
                            Toast.makeText(ViewAllStaff.this, "IN LOAD", Toast.LENGTH_SHORT).show();
                            JSONArray array = new JSONArray(response);

                            for (int i = 0; i < array.length(); i++) {

                                JSONObject product = array.getJSONObject(i);

                                String cc = product.getString("name");
                                String ct = product.getString("role");
                                String p = product.getString("email");
                                String d = product.getString("phone");
                                String l = product.getString("qualification");
                                String s = product.getString("prmdno");

                                productStaff obj = new productStaff(cc, ct, p, d, l, s);

                                productList.add(obj);
                            }
                            adapter = new CustomListViewStaff(ViewAllStaff.this, productList);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            Toast.makeText(ViewAllStaff.this, "ERROR IN JSON" + e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("string", error.toString());
                        Toast.makeText(ViewAllStaff.this, "ERROR IN RESPONSE" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}
