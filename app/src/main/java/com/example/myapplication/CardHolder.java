package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class CardHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public ImageView image;

    public CardHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.card_title);
        image = itemView.findViewById(R.id.card_image);
    }
}
