package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button reg , lgin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg = findViewById(R.id.regstr);
        lgin = findViewById(R.id.lgin);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regstr = new Intent(MainActivity.this,Registrrraion.class);
                startActivity(regstr);
            }
        });

        lgin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lginn = new Intent(MainActivity.this,Logi_Firebasee.class);
                startActivity(lginn);
            }
        });
    }
}
