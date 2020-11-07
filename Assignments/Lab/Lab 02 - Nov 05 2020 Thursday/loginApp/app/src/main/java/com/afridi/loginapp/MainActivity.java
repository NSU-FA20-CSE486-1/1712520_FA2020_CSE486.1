package com.afridi.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText in1 = (EditText)findViewById(R.id.editTextTextPersonName);
    EditText in2 = (EditText)findViewById(R.id.editTextTextPassword);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void login(View view){

    }
}