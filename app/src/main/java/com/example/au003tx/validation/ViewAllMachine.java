package com.example.au003tx.validation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
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
import java.util.HashMap;
import java.util.List;

public class ViewAllMachine extends AppCompatActivity {

    List<Product> productList;
    RecyclerView recyclerView;
    CustomListView adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_machine);

        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productList = new ArrayList<>();

        loadProducts();
    }


    private void loadProducts() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://192.168.43.103/Services/viewMachineDetails.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            Log.d("responseinview", response);

                            JSONArray array = new JSONArray(response);
                            Toast.makeText(ViewAllMachine.this, "IN LOAD", Toast.LENGTH_SHORT).show();
                            for (int i = 0; i < array.length(); i++) {

                                JSONObject product = array.getJSONObject(i);

                                String cc = product.getString("machinetype");
                                String ct = product.getString("make");
                                String p = product.getString("model");
                                String d = product.getString("year_of_install");
                                String l = product.getString("maxkv");
                                String s = product.getString("ma");
                                String sd = product.getString("walldistance_A");
                                String acd = product.getString("walldistance_B");
                                String ab = product.getString("walldistance_C");
                                String ac = product.getString("walldistance_D");
                                String ad = product.getString("wallmaterial");
                                String ae = product.getString("wallthickness_A");
                                String af = product.getString("wallthickness_B");
                                String ag = product.getString("wallthickness_C");
                                String ah = product.getString("wallthickness_D");


                                Product obj = new Product(cc, ct, p, d, l, s, acd, sd, ab, ac, ad, ae, af, ag, ah);


                                //adding the product to product list
                               /* productList.add(new GoodModel(
                                        product.getString("COMPLAN_CATEGORY"),
                                        product.getString("COMPLAIN_TYPE"),
                                        product.getString("photo"),
                                        product.getString("description"),
                                        product.getString("location"),
                                        product.getString("status"),
                                        product.getString("app_comp_date"),
                                        product.getString("start_date")
                                ));*/
                                productList.add(obj);
                            }
                            adapter = new CustomListView(ViewAllMachine.this, productList);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            Toast.makeText(ViewAllMachine.this, "ERROR IN JSON" + e.toString(), Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("string", error.toString());
                        Toast.makeText(ViewAllMachine.this, "ERROR IN RESPONSE" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });

        Volley.newRequestQueue(this).add(stringRequest);
    }
}

