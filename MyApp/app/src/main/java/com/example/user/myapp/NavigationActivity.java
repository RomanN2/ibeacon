package com.example.user.myapp;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.user.myapp.Fragments.DevTeamFragment;
import com.example.user.myapp.Fragments.FragmentImport;
import com.example.user.myapp.Fragments.FragmentSend;
import com.example.user.myapp.Fragments.FragmentShare;
import com.example.user.myapp.Fragments.FragmentSlideshow;
import com.example.user.myapp.Fragments.FragmentTools;
import com.example.user.myapp.Fragments.GalleryFragment;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentImport mFragmentImport;
    GalleryFragment mGalleryFragment;
    FragmentSend mFragmentSend;
    FragmentShare mFragmentShare;
    FragmentTools mFragmentTools;
    DevTeamFragment mDevTeamFragment;
    FragmentSlideshow mFragmentSlideshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "G M A I L", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vladbobrovskiy/?hl=ru"));
                startActivity(intent);

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mGalleryFragment = new GalleryFragment();
        mFragmentImport = new FragmentImport();
        mFragmentSend = new FragmentSend();
        mFragmentShare = new FragmentShare();
        mFragmentSlideshow = new FragmentSlideshow();
        mFragmentTools = new FragmentTools();
        mDevTeamFragment = new DevTeamFragment();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if (id == R.id.nav_camera) {
            fragmentTransaction.replace(R.id.container, mFragmentImport);
        } else if (id == R.id.nav_gallery) {
            fragmentTransaction.replace(R.id.container, mGalleryFragment);
        } else if (id == R.id.nav_slideshow) {
            fragmentTransaction.replace(R.id.container, mFragmentSlideshow);
        } else if (id == R.id.nav_manage) {
            fragmentTransaction.replace(R.id.container, mFragmentTools);
        } else if (id == R.id.nav_about_us) {
            fragmentTransaction.replace(R.id.container, mDevTeamFragment);
        } else if (id == R.id.nav_share) {
            fragmentTransaction.replace(R.id.container, mFragmentShare);
        } else if (id == R.id.nav_send) {
            fragmentTransaction.replace(R.id.container, mFragmentSend);
        }
        fragmentTransaction.commit();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
