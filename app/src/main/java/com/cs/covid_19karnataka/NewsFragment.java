package com.cs.covid_19karnataka;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cs.covid_19karnataka.adapter.NewsAdapter;
import com.cs.covid_19karnataka.model.NewsItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NewsAdapter mnewsAdapter;
    private ArrayList<NewsItem> mNewsItem;
    private RequestQueue mRequestQueue;
    CardView offline;
    TextView retry, news_headline;
    LottieAnimationView lottieAnimationView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        mRecyclerView = v.findViewById(R.id.recycler_view_news);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsItem = new ArrayList<>();

        news_headline = v.findViewById(R.id.news_headline);
        offline = v.findViewById(R.id.news_offline_card);
        retry = v.findViewById(R.id.news_retry);
        offline.setVisibility(View.GONE);

        lottieAnimationView = v.findViewById(R.id.animation_view_news);
        mRequestQueue = Volley.newRequestQueue(getContext());

        checkconnection();

        retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkconnection();
            }
        });





        return  v;
    }

    private void checkconnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            offline.setVisibility(View.GONE);
            loadnews();
            lottieAnimationView.setVisibility(View.GONE);
        }
        else
        {
            offline.setVisibility(View.VISIBLE);
            lottieAnimationView.setVisibility(View.VISIBLE);
        }
    }

    private void loadnews()
    {
        lottieAnimationView.setVisibility(View.VISIBLE);
        String URL_DATA = "https://api.smartable.ai/coronavirus/news/IN?Subscription-Key=299eb6376877452aa123b1105fe21531";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL_DATA, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("news");
                    for (int i=0; i<jsonArray.length(); i++)
                    {
                        JSONObject article = jsonArray.getJSONObject(i);
                        JSONObject provider = article.getJSONObject("provider");

                        String image = null;
                        String check = article.getString("images");
                        if (check.equals("null"))
                        {
                         image = "null";
                        }
                        else
                        {
                            JSONArray image_source = article.getJSONArray("images");
                            JSONObject image_url = image_source.getJSONObject(0);
                            image = image_url.getString("url");
                        }

                        String title = article.getString("title");
                        String description = article.getString("excerpt");
                        String url = article.getString("webUrl");
                        String publishedAt = article.getString("publishedDateTime");
                        String name = provider.getString("name");
                        mNewsItem.add(new NewsItem(title, description, url ,image, publishedAt, name));
                    }
                    mnewsAdapter = new NewsAdapter(getActivity(), mNewsItem);
                    mRecyclerView.setAdapter(mnewsAdapter);
                    }
                catch (JSONException e)
                {
                    Toast.makeText(getContext(), "Error1: "+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                offline.setVisibility(View.VISIBLE);
                Toast.makeText(getContext(), "No strong internet Connection"+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(request);
        news_headline.setText("Today's Top Headlines");
        lottieAnimationView.setVisibility(View.GONE);
    }
}
