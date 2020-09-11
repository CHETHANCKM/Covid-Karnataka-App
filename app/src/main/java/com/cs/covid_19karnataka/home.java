package com.cs.covid_19karnataka;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.options_menu);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.getDrawerArrowDrawable().setColor(getColor(R.color.black));
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashboardFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_dashboard);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        for(int i = 0; i < menu.size(); i++){
            Drawable drawable = menu.getItem(i).getIcon();
            if(drawable != null) {
                drawable.mutate();
                drawable.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
            }
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if (id==R.id.toolbar_icon)
        {
            share();
        }
        return  true;

    }

    private void share() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Covid-19 Karnataka");
        String shareMessage= "I recommend you to use Covid-19 Karnataka App to know the extent of the coronavirus outbreak. Please download and share it using the link.\nAndoid: ";
        shareMessage = shareMessage + "https://example.com/" +"\n";
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
        startActivity(Intent.createChooser(shareIntent, "Refer to your friend"));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_dashboard:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DashboardFragment()).commit();
                break;
            case R.id.nav_blog:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BlogFragment()).commit();
                break;
            case R.id.nav_news:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NewsFragment()).commit();
                break;
            case R.id.nav_privacy:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PrivacyFragment()).commit();
                break;

            case R.id.nav_circulars:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new NotificationFragment()).commit();
                break;


        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}