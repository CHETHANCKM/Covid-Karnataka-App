package com.cs.covid_19karnataka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class DashboardFragment extends Fragment {
    TextView t_confirmed, t_active, t_recovered, t_deceased, meta,
            a1, a2, a3, a4,
            b1, b2, b3, b4,
            c1, c2, c3, c4,
            d1, d2, d3, d4,
            e1, e2, e3, e4,
            f1, f2, f3, f4,
            g1, g2, g3, g4,
            h1, h2, h3, h4,
            i1, i2, i3, i4,
            j1, j2, j3, j4,
            k1, k2, k3, k4,
            l1, l2, l3, l4,
            m1, m2, m3, m4,
            n1, n2, n3, n4,
            o1, o2, o3, o4,
            p1, p2, p3, p4,
            q1, q2, q3, q4,
            r1, r2, r3, r4,
            s1, s2, s3, s4,
            t1, t2, t3, t4,
            u1, u2, u3, u4,
            v1, v2, v3, v4,
            w1, w2, w3, w4,
            x1, x2, x3, x4,
            y1, y2, y3, y4,
            z1, z2, z3, z4,
            aa1, aa2, aa3, aa4,
            ab1, ab2, ab3, ab4,
            ac1, ac2, ac3, ac4,
            ad1, ad2, ad3, ad4,
            ae1, ae2, ae3, ae4;

    private RequestQueue requestQueue;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        t_confirmed = v.findViewById(R.id.t_confirmed);
        t_active = v.findViewById(R.id.t_active);
        meta = v.findViewById(R.id.meta);
        t_deceased = v.findViewById(R.id.t_death);
        t_recovered = v.findViewById(R.id.t_recovered);

        a1 = v.findViewById(R.id.a1);
        a2 = v.findViewById(R.id.a2);
        a3 = v.findViewById(R.id.a3);
        a4 = v.findViewById(R.id.a4);

        b1 = v.findViewById(R.id.b1);
        b2 = v.findViewById(R.id.b2);
        b3 = v.findViewById(R.id.b3);
        b4 = v.findViewById(R.id.b4);

        c1 = v.findViewById(R.id.c1);
        c2 = v.findViewById(R.id.c2);
        c3 = v.findViewById(R.id.c3);
        c4 = v.findViewById(R.id.c4);

        d1 = v.findViewById(R.id.d1);
        d2 = v.findViewById(R.id.d2);
        d3 = v.findViewById(R.id.d3);
        d4 = v.findViewById(R.id.d4);

        e1 = v.findViewById(R.id.e1);
        e2 = v.findViewById(R.id.e2);
        e3 = v.findViewById(R.id.e3);
        e4 = v.findViewById(R.id.e4);

        f1 = v.findViewById(R.id.f1);
        f2 = v.findViewById(R.id.f2);
        f3 = v.findViewById(R.id.f3);
        f4 = v.findViewById(R.id.f4);

        g1 = v.findViewById(R.id.g1);
        g2 = v.findViewById(R.id.g2);
        g3 = v.findViewById(R.id.g3);
        g4 = v.findViewById(R.id.g4);

        h1 = v.findViewById(R.id.h1);
        h2 = v.findViewById(R.id.h2);
        h3 = v.findViewById(R.id.h3);
        h4 = v.findViewById(R.id.h4);

        i1 = v.findViewById(R.id.i1);
        i2 = v.findViewById(R.id.i2);
        i3 = v.findViewById(R.id.i3);
        i4 = v.findViewById(R.id.i4);

        j1 = v.findViewById(R.id.j1);
        j2 = v.findViewById(R.id.j2);
        j3 = v.findViewById(R.id.j3);
        j4 = v.findViewById(R.id.j4);

        k1 = v.findViewById(R.id.k1);
        k2 = v.findViewById(R.id.k2);
        k3 = v.findViewById(R.id.k3);
        k4 = v.findViewById(R.id.k4);


        l1 = v.findViewById(R.id.l1);
        l2 = v.findViewById(R.id.l2);
        l3 = v.findViewById(R.id.l3);
        l4 = v.findViewById(R.id.l4);

        m1 = v.findViewById(R.id.m1);
        m2 = v.findViewById(R.id.m2);
        m3 = v.findViewById(R.id.m3);
        m4 = v.findViewById(R.id.m4);

        n1 = v.findViewById(R.id.n1);
        n2 = v.findViewById(R.id.n2);
        n3 = v.findViewById(R.id.n3);
        n4 = v.findViewById(R.id.n4);

        o1 = v.findViewById(R.id.o1);
        o2 = v.findViewById(R.id.o2);
        o3 = v.findViewById(R.id.o3);
        o4 = v.findViewById(R.id.o4);

        p1 = v.findViewById(R.id.p1);
        p2 = v.findViewById(R.id.p2);
        p3 = v.findViewById(R.id.p3);
        p4 = v.findViewById(R.id.p4);

        q1 = v.findViewById(R.id.q1);
        q2 = v.findViewById(R.id.q2);
        q3 = v.findViewById(R.id.q3);
        q4 = v.findViewById(R.id.q4);

        r1 = v.findViewById(R.id.r1);
        r2 = v.findViewById(R.id.r2);
        r3 = v.findViewById(R.id.r3);
        r4 = v.findViewById(R.id.r4);

        s1 = v.findViewById(R.id.s1);
        s2 = v.findViewById(R.id.s2);
        s3 = v.findViewById(R.id.s3);
        s4 = v.findViewById(R.id.s4);

        t1 = v.findViewById(R.id.t1);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t4 = v.findViewById(R.id.t4);

        u1 = v.findViewById(R.id.u1);
        u2 = v.findViewById(R.id.u2);
        u3 = v.findViewById(R.id.u3);
        u4 = v.findViewById(R.id.u4);


        v1 = v.findViewById(R.id.v1);
        v2 = v.findViewById(R.id.v2);
        v3 = v.findViewById(R.id.v3);
        v4 = v.findViewById(R.id.v4);

        w1 = v.findViewById(R.id.w1);
        w2 = v.findViewById(R.id.w2);
        w3 = v.findViewById(R.id.w3);
        w4 = v.findViewById(R.id.w4);

        x1 = v.findViewById(R.id.x1);
        x2 = v.findViewById(R.id.x2);
        x3 = v.findViewById(R.id.x3);
        x4 = v.findViewById(R.id.x4);

        y1 = v.findViewById(R.id.y1);
        y2 = v.findViewById(R.id.y2);
        y3 = v.findViewById(R.id.y3);
        y4 = v.findViewById(R.id.y4);

        z1 = v.findViewById(R.id.z1);
        z2 = v.findViewById(R.id.z2);
        z3 = v.findViewById(R.id.z3);
        z4 = v.findViewById(R.id.z4);

        aa1 = v.findViewById(R.id.aa1);
        aa2 = v.findViewById(R.id.aa2);
        aa3 = v.findViewById(R.id.aa3);
        aa4 = v.findViewById(R.id.aa4);

        ab1 = v.findViewById(R.id.ab1);
        ab2 = v.findViewById(R.id.ab2);
        ab3 = v.findViewById(R.id.ab3);
        ab4 = v.findViewById(R.id.ab4);

        ac1 = v.findViewById(R.id.ac1);
        ac2 = v.findViewById(R.id.ac2);
        ac3 = v.findViewById(R.id.ac3);
        ac4 = v.findViewById(R.id.ac4);

        ad1 = v.findViewById(R.id.ad1);
        ad2 = v.findViewById(R.id.ad2);
        ad3 = v.findViewById(R.id.ad3);
        ad4 = v.findViewById(R.id.ad4);

        ae1 = v.findViewById(R.id.ae1);
        ae2 = v.findViewById(R.id.ae2);
        ae3 = v.findViewById(R.id.ae3);
        ae4 = v.findViewById(R.id.ae4);

        requestQueue = Volley.newRequestQueue(getContext());

        totaldata();


        return v;
    }

    private void totaldata() {
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
                            String other = ka.getString("other");

                            int confirmed_int = Integer.parseInt(confirmed);
                            int disch_int = Integer.parseInt(disch);
                            int death_int = Integer.parseInt(death);
                            int other_int = Integer.parseInt(other);

                            String active = String.valueOf(confirmed_int-disch_int-death_int-other_int);
                            JSONObject state_data = response.getJSONObject("KA").getJSONObject("districts");

                            JSONObject date = response.getJSONObject("KA").getJSONObject("meta");
                            String last_updated = date.getString("last_updated");



                            meta.setText(last_updated);

                            JSONObject a1_state = state_data.getJSONObject("Bagalkote").getJSONObject("total");
                            String a1_confirmed = a1_state.getString("confirmed");
                            a1.setText(a1_confirmed);
                            int a1_confirmed_int = Integer.parseInt(a1_confirmed);
                            String a1_recovred = a1_state.getString("recovered");
                            a3.setText(a1_recovred);
                            int a1_recovred_int = Integer.parseInt(a1_recovred);
                            String a1_deceased = a1_state.getString("deceased");
                            a4.setText(a1_deceased);
                            int a1_deceased_int = Integer.parseInt(a1_deceased);
                            String a1_active = String.valueOf(a1_confirmed_int-a1_recovred_int-a1_deceased_int);
                            a2.setText(a1_active);

                            JSONObject b1_state = state_data.getJSONObject("Ballari").getJSONObject("total");

                            String b1_confirmed = b1_state.getString("confirmed");
                            b1.setText(b1_confirmed);
                            int b1_confirmed_int = Integer.parseInt(b1_confirmed);

                            String b1_recovred = b1_state.getString("recovered");
                            b3.setText(b1_recovred);
                            int b1_recovred_int = Integer.parseInt(b1_recovred);

                            String b1_deceased = b1_state.getString("deceased");
                            b4.setText(b1_deceased);
                            int b1_deceased_int = Integer.parseInt(b1_deceased);

                            String b1_active = String.valueOf(b1_confirmed_int-b1_recovred_int-b1_deceased_int);
                            b2.setText(b1_active);


                            JSONObject c1_state = state_data.getJSONObject("Belagavi").getJSONObject("total");
                            String c1_confirmed = c1_state.getString("confirmed");
                            c1.setText(c1_confirmed);
                            int c1_confirmed_int = Integer.parseInt(c1_confirmed);
                            String c1_recovred = c1_state.getString("recovered");
                            c3.setText(c1_recovred);
                            int c1_recovred_int = Integer.parseInt(c1_recovred);
                            String c1_deceased = c1_state.getString("deceased");
                            c4.setText(c1_deceased);
                            int c1_deceased_int = Integer.parseInt(c1_deceased);
                            String c1_active = String.valueOf(c1_confirmed_int-c1_recovred_int-c1_deceased_int);
                            c2.setText(c1_active);


                            JSONObject d1_state = state_data.getJSONObject("Bengaluru Rural").getJSONObject("total");
                            String d1_confirmed = d1_state.getString("confirmed");
                            d1.setText(d1_confirmed);
                            int d1_confirmed_int = Integer.parseInt(d1_confirmed);
                            String d1_recovred = d1_state.getString("recovered");
                            d3.setText(d1_recovred);
                            int d1_recovred_int = Integer.parseInt(d1_recovred);
                            String d1_deceased = d1_state.getString("deceased");
                            d4.setText(d1_deceased);
                            int d1_deceased_int = Integer.parseInt(d1_deceased);
                            String d1_active = String.valueOf(d1_confirmed_int-d1_recovred_int-d1_deceased_int);
                            d2.setText(d1_active);

                            JSONObject e1_state = state_data.getJSONObject("Bengaluru Urban").getJSONObject("total");
                            String e1_confirmed = e1_state.getString("confirmed");
                            e1.setText(e1_confirmed);
                            int e1_confirmed_int = Integer.parseInt(e1_confirmed);
                            String e1_recovred = e1_state.getString("recovered");
                            e3.setText(e1_recovred);
                            int e1_recovred_int = Integer.parseInt(e1_recovred);
                            String e1_deceased = e1_state.getString("deceased");
                            e4.setText(e1_deceased);
                            int e1_deceased_int = Integer.parseInt(e1_deceased);
                            String e1_active = String.valueOf(e1_confirmed_int-e1_recovred_int-e1_deceased_int);
                            e2.setText(e1_active);



                            JSONObject f1_state = state_data.getJSONObject("Bidar").getJSONObject("total");
                            String f1_confirmed = f1_state.getString("confirmed");
                            f1.setText(f1_confirmed);
                            int f1_confirmed_int = Integer.parseInt(f1_confirmed);
                            String f1_recovred = f1_state.getString("recovered");
                            f3.setText(f1_recovred);
                            int f1_recovred_int = Integer.parseInt(f1_recovred);
                            String f1_deceased = f1_state.getString("deceased");
                            f4.setText(f1_deceased);
                            int f1_deceased_int = Integer.parseInt(f1_deceased);
                            String f1_active = String.valueOf(f1_confirmed_int-f1_recovred_int-f1_deceased_int);
                            f2.setText(f1_active);



                            JSONObject g1_state = state_data.getJSONObject("Chamarajanagara").getJSONObject("total");
                            String g1_confirmed = g1_state.getString("confirmed");
                            g1.setText(g1_confirmed);
                            int g1_confirmed_int = Integer.parseInt(g1_confirmed);
                            String g1_recovred = g1_state.getString("recovered");
                            g3.setText(g1_recovred);
                            int g1_recovred_int = Integer.parseInt(g1_recovred);
                            String g1_deceased = g1_state.getString("deceased");
                            g4.setText(g1_deceased);
                            int g1_deceased_int = Integer.parseInt(g1_deceased);
                            String g1_active = String.valueOf(g1_confirmed_int-g1_recovred_int-g1_deceased_int);
                            g2.setText(g1_active);

                            JSONObject h1_state = state_data.getJSONObject("Chikkaballapura").getJSONObject("total");
                            String h1_confirmed = h1_state.getString("confirmed");
                            h1.setText(h1_confirmed);
                            int h1_confirmed_int = Integer.parseInt(h1_confirmed);
                            String h1_recovred = h1_state.getString("recovered");
                            h3.setText(h1_recovred);
                            int h1_recovred_int = Integer.parseInt(h1_recovred);
                            String h1_deceased = h1_state.getString("deceased");
                            h4.setText(h1_deceased);
                            int h1_deceased_int = Integer.parseInt(h1_deceased);
                            String h1_active = String.valueOf(h1_confirmed_int-h1_recovred_int-h1_deceased_int);
                            h2.setText(h1_active);


                            JSONObject i1_state = state_data.getJSONObject("Chikkamagaluru").getJSONObject("total");
                            String i1_confirmed = i1_state.getString("confirmed");
                            i1.setText(i1_confirmed);
                            int i1_confirmed_int = Integer.parseInt(i1_confirmed);
                            String i1_recovred = i1_state.getString("recovered");
                            i3.setText(i1_recovred);
                            int i1_recovred_int = Integer.parseInt(i1_recovred);
                            String i1_deceased = i1_state.getString("deceased");
                            i4.setText(i1_deceased);
                            int i1_deceased_int = Integer.parseInt(i1_deceased);
                            String i1_active = String.valueOf(i1_confirmed_int-i1_recovred_int-i1_deceased_int);
                            i2.setText(i1_active);

                            JSONObject j1_state = state_data.getJSONObject("Chitradurga").getJSONObject("total");
                            String j1_confirmed = j1_state.getString("confirmed");
                            j1.setText(j1_confirmed);
                            int j1_confirmed_int = Integer.parseInt(j1_confirmed);
                            String j1_recovred = j1_state.getString("recovered");
                            j3.setText(j1_recovred);
                            int j1_recovred_int = Integer.parseInt(j1_recovred);
                            String j1_deceased = j1_state.getString("deceased");
                            j4.setText(j1_deceased);
                            int j1_deceased_int = Integer.parseInt(j1_deceased);
                            String j1_active = String.valueOf(j1_confirmed_int-j1_recovred_int-j1_deceased_int);
                            j2.setText(j1_active);


                            JSONObject k1_state = state_data.getJSONObject("Dakshina Kannada").getJSONObject("total");
                            String k1_confirmed = k1_state.getString("confirmed");
                            k1.setText(k1_confirmed);
                            int k1_confirmed_int = Integer.parseInt(k1_confirmed);
                            String k1_recovred = k1_state.getString("recovered");
                            k3.setText(k1_recovred);
                            int k1_recovred_int = Integer.parseInt(k1_recovred);
                            String k1_deceased = k1_state.getString("deceased");
                            k4.setText(k1_deceased);
                            int k1_deceased_int = Integer.parseInt(k1_deceased);
                            String k1_active = String.valueOf(k1_confirmed_int-k1_recovred_int-k1_deceased_int);
                            k2.setText(k1_active);

                            JSONObject l1_state = state_data.getJSONObject("Davanagere").getJSONObject("total");
                            String l1_confirmed = l1_state.getString("confirmed");
                            l1.setText(l1_confirmed);
                            int l1_confirmed_int = Integer.parseInt(l1_confirmed);
                            String l1_recovred = l1_state.getString("recovered");
                            l3.setText(l1_recovred);
                            int l1_recovred_int = Integer.parseInt(l1_recovred);
                            String l1_deceased = l1_state.getString("deceased");
                            l4.setText(l1_deceased);
                            int l1_deceased_int = Integer.parseInt(l1_deceased);
                            String l1_active = String.valueOf(l1_confirmed_int-l1_recovred_int-l1_deceased_int);
                            l2.setText(l1_active);


                            JSONObject m1_state = state_data.getJSONObject("Dharwad").getJSONObject("total");
                            String m1_confirmed = m1_state.getString("confirmed");
                            m1.setText(m1_confirmed);
                            int m1_confirmed_int = Integer.parseInt(m1_confirmed);
                            String m1_recovred = m1_state.getString("recovered");
                            m3.setText(m1_recovred);
                            int m1_recovred_int = Integer.parseInt(m1_recovred);
                            String m1_deceased = m1_state.getString("deceased");
                            m4.setText(m1_deceased);
                            int m1_deceased_int = Integer.parseInt(m1_deceased);
                            String m1_active = String.valueOf(m1_confirmed_int-m1_recovred_int-m1_deceased_int);
                            m2.setText(m1_active);

                            JSONObject n1_state = state_data.getJSONObject("Gadag").getJSONObject("total");
                            String n1_confirmed = n1_state.getString("confirmed");
                            n1.setText(n1_confirmed);
                            int n1_confirmed_int = Integer.parseInt(n1_confirmed);
                            String n1_recovred = n1_state.getString("recovered");
                            n3.setText(n1_recovred);
                            int n1_recovred_int = Integer.parseInt(n1_recovred);
                            String n1_deceased = n1_state.getString("deceased");
                            n4.setText(n1_deceased);
                            int n1_deceased_int = Integer.parseInt(n1_deceased);
                            String n1_active = String.valueOf(n1_confirmed_int-n1_recovred_int-n1_deceased_int);
                            n2.setText(n1_active);


                            JSONObject o1_state = state_data.getJSONObject("Hassan").getJSONObject("total");
                            String o1_confirmed = o1_state.getString("confirmed");
                            o1.setText(o1_confirmed);
                            int o1_confirmed_int = Integer.parseInt(o1_confirmed);
                            String o1_recovred = o1_state.getString("recovered");
                            o3.setText(o1_recovred);
                            int o1_recovred_int = Integer.parseInt(o1_recovred);
                            String o1_deceased = o1_state.getString("deceased");
                            o4.setText(o1_deceased);
                            int o1_deceased_int = Integer.parseInt(o1_deceased);
                            String o1_active = String.valueOf(o1_confirmed_int-o1_recovred_int-o1_deceased_int);
                            o2.setText(o1_active);


                            JSONObject p1_state = state_data.getJSONObject("Haveri").getJSONObject("total");
                            String p1_confirmed = p1_state.getString("confirmed");
                            p1.setText(p1_confirmed);
                            int p1_confirmed_int = Integer.parseInt(p1_confirmed);
                            String p1_recovred = p1_state.getString("recovered");
                            p3.setText(p1_recovred);
                            int p1_recovred_int = Integer.parseInt(p1_recovred);
                            String p1_deceased = p1_state.getString("deceased");
                            p4.setText(p1_deceased);
                            int p1_deceased_int = Integer.parseInt(p1_deceased);
                            String p1_active = String.valueOf(p1_confirmed_int-p1_recovred_int-p1_deceased_int);
                            p2.setText(p1_active);

                            //check from here

                            JSONObject q1_state = state_data.getJSONObject("Kalaburagi").getJSONObject("total");
                            String q1_confirmed = q1_state.getString("confirmed");
                            q1.setText(q1_confirmed);
                            int q1_confirmed_int = Integer.parseInt(q1_confirmed);
                            String q1_recovred = q1_state.getString("recovered");
                            q3.setText(q1_recovred);
                            int q1_recovred_int = Integer.parseInt(q1_recovred);
                            String q1_deceased = q1_state.getString("deceased");
                            q4.setText(q1_deceased);
                            int q1_deceased_int = Integer.parseInt(q1_deceased);
                            String q1_active = String.valueOf(q1_confirmed_int-q1_recovred_int-q1_deceased_int);
                            q2.setText(q1_active);

                            JSONObject r1_state = state_data.getJSONObject("Kodagu").getJSONObject("total");
                            String r1_confirmed = r1_state.getString("confirmed");
                            r1.setText(r1_confirmed);
                            int r1_confirmed_int = Integer.parseInt(r1_confirmed);
                            String r1_recovred = r1_state.getString("recovered");
                            r3.setText(r1_recovred);
                            int r1_recovred_int = Integer.parseInt(r1_recovred);
                            String r1_deceased = r1_state.getString("deceased");
                            r4.setText(r1_deceased);
                            int r1_deceased_int = Integer.parseInt(r1_deceased);
                            String r1_active = String.valueOf(r1_confirmed_int-r1_recovred_int-r1_deceased_int);
                            r2.setText(r1_active);

                            JSONObject s1_state = state_data.getJSONObject("Kolar").getJSONObject("total");
                            String s1_confirmed = s1_state.getString("confirmed");
                            s1.setText(s1_confirmed);
                            int s1_confirmed_int = Integer.parseInt(s1_confirmed);
                            String s1_recovred = s1_state.getString("recovered");
                            s3.setText(s1_recovred);
                            int s1_recovred_int = Integer.parseInt(s1_recovred);
                            String s1_deceased = s1_state.getString("deceased");
                            s4.setText(s1_deceased);
                            int s1_deceased_int = Integer.parseInt(s1_deceased);
                            String s1_active = String.valueOf(s1_confirmed_int-s1_recovred_int-s1_deceased_int);
                            s2.setText(s1_active);

                            JSONObject t1_state = state_data.getJSONObject("Koppal").getJSONObject("total");
                            String t1_confirmed = t1_state.getString("confirmed");
                            t1.setText(t1_confirmed);
                            int t1_confirmed_int = Integer.parseInt(t1_confirmed);
                            String t1_recovred = t1_state.getString("recovered");
                            t3.setText(t1_recovred);
                            int t1_recovred_int = Integer.parseInt(t1_recovred);
                            String t1_deceased = t1_state.getString("deceased");
                            t4.setText(t1_deceased);
                            int t1_deceased_int = Integer.parseInt(t1_deceased);
                            String t1_active = String.valueOf(t1_confirmed_int-t1_recovred_int-t1_deceased_int);
                            t2.setText(t1_active);

                            JSONObject u1_state = state_data.getJSONObject("Mandya").getJSONObject("total");
                            String u1_confirmed = u1_state.getString("confirmed");
                            u1.setText(u1_confirmed);
                            int u1_confirmed_int = Integer.parseInt(u1_confirmed);
                            String u1_recovred = u1_state.getString("recovered");
                            u3.setText(u1_recovred);
                            int u1_recovred_int = Integer.parseInt(u1_recovred);
                            String u1_deceased = u1_state.getString("deceased");
                            u4.setText(u1_deceased);
                            int u1_deceased_int = Integer.parseInt(u1_deceased);
                            String u1_active = String.valueOf(u1_confirmed_int-u1_recovred_int-u1_deceased_int);
                            u2.setText(u1_active);

                            JSONObject v1_state = state_data.getJSONObject("Mysuru").getJSONObject("total");
                            String v1_confirmed = v1_state.getString("confirmed");
                            v1.setText(v1_confirmed);
                            int v1_confirmed_int = Integer.parseInt(v1_confirmed);
                            String v1_recovred = v1_state.getString("recovered");
                            v3.setText(v1_recovred);
                            int v1_recovred_int = Integer.parseInt(v1_recovred);
                            String v1_deceased = v1_state.getString("deceased");
                            v4.setText(v1_deceased);
                            int v1_deceased_int = Integer.parseInt(v1_deceased);
                            String v1_active = String.valueOf(v1_confirmed_int-v1_recovred_int-v1_deceased_int);
                            v2.setText(v1_active);

                            JSONObject w1_state = state_data.getJSONObject("Raichur").getJSONObject("total");
                            String w1_confirmed = w1_state.getString("confirmed");
                            w1.setText(w1_confirmed);
                            int w1_confirmed_int = Integer.parseInt(w1_confirmed);
                            String w1_recovred = w1_state.getString("recovered");
                            w3.setText(w1_recovred);
                            int w1_recovred_int = Integer.parseInt(w1_recovred);
                            String w1_deceased = w1_state.getString("deceased");
                            w4.setText(w1_deceased);
                            int w1_deceased_int = Integer.parseInt(w1_deceased);
                            String w1_active = String.valueOf(w1_confirmed_int-w1_recovred_int-w1_deceased_int);
                            w2.setText(w1_active);

                            JSONObject x1_state = state_data.getJSONObject("Ramanagara").getJSONObject("total");
                            String x1_confirmed = x1_state.getString("confirmed");
                            x1.setText(x1_confirmed);
                            int x1_confirmed_int = Integer.parseInt(x1_confirmed);
                            String x1_recovred = x1_state.getString("recovered");
                            x3.setText(x1_recovred);
                            int x1_recovred_int = Integer.parseInt(x1_recovred);
                            String x1_deceased = x1_state.getString("deceased");
                            x4.setText(x1_deceased);
                            int x1_deceased_int = Integer.parseInt(x1_deceased);
                            String x1_active = String.valueOf(x1_confirmed_int-x1_recovred_int-x1_deceased_int);
                            x2.setText(x1_active);

                            JSONObject y1_state = state_data.getJSONObject("Shivamogga").getJSONObject("total");
                            String y1_confirmed = y1_state.getString("confirmed");
                            y1.setText(y1_confirmed);
                            int y1_confirmed_int = Integer.parseInt(y1_confirmed);
                            String y1_recovred = y1_state.getString("recovered");
                            y3.setText(y1_recovred);
                            int y1_recovred_int = Integer.parseInt(y1_recovred);
                            String y1_deceased = y1_state.getString("deceased");
                            y4.setText(y1_deceased);
                            int y1_deceased_int = Integer.parseInt(y1_deceased);
                            String y1_active = String.valueOf(y1_confirmed_int-y1_recovred_int-y1_deceased_int);
                            y2.setText(y1_active);


                            JSONObject z1_state = state_data.getJSONObject("Tumakuru").getJSONObject("total");
                            String z1_confirmed = z1_state.getString("confirmed");
                            z1.setText(z1_confirmed);
                            int z1_confirmed_int = Integer.parseInt(z1_confirmed);
                            String z1_recovred = z1_state.getString("recovered");
                            z3.setText(z1_recovred);
                            int z1_recovred_int = Integer.parseInt(z1_recovred);
                            String z1_deceased = z1_state.getString("deceased");
                            z4.setText(z1_deceased);
                            int z1_deceased_int = Integer.parseInt(z1_deceased);
                            String z1_active = String.valueOf(z1_confirmed_int-z1_recovred_int-z1_deceased_int);
                            z2.setText(z1_active);

                            JSONObject aa1_state = state_data.getJSONObject("Udupi").getJSONObject("total");
                            String aa1_confirmed = aa1_state.getString("confirmed");
                            aa1.setText(aa1_confirmed);
                            int aa1_confirmed_int = Integer.parseInt(aa1_confirmed);
                            String aa1_recovred = aa1_state.getString("recovered");
                            aa3.setText(aa1_recovred);
                            int aa1_recovred_int = Integer.parseInt(aa1_recovred);
                            String aa1_deceased = aa1_state.getString("deceased");
                            aa4.setText(aa1_deceased);
                            int aa1_deceased_int = Integer.parseInt(aa1_deceased);
                            String aa1_active = String.valueOf(aa1_confirmed_int-aa1_recovred_int-aa1_deceased_int);
                            aa2.setText(aa1_active);



                            JSONObject ab1_state = state_data.getJSONObject("Uttara Kannada").getJSONObject("total");
                            String ab1_confirmed = ab1_state.getString("confirmed");
                            ab1.setText(ab1_confirmed);
                            int ab1_confirmed_int = Integer.parseInt(ab1_confirmed);
                            String ab1_recovred = ab1_state.getString("recovered");
                            ab3.setText(ab1_recovred);
                            int ab1_recovred_int = Integer.parseInt(ab1_recovred);
                            String ab1_deceased = ab1_state.getString("deceased");
                            ab4.setText(ab1_deceased);
                            int ab1_deceased_int = Integer.parseInt(ab1_deceased);
                            String ab1_active = String.valueOf(ab1_confirmed_int-ab1_recovred_int-ab1_deceased_int);
                            ab2.setText(ab1_active);

                            JSONObject ac1_state = state_data.getJSONObject("Vijayapura").getJSONObject("total");
                            String ac1_confirmed = ac1_state.getString("confirmed");
                            ac1.setText(ac1_confirmed);
                            int ac1_confirmed_int = Integer.parseInt(ac1_confirmed);
                            String ac1_recovred = ac1_state.getString("recovered");
                            ac3.setText(ac1_recovred);
                            int ac1_recovred_int = Integer.parseInt(ac1_recovred);
                            String ac1_deceased = ac1_state.getString("deceased");
                            ac4.setText(ac1_deceased);
                            int ac1_deceased_int = Integer.parseInt(ac1_deceased);
                            String ac1_active = String.valueOf(ac1_confirmed_int-ac1_recovred_int-ac1_deceased_int);
                            ac2.setText(ac1_active);

                            JSONObject ad1_state = state_data.getJSONObject("Yadgir").getJSONObject("total");
                            String ad1_confirmed = ad1_state.getString("confirmed");
                            ad1.setText(ad1_confirmed);
                            int ad1_confirmed_int = Integer.parseInt(ad1_confirmed);
                            String ad1_recovred = ad1_state.getString("recovered");
                            ad3.setText(ad1_recovred);
                            int ad1_recovred_int = Integer.parseInt(ad1_recovred);
                            String ad1_deceased = ad1_state.getString("deceased");
                            ad4.setText(ad1_deceased);
                            int ad1_deceased_int = Integer.parseInt(ad1_deceased);
                            String ad1_active = String.valueOf(ad1_confirmed_int-ad1_recovred_int-ad1_deceased_int);
                            ad2.setText(ad1_active);

                            JSONObject ae1_state = state_data.getJSONObject("Other State").getJSONObject("total");
                            String ae1_confirmed = ae1_state.getString("confirmed");
                            ae1.setText(ae1_confirmed);
                            int ae1_confirmed_int = Integer.parseInt(ae1_confirmed);
                            String ae1_recovred = ae1_state.getString("recovered");
                            ae3.setText(ae1_recovred);
                            int ae1_recovred_int = Integer.parseInt(ae1_recovred);
                            String ae1_deceased = ae1_state.getString("deceased");
                            ae4.setText(ae1_deceased);
                            int ae1_deceased_int = Integer.parseInt(ae1_deceased);
                            String ae1_active = String.valueOf(ae1_confirmed_int-ae1_recovred_int-ae1_deceased_int);
                            ae2.setText(ae1_active);

                            t_confirmed.setText(confirmed);
                            t_deceased.setText(death);
                            t_recovered.setText(disch);
                            t_active.setText(active);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), ""+error, Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);
      }


    public static class NotificationFragment {
    }
}
