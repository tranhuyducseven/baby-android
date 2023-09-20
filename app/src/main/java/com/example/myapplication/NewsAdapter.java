package com.example.myapplication;

import android.content.Context;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    final private List<NewsItem> newsItemList;
    final private Context context;

    public NewsAdapter(Context context, List<NewsItem> newsItemList) {
        this.context = context;
        this.newsItemList = newsItemList;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        NewsItem newsItem = newsItemList.get(position);

        // Bind data to views
        holder.title.setText(newsItem.getTitle());
        holder.description.setText(newsItem.getDescription());

        // Bind content to TextView
        final Markwon markwon = Markwon.builder(context).usePlugin(HtmlPlugin.create()).build();
        markwon.setMarkdown(holder.content, newsItem.getContent());

        // Use a library like Picasso or Glide to load and display the image
//         Picasso.get().load(newsItem.getImageMap()).into(holder.image);
        String url = newsItem.getImageMap().get(0).getImageUrl();
        Picasso.get().load(url).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return newsItemList.size();
    }


}
