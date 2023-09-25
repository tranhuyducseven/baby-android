package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {
    final private List<NewsItem> newsItemList;
    final private Context context;

    public CardAdapter(Context context, List<NewsItem> newsItemList) {
        this.context = context;
        this.newsItemList = newsItemList;
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        NewsItem newsItem = newsItemList.get(position);

        // Bind data to views
        holder.title.setText(newsItem.getTitle());
        String url = newsItem.getImageMap().get(0).getImageUrl();
        Picasso.get().load(url).into(holder.image);

        //handle click event on the holder
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //use itent to put antoher activity, first create parse newsItem to JSON
                String newsItemJson = new Gson().toJson(newsItem);
                //create intent
                Intent intent = new Intent(context, PostsActivity.class);
                intent.putExtra("selected_news_item", newsItemJson);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return newsItemList.size();
    }


}
