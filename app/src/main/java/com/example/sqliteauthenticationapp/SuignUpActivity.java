package com.example.sqliteauthenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SuignUpActivity extends AppCompatActivity {
    EditText Email, Password,cpassword, Names;
    MaterialButton SignUp;
    TextView SignIn;
    DbHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suign_up);

        Email = findViewById(R.id.inputEmail);
        Names = findViewById(R.id.inputName);
        Password = findViewById(R.id.inputPassword);
        cpassword = findViewById(R.id.inputConfirmPassword);
        SignUp = findViewById(R.id.SignUp);
        SignIn = findViewById(R.id.textCreateSignIn);
        db = new DbHelper(this);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        String email = Email.getText().toString();
         String names= Names.getText().toString();
        String pass=  Password.getText().toString();
         String cpass=  cpassword.getText().toString();

         if(email.equals("")||pass.equals("")||names.equals("")||cpass.equals("")) {
             Toast.makeText(SuignUpActivity.this, "Please fill All The fields", Toast.LENGTH_SHORT).show();
         }else{
             if(pass.equals(cpass)){
                 Boolean checkuser = db.checkEmail(email);
                 if(checkuser == false){
                     boolean insert = db.insertData(email,pass,names);
                     if(insert == true){
                         Toast.makeText(SuignUpActivity.this, "Resgistration Succeeded", Toast.LENGTH_SHORT).show();

                     }else{
                         Toast.makeText(SuignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                 }
             }else {
                     Toast.makeText(SuignUpActivity.this, "User Arleady Exist", Toast.LENGTH_SHORT).show();
                 }
             }else {
                 Toast.makeText(SuignUpActivity.this, "Password Does Not Match !! Trie Again", Toast.LENGTH_SHORT).show();
             }
         }


            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SuignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}