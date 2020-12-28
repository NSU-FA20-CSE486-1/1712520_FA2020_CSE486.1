package com.afridi.securemessaging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Crypto crypto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button)findViewById(R.id.sendButton);
        Button btnDecrypt = (Button)findViewById(R.id.decryptButton);

        EditText phoneNum = (EditText)findViewById(R.id.etPhoneNumber);
        EditText privateKey = (EditText)findViewById(R.id.etPrivateKey);
        EditText messageBody = (EditText)findViewById(R.id.etMessage);

        crypto = new Crypto();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Number = phoneNum.getText().toString();
                String sms = messageBody.getText().toString();
                String key = privateKey.getText().toString();

                if (Number.isEmpty() || sms.isEmpty() || key.isEmpty()) {
                    btnSend.setError("");
                    return;
                }

                int keyValue = 0;
                for (char c : key.toCharArray()) {
                    if (Character.isDigit(c)) {
                        keyValue += Character.getNumericValue(c);
                    }
                }

                String cryptoSms = null;

                cryptoSms = crypto.encrypt(sms, keyValue);

                try{
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:"+Number));
                    intent.putExtra("sms_body", key+" "+cryptoSms);
                    startActivity(intent);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DecryptActivity.class);
                startActivity(intent);
            }
        });


    }
}
