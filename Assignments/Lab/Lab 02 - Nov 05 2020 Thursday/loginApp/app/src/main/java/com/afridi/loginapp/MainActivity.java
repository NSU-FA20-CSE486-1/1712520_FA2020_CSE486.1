package com.afridi.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inUsername = findViewById(R.id.etUsername);
        EditText inPassword = findViewById(R.id.etPassword);
        Button inLogin = findViewById(R.id.btnLogin);

        inLogin.setOnClickListener(v -> {
            String username = inUsername.getText().toString();
            String password =   inPassword.getText().toString();

            if(username.equals("user") && password.equals("1234")) {
                Toast.makeText(MainActivity.this, "Successful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}