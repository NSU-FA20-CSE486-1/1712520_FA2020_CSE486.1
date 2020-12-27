package com.afridi.securemessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Button btnSend = findViewById(R.id.sendButton);
    Button btnDecrypt = findViewById(R.id.decryptButton);
    EditText phoneNum = findViewById(R.id.etPhoneNumber);
    EditText privetKey = findViewById(R.id.etPrivateKey);
    EditText messageBody = findViewById(R.id.etMessage);



}
