package com.cs.covid_19karnataka.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cs.covid_19karnataka.NewsItem;
import com.cs.covid_19karnataka.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<NewsItem> mnewsItems;

    public NewsAdapter (Context context, ArrayList<NewsItem> newsItemList)
    {
    mContext = context;
    mnewsItems = newsItemList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.news_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
    final String title = mnewsItems.get(position).getTitle();
    final String description = mnewsItems.get(position).getDescription();
    final String image = mnewsItems.get(position).getImage();
    final String url = mnewsItems.get(position).getUrl();
    final String published = mnewsItems.get(position).getPublishedAt();
    final String name = mnewsItems.get(position).getName();

    String metadata = ""+name+" • "+published;
    holder.news_meta.setText(metadata);
    holder.news_title.setText(title);
    holder.news_description.setText(description);



    if (image!=null)
    {
        try
        {
            Picasso.get().load(image).fetch(new Callback() {
                @Override
                public void onSuccess() {
                    Picasso.get().load(image).networkPolicy(NetworkPolicy.OFFLINE).into(holder.news_image);
                }

                @Override
                public void onError(Exception e) {
                holder.news_image.setVisibility(View.GONE);
                }
            });

        }catch (Exception e)
        {
            holder.news_image.setVisibility(View.GONE);
        }
    }

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                mContext.startActivity(i);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mnewsItems.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        ImageView news_image;
        TextView news_title, news_description, news_meta;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card = itemView.findViewById(R.id.news_card);
            news_image = itemView.findViewById(R.id.news_image);
            news_title = itemView.findViewById(R.id.news_headline);
            news_description = itemView.findViewById(R.id.news_desc);
            news_meta = itemView.findViewById(R.id.news_meta);
        }
    }
}
