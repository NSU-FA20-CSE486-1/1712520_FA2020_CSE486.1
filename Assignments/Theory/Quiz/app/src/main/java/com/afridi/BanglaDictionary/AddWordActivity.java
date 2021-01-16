package com.afridi.BanglaDictionary;

import androidx.appcompat.app.AppCompatActivity;
import io.paperdb.Paper;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;



public class AddWordActivity extends AppCompatActivity {

    ArrayList<Words> wordList;
    TextView mBanglaDictionary;
    EditText mEnglishWord;
    EditText mBanglaword;
    Button btnSave;
    Button btnList;
    Words vocabulary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBanglaDictionary = (TextView)findViewById(R.id.tvBanglaDictionary);
        mEnglishWord = (EditText)findViewById(R.id.etEnglishWord);
        mBanglaword = (EditText)findViewById(R.id.etBanglaWord);
        btnSave = (Button)findViewById(R.id.buttonSave);
        btnList = (Button)findViewById(R.id.buttonList);

        Paper.init(this);
        wordList = Paper.book().read("word", new ArrayList<>());

        btnList.setOnClickListener(view -> {
            Intent intent = new Intent(AddWordActivity.this,WordListActivity.class);
            startActivity(intent);
        });

        btnSave.setOnClickListener(v -> {

                String english = mEnglishWord.getText().toString();
                String bangla = mBanglaword.getText().toString();

                if (english.isEmpty() || bangla.isEmpty()) {
                    btnSave.setError("");
                    return;
                }

                vocabulary = new Words(english, bangla);


                wordList.add(vocabulary);

                // insert data into paperDB
                Paper.book().write("word", wordList);
                Toast.makeText(this, "New word added!", Toast.LENGTH_LONG).show();

        });

        btnList.setOnClickListener(view -> {
            Intent intent = new Intent(AddWordActivity.this,WordListActivity.class);
            startActivity(intent);
        });
    }
}