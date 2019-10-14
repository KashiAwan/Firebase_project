package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login_acttivity extends AppCompatActivity {

    Button but_add,but_delete,but_updat,but_getaldata,but_logout;
    TextView login_name;

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_acttivity);

        login_name = findViewById(R.id.login_name);
        but_add = findViewById(R.id.but_add);
        but_delete = findViewById(R.id.but_dlt);
        but_updat = findViewById(R.id.but_updat);
        but_getaldata = findViewById(R.id.but_getaldata);
        but_logout = findViewById(R.id.but_logout);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        savenamee();

        but_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_acttivity.this, Add_Activityy.class);
                startActivity(intent);
            }
        });

        but_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_acttivity.this, Delete_Activityy.class);
                startActivity(intent);
            }
        });

        but_updat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_acttivity.this, Update_Activityy.class);
                startActivity(intent);
            }
        });

        but_getaldata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_acttivity.this, GetAllData_Activityy.class);
                startActivity(intent);
            }
        });
        but_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Login_acttivity.this, Logi_Firebasee.class);
                startActivity(intent);
            }
        });
    }

    public void savenamee(){

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String namee = sharedpreferences.getString("namees", "");
        login_name.setText(namee);
    }
}
