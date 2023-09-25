package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import io.noties.markwon.Markwon;
import io.noties.markwon.html.HtmlPlugin;


public class PostsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        String message = getIntent().getStringExtra("selected_news_item");

        NewsItem newsItem = new Gson().fromJson(message, NewsItem.class);

        // Get components
        TextView title = findViewById(R.id.post_title);
        TextView description = findViewById(R.id.post_description);
        TextView content = findViewById(R.id.post_content);
        ImageView image = findViewById(R.id.post_image);
        final Markwon markwon = Markwon.builder(this).usePlugin(HtmlPlugin.create()).build();

        // Bind data to components
        title.setText(newsItem.getTitle());
        description.setText(newsItem.getDescription());
        markwon.setMarkdown(content, newsItem.getContent());
        String url = newsItem.getImageMap().get(0).getImageUrl();
        Picasso.get().load(url).into(image);
    }
}
