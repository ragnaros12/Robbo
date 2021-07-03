package com.example.robbo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.robbo.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void ClickToLogin(View w){
        EditText login = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        String LoginStr = login.getText().toString();
        String PasswordStr = password.getText().toString();

        if(!LoginStr.replace(" ", "").equals("") && LoginStr.length() > 3){
            if(PasswordStr.length() > 5 && !PasswordStr.replace(" ", "").equals("")){

            }
            else{
                Toast.makeText(getApplicationContext(), "password не соответсвует требованиям", Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(getApplicationContext() , "login не соответсвует требованиям", Toast.LENGTH_LONG).show();
        }
    }

    public void ClickToRegister(View w){
        Intent i = new Intent(getApplicationContext(), Register.class);
        startActivity(i);
    }
}