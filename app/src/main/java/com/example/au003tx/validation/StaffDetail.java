package com.example.au003tx.validation;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class StaffDetail extends AppCompatActivity {

    private static EditText name, role, phone, email, qualifaction, prmdno;
    private static Button submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff_detail);

        name = (EditText)findViewById(R.id.name);
        role = (EditText)findViewById(R.id.role);
        phone = (EditText)findViewById(R.id.phone);
        email = (EditText)findViewById(R.id.mail);
        qualifaction = (EditText)findViewById(R.id.qualification);
        prmdno = (EditText)findViewById(R.id.prmdno);
        submit = (Button)findViewById(R.id.submit_btn);


        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
              submitdata();
            }
        });

    }

    private void submitdata(){
        String url = "http://192.168.43.103/Services/CentreStaffMaster.php?name="+name.getText().toString()+"&role="+role.getText().toString()+"&phone="+phone.getText().toString()+"&email="+email.getText().toString()+"&qualification="+qualifaction.getText().toString()+"&prmdno="+prmdno.getText().toString();
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
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                // progress.setVisibility(View.INVISIBLE);
                if(s.equals("1"))
                {
                    Toast.makeText(getApplicationContext(),"Data entered Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StaffDetail.this,Home.class);
                    finish();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Something went wrong!! please fill it again",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(StaffDetail.this,StaffDetail.class);
                    finish();
                    startActivity(intent);
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

}
