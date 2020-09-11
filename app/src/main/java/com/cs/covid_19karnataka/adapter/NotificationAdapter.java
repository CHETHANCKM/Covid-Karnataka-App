package com.cs.covid_19karnataka.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.cs.covid_19karnataka.R;
import com.cs.covid_19karnataka.model.NotificationItem;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private Context nContext;
    private ArrayList<NotificationItem> mnotificationItems;

    public NotificationAdapter (Context context, ArrayList<NotificationItem> notificationItems)
    {
        nContext = context;
        mnotificationItems= notificationItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(nContext).inflate(R.layout.circular_card, parent, false);
        return new NotificationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String news_title = mnotificationItems.get(position).getNoti_title();
        final String notilink = mnotificationItems.get(position).getNoti_link();


        holder.pdf_title.setText(news_title);


        holder.open_pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(notilink));
                nContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mnotificationItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView pdf_title;
        ImageView open_pdf;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pdf_title = itemView.findViewById(R.id.pdf_title);
            open_pdf = itemView.findViewById(R.id.open_pdf);
        }
    }
}
