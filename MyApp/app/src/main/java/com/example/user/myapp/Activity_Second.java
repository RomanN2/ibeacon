package com.example.user.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import javax.net.ssl.HttpsURLConnection;

public class Activity_Second extends AppCompatActivity implements View.OnClickListener {
    Button btnback;
    Button buttonNext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__second);
       // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        btnback = (Button) findViewById(R.id.btnback);
        btnback.setOnClickListener((View.OnClickListener) this);
        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener((View.OnClickListener) this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://plus.google.com/u/0/103603567823430338556"));

                startActivity(intent3);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnback:
                Intent intent = new Intent(this,Th_Activity.class);
                startActivity(intent);
                break;
            case R.id.buttonNext:
                Intent intent1=new Intent(this,MainActivity.class);
                startActivity(intent1);
                break;
                default:
                    break;


        }
    }
}
