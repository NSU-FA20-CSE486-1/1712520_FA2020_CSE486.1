package com.afridi.homefood.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.afridi.homefood.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_splash_screen);

        startActivity(new Intent(this, Authentication.class));
        finish();

    }

    private void authentication() {

    }

    private void route() {

    }
}



