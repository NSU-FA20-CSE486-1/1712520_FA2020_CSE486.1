package com.afridi.BanglaDictionary;

import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    Context context;
    LayoutInflater layoutInflater;

    private List<Words> vocabularyList;

    public WordAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setVocabularyList(List<Words> vocabularyList) {
        this.vocabularyList = vocabularyList;
        notifyDataSetChanged();
    }

    public Words getVocabulary(int position) {
        return vocabularyList.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.item_word, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (vocabularyList != null) {
            Words vocabulary = vocabularyList.get(position);

            holder.mEnglish.setText(vocabulary.getEnglish());
        }
    }

    @Override
    public int getItemCount() {
        if (vocabularyList != null) {
            return vocabularyList.size();
        } else {
            return 0;
        }
    }

public static class ViewHolder extends RecyclerView.ViewHolder {

    TextView mEnglish;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mEnglish = itemView.findViewById(R.id.tvEnglishWord);
    }
}
}
