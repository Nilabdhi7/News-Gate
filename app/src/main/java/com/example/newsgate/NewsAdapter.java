package com.example.newsgate;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    Context context;
    ArrayList<NewsModelClass> newsModelClassArrayList;

    public NewsAdapter(Context context, ArrayList<NewsModelClass> newsModelClassArrayList) {
        this.context = context;
        this.newsModelClassArrayList = newsModelClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,webView.class);
                intent.putExtra("url",newsModelClassArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.nHeadline.setText(newsModelClassArrayList.get(position).getTitle());
        holder.nContent.setText(newsModelClassArrayList.get(position).getDescription());
        holder.nAuthor.setText(newsModelClassArrayList.get(position).getAuthor());
        holder.nTime.setText("Published At - "+newsModelClassArrayList.get(position).getPublishedAt());
        Glide.with(context).load(newsModelClassArrayList.get(position).getUrlToImage()).into(holder.nImage);

    }


    @Override
    public int getItemCount() {
        return newsModelClassArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView nHeadline,nContent,nAuthor,nTime;
        ImageView nImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardView);
            nHeadline = itemView.findViewById(R.id.mainHeading);
            nContent = itemView.findViewById(R.id.content);
            nAuthor =itemView.findViewById(R.id.author);
            nTime = itemView.findViewById(R.id.time);
            nImage = itemView.findViewById(R.id.imageView);
        }
    }
}
