package com.afridi.loginapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.loginApp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText inUsername = (EditText) findViewById(R.id.etUsername);
        EditText inPassword = (EditText) findViewById(R.id.etPassword);

        String username = inUsername.getText().toString();
        String password = inPassword.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, username);

        if(username.equals("afridi") && password.equals("1234")) {
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
        }

    }
}