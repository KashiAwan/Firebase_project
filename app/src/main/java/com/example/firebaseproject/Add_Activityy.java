package com.example.firebaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add_Activityy extends AppCompatActivity {

    EditText clg_name, clg_cntct, clg_address;
    Button add_buttt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__activityy);

        clg_name = findViewById(R.id.college_name);
        clg_cntct =findViewById(R.id.college_contacat);
        clg_address =findViewById(R.id.college_address);

        add_buttt =findViewById(R.id.Add_college);

        add_buttt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firrebasefunc();
            }
        });
    }

    public void firrebasefunc(){

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference myRef= database.getReference("Firebase_test_App");

        myRef.child("College").child(clg_name.getText().toString()).child("Contact").setValue(clg_cntct.getText().toString());
        myRef.child("College").child(clg_name.getText().toString()).child("Address").setValue(clg_address.getText().toString());

    }
}
