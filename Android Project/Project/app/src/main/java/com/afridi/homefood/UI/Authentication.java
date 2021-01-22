package com.afridi.homefood.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.afridi.homefood.R;
import com.google.firebase.auth.FirebaseAuth;

public class Authentication extends AppCompatActivity {

    private String email, password, errMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        
        findViewById(R.id.sign_up).setOnClickListener(e -> {
            Intent i = new Intent(this, Registration.class);
            startActivityForResult(i,1);
        });
    }
}