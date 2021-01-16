package com.afridi.BanglaDictionary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import io.paperdb.Paper;

public class WordListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Words> wordList;
    WordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        recyclerView = findViewById(R.id.recyclerView);

        Paper.init(this);
        wordList = Paper.book().read("word", new ArrayList<>());

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);

        adapter = new WordAdapter(this);

        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(WordListActivity.this, recyclerView, (view, position) ->{
          Words word = adapter.getVocabulary(position);
          showDialog(word);
        }));

        recyclerView.setAdapter(adapter);
        adapter.setVocabularyList(wordList);
    }

    private void showDialog(Words word) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogBox);

        builder.setTitle(word.getBangla());

        builder.setCancelable(true);
        builder.show();
    }
}