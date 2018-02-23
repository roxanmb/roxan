package com.example.lenovo.gsonparse;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView songTitle;
    public TextView songYear;
    public TextView songAuthor;
    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        songTitle = (TextView)itemView.findViewById(R.id.song_title);
        songYear = (TextView)itemView.findViewById(R.id.song_year);
        songAuthor = (TextView)itemView.findViewById(R.id.song_author);
    }
    @Override
    public void onClick(View view) {
    }
}