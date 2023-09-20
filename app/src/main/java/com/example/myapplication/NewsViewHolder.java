package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;


public class NewsViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView description;
    public TextView content;

    public ImageView image;

    public NewsViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.item_title);
        description = itemView.findViewById(R.id.item_description);
        content = itemView.findViewById(R.id.item_content);
        image = itemView.findViewById(R.id.item_image);
    }
}
