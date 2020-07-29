package com.example.au003tx.validation;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class Registration extends AppCompatActivity {

     private static EditText centreName,emailAddress,password,confirmPassword,address,city,state,phone;
     private static Button register;
     //private TextView login1;
    private static TextView tv_login,login1;
    //private ProgressBar progress;
    private static final String empty_key = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        centreName = (EditText)findViewById(R.id.edit_centreName);
        emailAddress = (EditText)findViewById(R.id.edit_email);
        password = (EditText)findViewById(R.id.edit_password);
        confirmPassword = (EditText)findViewById(R.id.edit_confirmPassword);
        address = (EditText)findViewById(R.id.edit_address);
        city = (EditText)findViewById(R.id.edit_city);
        state = (EditText)findViewById(R.id.edit_state);
        phone = (EditText)findViewById(R.id.edit_phone);
        register = (Button)findViewById(R.id.btn_register);
        login1 = (TextView)findViewById(R.id.login1);
        //tv_login = (TextView)findViewById(R.id.tv_login);

        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Registration.this,login.class);
                finish();
                startActivity(intent);
            }
        });

        //login = (TextView)findViewById(R.id.textView_login);
        //progress=(ProgressBar)findViewById(R.id.progressBar2);
        //progress.setVisibility(View.INVISIBLE);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Log.d("strrrr","button Click");
               if(validateInputs()) {
                   registration();

               }
               else
               {
                   Toast.makeText(getApplicationContext(),"Error in data entry",Toast.LENGTH_SHORT).show();
               }
            }
        });


    }

    private void registration(){
        String url = "http://192.168.43.103/Services/Signup.php?cn="+centreName.getText().toString()+"&pwd="+password.getText().toString()+"&mob="+phone.getText().toString()+"&email="+emailAddress.getText().toString()+"&add="+address.getText().toString()+"&city="+city.getText().toString()+"&state="+state.getText().toString();
        getJSON(url);

    }

/*

    public void registration(){
    class ValidateWork extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {
            Log.d("strrrr","Validating Data");
            if (empty_key.equals(centreName.getText().toString())) {
                centreName.setError("CentreName cannot be empty");
                centreName.requestFocus();
                return "0";

            }
            if (empty_key.equals(emailAddress.getText().toString())){
                emailAddress.setError("Emaid Address cannot be empty");
                emailAddress.requestFocus();
                return "0";

            }
            if(password.getText().toString().length()<8)
            {
                password.setError("password length must be more than 8");
                password.requestFocus();
                return "0";
            }
            if(!password.getText().toString().equals(confirmPassword.getText().toString()))
            {
                confirmPassword.setError("password and confirmpassword is not match!");
                confirmPassword.requestFocus();
                return "0";
            }
            if (empty_key.equals(address.getText().toString())){
                address.setError("Address cannot be empty");
                address.requestFocus();
                 return "0";
            }
            if (empty_key.equals(city.getText().toString())){
                city.setError("City cannot be empty");
                city.requestFocus();
                return "0";
            }

            if (empty_key.equals(state.getText().toString())){
                state.setError("state cannot be empty");
                state.requestFocus();
                return "0";
            }

            return "1";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if(s.equals("1"))
            {

                //Log.d("strrrr","Valid");
                //progress.setVisibility(View.VISIBLE);
                String url = "http://192.168.43.103/Services/Signup.php?cn="+centreName.getText().toString()+"&pwd="+password.getText().toString()+"&mob="+phone.getText().toString()+"&email="+emailAddress.getText().toString()+"&add="+address.getText().toString()+"&city="+city.getText().toString()+"&state="+state.getText().toString();
                getJSON(url);
            }
            else
            {
                //Log.d("strrrr","Invalid");
                Toast.makeText(getApplicationContext(),"Incorrect Data",Toast.LENGTH_LONG).show();
            }
        }
    }
        ValidateWork vw = new ValidateWork();
        vw.execute();
    }
    */

   private boolean validateInputs() {
        if (empty_key.equals(centreName.getText().toString())) {
            centreName.setError("CentreName cannot be empty");
            centreName.requestFocus();
            return false;

        }
        if (empty_key.equals(emailAddress.getText().toString())){
            emailAddress.setError("Emaid Address cannot be empty");
            emailAddress.requestFocus();
            return false;

        }
        if(password.getText().toString().length()<8)
        {
            password.setError("password length must be more than 8");
            password.requestFocus();
            return false;
        }
        if(!password.getText().toString().equals(confirmPassword.getText().toString()))
        {
            confirmPassword.setError("password and confirmpassword is not match!");
            confirmPassword.requestFocus();
            return false;
        }
        if (empty_key.equals(address.getText().toString())){
            address.setError("Address cannot be empty");
            address.requestFocus();
            return false;
            }
        if (empty_key.equals(city.getText().toString())){
            city.setError("City cannot be empty");
            city.requestFocus();
            return false;
        }

        if (empty_key.equals(state.getText().toString())){
            state.setError("state cannot be empty");
            state.requestFocus();
            return false;
        }

        return true;
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
                    Toast.makeText(getApplicationContext(),"Registeration Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this,login.class);
                    finish();
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Registeration Fail",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Registration.this,Registration.class);
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