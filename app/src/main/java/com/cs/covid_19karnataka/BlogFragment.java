package com.cs.covid_19karnataka;

import android.content.Context;
import android.graphics.Color;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class BlogFragment extends Fragment
{
    CardView blog_offline_card;
    TextView blog_retry, death_text, recovery_text, death_percen, rec_percen;
    private RequestQueue requestQueue;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_blog, container, false);

        blog_offline_card = v.findViewById(R.id.blog_offline_card);
        blog_retry = v.findViewById(R.id.blog_retry);
        death_percen = v.findViewById(R.id.death_percen);
        rec_percen = v.findViewById(R.id.recovery_percen);
        death_text = v.findViewById(R.id.death_text);
        recovery_text = v.findViewById(R.id.recovery_text);

        requestQueue = Volley.newRequestQueue(getContext());
        blog_offline_card.setVisibility(View.GONE);
        checkconnection();


        return  v;
    }

    private void checkconnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED)
        {
            blog_offline_card.setVisibility(View.GONE);
            todaysdata();

        }
        else
        {
            blog_offline_card.setVisibility(View.VISIBLE);
        }
    }

    private void todaysdata()
    {
        String url = "https://api.covid19india.org/v4/data.json";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject ka = response.getJSONObject("KA").getJSONObject("total");
                            String confirmed  = ka.getString("confirmed");
                            String disch  = ka.getString("recovered");
                            String death = ka.getString("deceased");


                            float confirmed_int = Float.parseFloat(confirmed);
                            float disch_int = Float.parseFloat(disch);
                            float death_int = Float.parseFloat(death);


                            float death_percentage = (death_int/confirmed_int)*100;
                            death_text.setText(""+death+" people have deceased out of total "+confirmed+" infected in Karnataka");
                            death_percen.setText(""+String.format("%.2f", death_percentage)+"%");

                            float discharge_percentahe = (disch_int/confirmed_int)*100;
                            rec_percen.setText(""+String.format("%.2f", discharge_percentahe)+"%");
                            recovery_text.setText(""+disch+" people have recovered out of total "+confirmed+" infected in Karnataka");




                        } catch (JSONException e) {
                            Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), ""+ error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }

}
