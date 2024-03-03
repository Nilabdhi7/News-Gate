package com.example.newsgate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HealthFragment extends Fragment {
    String api ="456c3c4c97ad496296477917f3b9f1cd";
    ArrayList<NewsModelClass> newsModelClassArrayList;
    NewsAdapter newsAdapter;
    String country ="in";
    private RecyclerView recyclerViewHealth;
    private  String category ="health";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View v = inflater.inflate(R.layout.healthfragment,null);

      recyclerViewHealth = v.findViewById(R.id.recyclerViewOfHealth);
      newsModelClassArrayList = new ArrayList<>();
      recyclerViewHealth.setLayoutManager(new LinearLayoutManager(getContext()));
      newsAdapter = new NewsAdapter(getContext(),newsModelClassArrayList);
      recyclerViewHealth.setAdapter(newsAdapter);

      FindHealthNews();
      return v;
    }

    private void FindHealthNews() {
        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful())
                {
                    newsModelClassArrayList.addAll(response.body().getArticles());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
