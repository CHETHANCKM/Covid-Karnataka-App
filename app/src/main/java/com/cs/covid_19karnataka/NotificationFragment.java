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
import com.cs.covid_19karnataka.adapter.NotificationAdapter;
import com.cs.covid_19karnataka.model.NewsItem;
import com.cs.covid_19karnataka.model.NotificationItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NotificationFragment extends Fragment {
    private RecyclerView nrecyclerView;
    private NotificationAdapter nnotificationAdapter;
    private ArrayList<NotificationItem> nnotificationItem;
    private RequestQueue nrequestQueue;
    CardView offline;
    TextView retry,notification_heading;
    LottieAnimationView lottieAnimationView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_notification, container, false);

        nrecyclerView = v.findViewById(R.id.noti_recyelerview);
        nrecyclerView.setHasFixedSize(true);
        nrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        nnotificationItem = new ArrayList<>();


        nrequestQueue = Volley.newRequestQueue(getContext());

        offline = v.findViewById(R.id.notification_offline_card);
        retry = v.findViewById(R.id.notification_retry);
        lottieAnimationView = v.findViewById(R.id.animation_view);
        offline.setVisibility(View.GONE);
        notification_heading=v.findViewById(R.id.notification_heading);
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
            loadnoti();
            lottieAnimationView.setVisibility(View.GONE);

        }
        else
        {
            offline.setVisibility(View.VISIBLE);
            lottieAnimationView.setVisibility(View.VISIBLE);
        }
    }

    private void loadnoti() {

        String URL_NOTI = "https://api.rootnet.in/covid19-in/notifications";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, URL_NOTI, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try
                        {
                            JSONObject noti_parent = response.getJSONObject("data");
                            JSONArray jsonArray = noti_parent.getJSONArray("notifications");

                            for (int i=1; i<jsonArray.length(); i++)
                            {
                                JSONObject notis = jsonArray.getJSONObject(i);

                                String title = notis.getString("title");
                                String link = notis.getString("link");
                                nnotificationItem.add(new NotificationItem(title, link));
                            }
                            nnotificationAdapter = new NotificationAdapter(getActivity(), nnotificationItem);
                            nrecyclerView.setAdapter(nnotificationAdapter);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        nrequestQueue.add(request);
        notification_heading.setText("Today's Top Headlines");

    }


}
