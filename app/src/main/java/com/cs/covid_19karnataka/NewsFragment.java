package com.cs.covid_19karnataka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.cs.covid_19karnataka.adapter.NewsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private NewsAdapter mnewsAdapter;
    private ArrayList<NewsItem> mNewsItem;
    private RequestQueue mRequestQueue;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        mRecyclerView = v.findViewById(R.id.recycler_view_news);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mNewsItem = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(getContext());

        loadnews();

        return  v;
    }

    private void loadnews() {
        String URL_DATA = "https://gnews.io/api/v3/search?q=covid&token=94f78c38851bce8d40b70d0ac7951f91&country=in";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL_DATA, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray = response.getJSONArray("articles");
                    for (int i = 0; i < jsonArray.length(); i++)
                    {
                        JSONObject article = jsonArray.getJSONObject(i);
                        JSONObject source =  jsonArray.getJSONObject(i).getJSONObject("source");

                        String title = article.getString("title");
                        String description = article.getString("description");
                        String url = article.getString("url");
                        String image = article.getString("image");
                        String publishedAt = article.getString("publishedAt");
                        String name = source.getString("name");
                        mNewsItem.add(new NewsItem(title, description, url ,image, publishedAt, name));
                    }
                    mnewsAdapter = new NewsAdapter(getActivity(), mNewsItem);
                    mRecyclerView.setAdapter(mnewsAdapter);
                    }
                catch (JSONException e) {
                    Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        mRequestQueue.add(request);
    }
}
