package com.example.user.myapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.myapp.Fragments.FragmentGalery;
import com.example.user.myapp.Fragments.FragmentImport;
import com.example.user.myapp.Fragments.FragmentSend;
import com.example.user.myapp.Fragments.FragmentShare;
import com.example.user.myapp.Fragments.FragmentSlideshow;
import com.example.user.myapp.Fragments.FragmentTools;

public class Navigation_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentImport fimport;
    FragmentGalery fgalery;
    FragmentSend fsend;
    FragmentShare fshare;
    FragmentTools ftools;
    FragmentSlideshow fslideshow;


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
        fgalery = new FragmentGalery();
        fimport = new FragmentImport();
        fsend = new FragmentSend();
        fshare = new FragmentShare();
        fslideshow = new FragmentSlideshow();
        ftools = new FragmentTools();
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentTransaction ftrans = getFragmentManager().beginTransaction();

        if (id == R.id.nav_camera) {
            ftrans.replace(R.id.container,fimport);
        } else if (id == R.id.nav_gallery) {
            ftrans.replace(R.id.container,fgalery);
        } else if (id == R.id.nav_slideshow) {
            ftrans.replace(R.id.container,fslideshow);

        } else if (id == R.id.nav_manage) {
            ftrans.replace(R.id.container,ftools);

        } else if (id == R.id.nav_share) {
            ftrans.replace(R.id.container,fshare);

        } else if (id == R.id.nav_send) {
            ftrans.replace(R.id.container, fsend);


        } ftrans.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
