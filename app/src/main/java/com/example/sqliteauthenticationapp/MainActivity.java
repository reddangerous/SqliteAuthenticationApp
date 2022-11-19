package com.example.sqliteauthenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    DbHelper db;
    EditText Email, Password;
    MaterialButton SignIn;
    TextView Signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email = findViewById(R.id.inputEmail);
        Password = findViewById(R.id.inputPassword);
        SignIn = findViewById(R.id.SignIn);
        Signup = findViewById(R.id.textCreateNewAccount);
        db = new DbHelper(this);


        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String email =  Email.getText().toString();
                String pass = Password.getText().toString();
                if(email.equals("")||pass.equals("")){
                    Toast.makeText(MainActivity.this, "All Fields Are Required", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean chechuseremailpass = db.CheckEmailPassword(email,pass);
                    if(chechuseremailpass == true){
                        Toast.makeText(MainActivity.this, "Sign in Succesful", Toast.LENGTH_SHORT).show();
                        //intent Home Activity

                    }else{
                        Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SuignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}