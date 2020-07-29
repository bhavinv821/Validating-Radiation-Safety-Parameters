package com.example.au003tx.validation;



import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AdapterView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MachineDetailsActivity extends AppCompatActivity {


    private static EditText manufacture, model, maxkv, ma, year, disA, disB, disC, disD, thickA, thickB, thickC, thickD;
    private static Button submit;
    private static String machine, material;
    private static Spinner spinner11,spinner2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_details);

        manufacture = (EditText)findViewById(R.id.manufacture);
        model = (EditText)findViewById(R.id.model);
        maxkv = (EditText)findViewById(R.id.maxkv);
        ma = (EditText)findViewById(R.id.ma);
        year = (EditText)findViewById(R.id.year);

        disA = (EditText)findViewById(R.id.walldistanceA);
        disB= (EditText)findViewById(R.id.walldistanceB);
        disC= (EditText)findViewById(R.id.walldistanceC);
        disD= (EditText)findViewById(R.id.walldistanceD);
        thickA=(EditText)findViewById(R.id.wallthicknessA);
        thickB=(EditText)findViewById(R.id.wallthicknessB);
        thickC=(EditText)findViewById(R.id.wallthicknessC);
        thickD=(EditText)findViewById(R.id.wallthicknessD);
        submit = (Button)findViewById(R.id.submit_btn);







        spinner11 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner status = (Spinner) findViewById(R.id.aprovalstatus);
        Spinner s3 = (Spinner)findViewById(R.id.playcard);


        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Computed Tomography");
        categories.add("Dental_CBCT/OPG");
        categories.add("Interventional Radiology(Cardiac Angiography)");
        categories.add("Mammography");
        categories.add("Radiography and Fluoroscopy");





        List<String> options = new ArrayList<String>();
        options.add("NO");
        options.add("YES");

        List<String> options2 = new ArrayList<String>();
        options2.add("Baryte Plaster");
        options2.add("Brick");
        options2.add("Gypsum Wallboard");
        options2.add("Lead");
        options2.add("Plate Glass");
        options2.add("Steel");

     //   Spinner playcard = (Spinner) findViewById(R.id.playcard);
        List<String> options1 = new ArrayList<String>();
        options1.add("NO");
        options1.add("YES");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options);
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options1);
        ArrayAdapter<String> dataAdapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, options2);

        // Drop down layout style - list view with radio button
        //dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner11.setAdapter(dataAdapter);
        status.setAdapter(dataAdapter2);
        s3.setAdapter(dataAdapter3);
        spinner2.setAdapter(dataAdapter4);






        // Spinner click listener
        spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                machine = (String)spinner11.getSelectedItem();
                //Toast.makeText(getApplicationContext(),machine,Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                material = (String)spinner2.getSelectedItem();


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        final Button upload = (Button)findViewById(R.id.aerb_btn);
        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    upload.setVisibility(View.INVISIBLE);
                }
                else
                {
                    upload.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

        });


        final Button upload_playcard = (Button)findViewById(R.id.playcard_btn);
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position==0)
        {
            upload_playcard.setVisibility(View.INVISIBLE);
        }
        else
        {
            upload_playcard.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
});

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                detail_submit();

            }
        });

    }


    private void detail_submit(){




        String tempUrl = null;
        try {


            tempUrl = URLEncoder.encode(manufacture.getText().toString(),"UTF-8")
                    +"&model="+ URLEncoder.encode(model.getText().toString(),"UTF-8")
                    +"&maxkv="+URLEncoder.encode(maxkv.getText().toString(),"UTF-8")
                    +"&ma="+URLEncoder.encode(ma.getText().toString(),"UTF-8")
                    +"&year="+URLEncoder.encode(year.getText().toString(),"UTF-8")
                    +"&material="+URLEncoder.encode(material,"UTF-8")
                    +"&machine="+URLEncoder.encode(machine,"UTF-8")
                    +"&disA="+URLEncoder.encode(disA.getText().toString(),"UTF-8")
                    +"&disB="+URLEncoder.encode(disB.getText().toString(),"UTF-8")
                    +"&disC="+URLEncoder.encode(disC.getText().toString(),"UTF-8")+
                    "&disD="+URLEncoder.encode(disD.getText().toString(),"UTF-8")
                    +"&thickA="+URLEncoder.encode(thickA.getText().toString(),"UTF-8")
                    +"&thickB="+URLEncoder.encode(thickB.getText().toString(),"UTF-8")
                    +"&thickC="+URLEncoder.encode(thickC.getText().toString(),"UTF-8")
                    +"&thickD="+URLEncoder.encode(thickD.getText().toString(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        String url = null;
            url = "http://192.168.43.103/Services/MachineDetails.php?manufacture="+tempUrl;

        Log.e("try1", "detail_submit: " + url);
        getJSON(url);
    }




    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                Log.e("try1", "doInBackground: " + "Pre");
            }


            @Override
            protected void onPostExecute(String s) {
                Log.e("try1","inside post exceute : " + s);
                super.onPostExecute(s);
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                //progress.setVisibility(View.INVISIBLE);
                if (s.equals("1")) {

                    Toast.makeText(getApplicationContext(),"Data entered successfully",Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MachineDetailsActivity.this, Home.class);
                    finish();
                    startActivity(i);

                    //Toast.makeText(getApplicationContext(), "Login successfully", Toast.LENGTH_SHORT);
                } else {
                   // Toast.makeText(getApplicationContext(),"Invalid data, Please enter it again",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                    //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(MachineDetailsActivity.this, MachineDetailsActivity.class);
                    finish();
                    startActivity(i);
                    // Toast.makeText(getApplicationContext(), "Email or password is not valid", Toast.LENGTH_SHORT);
                }

            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    Log.e("try1", "url : " +urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    con.setRequestMethod("GET");
                    con.setDoOutput(false);
                    Log.e("try1",con.getResponseCode()+"");
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    Log.e("try1", "doInBackground: -> " + sb.toString());
                    return sb.toString().trim();

                } catch (Exception e) {
                    e.printStackTrace();
                   // Toast.makeText(MachineDetailsActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.e("try1", "doInBackground: " + "Exception" + e.getMessage());
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }




}
