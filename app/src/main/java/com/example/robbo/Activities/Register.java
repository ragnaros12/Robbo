package com.example.robbo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.robbo.Adapters.SpinnerAdapter;
import com.example.robbo.Models.Image;
import com.example.robbo.R;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon);
        ByteArrayOutputStream streamJM = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, streamJM);
        byte[] imageInByte = streamJM.toByteArray();

        ArrayList<Image> images = new ArrayList<>();
        images.add(new Image(imageInByte));
        images.add(new Image(imageInByte));
        images.add(new Image(imageInByte));
        images.add(new Image(imageInByte));

        SpinnerAdapter adapter = new SpinnerAdapter(getApplicationContext(), R.layout.spinnerelement, images, R.id.EmptyText);

        ((Spinner)findViewById(R.id.spiner)).setAdapter(adapter);
    }

    public void ClickToLogin(View w){
        Intent i = new Intent(getApplicationContext(), Login.class);
        startActivity(i);
    }

    public void ClickToRegister(View w){
        EditText login = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        EditText email = findViewById(R.id.email);

        String LoginStr = login.getText().toString();
        String PasswordStr = password.getText().toString();

        if(!TextUtils.isEmpty(email.getText().toString()) && android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
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
        else{
            Toast.makeText(getApplicationContext(), "email не валиден", Toast.LENGTH_LONG).show();
        }
    }
}