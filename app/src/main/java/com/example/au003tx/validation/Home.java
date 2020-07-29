package com.example.au003tx.validation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class Home extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences prefs = getSharedPreferences("PREFS_NAME", MODE_PRIVATE);
        final String  CenterName=prefs.getString("centrename", "123");

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(CenterName);
        Button machine = (Button)findViewById(R.id.machine_btn);
        Button stafff = (Button)findViewById(R.id.staff_btn);
        Button editProfile = (Button)findViewById(R.id.edit_btn);
        Button machinedetailview = (Button)findViewById(R.id.viewmachine_btn);
        Button viewstaff = (Button)findViewById(R.id.viewstaff);




        machine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this,MachineDetailsActivity.class);
                finish();
                startActivity(intent);
            }
        });

        stafff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,StaffDetail.class);
                finish();
                startActivity(intent);
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,viewProfileActivity.class);
                finish();
                startActivity(intent);
            }
        });



        machinedetailview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this,ViewAllMachine.class);
                finish();
                startActivity(intent);
            }
        });

        viewstaff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this,ViewAllStaff.class);
                finish();
                startActivity(intent);
            }
        });
    }


}
