package com.afridi.securemessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


import static com.afridi.securemessaging.Crypto.encrypt;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.sendButton);
        Button btnDecrypt = findViewById(R.id.decryptButton);

        EditText phoneNum = findViewById(R.id.etPhoneNumber);
        EditText privetKey = findViewById(R.id.etPrivateKey);
        EditText messageBody = findViewById(R.id.etMessage);

        Crypto crypto = new Crypto();

        btnDecrypt.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DecryptActivity.class);
            startActivity(intent);
        });

        btnSend.setOnClickListener(v -> {
            String Number = phoneNum.getText().toString();
            String sms = messageBody.getText().toString();
            String key = privetKey.getText().toString();

            String cryptoSms = null;
            try {
                cryptoSms = encrypt(sms, key);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:"+Number));
                intent.putExtra("sms_body",key +" "+ cryptoSms);
                startActivity(intent);
            }catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        });

    }

}
