package com.afridi.securemessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class DecryptActivity extends AppCompatActivity {
    Crypto crypto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt2);

        crypto = new Crypto();
        EditText EncryptedSms = (EditText)findViewById(R.id.etEncryptedSMS);
        Button btnDecryption = (Button)findViewById(R.id.decryptButton);
        Button btnEncryption = (Button)findViewById(R.id.encryptButton);
        TextView sms = (TextView)findViewById(R.id.tvDecryptedSMS);


        btnDecryption.setOnClickListener(v -> {
            String cypheredSms = EncryptedSms.getText().toString();

            if (cypheredSms.isEmpty()){
                btnDecryption.setError("");
                return;
            }
            
            String[] str = cypheredSms.split(" ",2);
            String pKey =str[0];
            String eSms = str[1];

            try {
                String actualSms = crypto.decrypt(eSms, Integer.parseInt(pKey));
                sms.setText(actualSms );

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        btnEncryption.setOnClickListener(v -> {
            Intent intent = new Intent(DecryptActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
}