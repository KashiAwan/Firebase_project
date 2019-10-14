package com.example.firebaseproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Logi_Firebasee extends AppCompatActivity {

    TextView name_login;
    EditText log_emaill,log_pass;

    Button loginn_log;

    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    DatabaseReference refff;

    String Email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logi__firebasee);

        name_login = findViewById(R.id.login_name_show);
        log_emaill = findViewById(R.id.login_emaill);
        log_pass = findViewById(R.id.login_passswrd);
        loginn_log = findViewById(R.id.but_lginn);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        Email2 = sharedpreferences.getString("namees", "");
        if (Email2 != null){
        name_login.setText(Email2);
        }else{
            Toast.makeText(this, "No name found", Toast.LENGTH_SHORT).show();
        }

        loginn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refffunction();
            }
        });
    }
    public void refffunction() {

        refff= FirebaseDatabase.getInstance().getReference().child("Firebase_test_App").child(name_login.getText().toString());

        refff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Email1=dataSnapshot.child("Email").getValue().toString();
                String Password1=dataSnapshot.child("Password").getValue().toString();

                if(log_emaill.getText().toString().equals(Email1) && log_pass.getText().toString().equals(Password1) ){
                    minlocfun();
                }
                else if( !log_emaill.getText().toString().equals(Email1)   && log_pass.getText().toString().equals(Password1) ){
                    Toast.makeText(Logi_Firebasee.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }
                else if( log_emaill.getText().toString().equals(Email1)   && !log_pass.getText().toString().equals(Password1)  ){
                    Toast.makeText(Logi_Firebasee.this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
                }
                else if( !log_emaill.getText().toString().equals(Email1)   && !log_pass.getText().toString().equals(Password1) ){
                    Toast.makeText(Logi_Firebasee.this, "Sign Up First or Enter Email & Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void minlocfun(){
        Intent intent= new Intent(this, Login_acttivity.class);
        startActivity(intent);
    }
}
