package com.example.au003tx.validation;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;
import android.content.Intent;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.AuthFailureError;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class login extends AppCompatActivity {


    private static EditText email;
    private static EditText password;
    private static TextView newuser,fp;
    private static Button login;





    //private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        fp = (TextView) findViewById(R.id.fp);
        newuser = (TextView) findViewById(R.id.newuser);
        //progressBar = findViewById(R.id.progressBar);
        //progressBar.setVisibility(View.GONE);


        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(login.this, Registration.class);
                finish();
                startActivity(i);

            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {


                //SharedPreferences pref = getApplicationContext().getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
                //SharedPreferences.Editor editor = pref.edit();

                //editor.putString("session", email.getText().toString());
                //editor.commit();

                loginuser();
            }
        });


        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotofp();
            }


        });
    }

    private void loginuser(){
        String url = "http://192.168.43.103/Services/Login.php?email="+email.getText().toString()+"&pwd="+password.getText().toString();

        getJSON(url);
    }



    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Log.d("try1", "doInBackground: " + s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                //progress.setVisibility(View.INVISIBLE);
                if (s.equals("0")) {

                    Toast.makeText(getApplicationContext(),"Email or Password is invalid",Toast.LENGTH_SHORT).show();

                    //Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(getApplicationContext(),s, Toast.LENGTH_SHORT);

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();

                    editor.putString("centrename",s);
                    editor.commit();
                    //String  CenterName=pref.getString("centrename", "123");

                    Toast.makeText(getApplicationContext(),pref.getString("centrename", "123"), Toast.LENGTH_SHORT);

                    Intent i = new Intent(login.this, Home.class);
                    finish();
                    startActivity(i);

                    // Toast.makeText(getApplicationContext(), "Email or password is not valid", Toast.LENGTH_SHORT);
                }

            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }


    public void gotofp()
    {
        try {
            final  String e=email.getText().toString();
            Toast.makeText(this, e, Toast.LENGTH_SHORT).show();
            /*  Intent intent = new Intent(getApplicationContext(), forgetpassword.class);*/
            StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://192.168.43.103/Services/mail.php", new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("strrrr", ">>" + response);
                    try {

                        if(e==null)
                        {
                            Toast.makeText(login.this, "Your PASSEORD is SENDED to your mail ID" + e, Toast.LENGTH_LONG).show();

                        }
                        else {
                            Toast.makeText(login.this, "Enter Email", Toast.LENGTH_SHORT).show();
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(login.this, "IN JSON EXCEPTION" + e.toString(), Toast.LENGTH_SHORT).show();


                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(login.this, "ERROR IN RESPONSE LISTENER", Toast.LENGTH_SHORT).show();

                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError
                {
                    Map<String,String> params=new HashMap<>();
                    params.put("email",e);
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

        }
        catch (Exception e)
        {
            Toast.makeText(this, "ERROR"+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
