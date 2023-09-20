package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private NewsAdapter adapter;
    final private List<NewsItem> newsItemList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://stock-api.f247.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService service = retrofit.create(ApiService.class);

        // Make a request to the API and get a response
        Call<List<NewsItem>> call = service.getNews();

          call.enqueue(new Callback<List<NewsItem>>() {
                @SuppressLint("NotifyDataSetChanged")
                @Override
                public void onResponse(@NonNull Call<List<NewsItem>> call, @NonNull Response<List<NewsItem>> response) {
                    // Handle a successful response
                    if (response.isSuccessful()) {
                        // Get the list of news articles
                        assert response.body() != null;
                        List<NewsItem> newsItems = response.body();
                        // Add the list of news articles to the list of items in the adapter
                        Log.d("MainActivity", "Items: " + newsItems);
                        newsItemList.addAll(newsItems);
                        // Notify the adapter that items have been added
                        adapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(@NonNull Call<List<NewsItem>> call, @NonNull Throwable t) {
                    // Handle an error response
                    Log.e("MainActivity", "Error: " + t.getMessage());
                }
            });

          // Handle render of the list of news articles

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        adapter = new NewsAdapter(this, newsItemList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
