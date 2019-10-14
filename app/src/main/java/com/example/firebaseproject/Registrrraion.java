package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrrraion extends AppCompatActivity {

    EditText namee,emaill,pass;

    Button regster;

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrrraion);

        namee = findViewById(R.id.namee);
        emaill = findViewById(R.id.emaill);
        pass = findViewById(R.id.passswrd);
        regster = findViewById(R.id.regstr);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        regster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedfpreffrencfunc();

                firrebasefunc();

                Intent regstr = new Intent(Registrrraion.this,MainActivity.class);
                startActivity(regstr);

                Toast.makeText(Registrrraion.this, "Successfully Registerd", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void sharedfpreffrencfunc(){
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("namees" , namee.getText().toString());
        editor.apply();
    }

    public void firrebasefunc(){

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef= database.getReference("Firebase_test_App");

        myRef.child(namee.getText().toString()).child("Email").setValue(emaill.getText().toString());
        myRef.child(namee.getText().toString()).child("Password").setValue(pass.getText().toString());

    }

}
