package com.example.user.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Th_Activity extends AppCompatActivity implements View.OnClickListener {
    Button backToMain;
    Button buttonCall;
    Button buttonMaps;
    Button buttonWeb;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_th_);
        Button backToMain;
        backToMain = (Button) findViewById(R.id.backToMain);
        backToMain.setOnClickListener((View.OnClickListener) this);
        buttonCall = (Button) findViewById(R.id.buttonCall);
        buttonWeb = (Button) findViewById(R.id.buttonWeb);
        buttonMaps = (Button) findViewById(R.id.buttonMaps);
        buttonMaps.setOnClickListener(this);
        buttonWeb.setOnClickListener(this);
        buttonCall.setOnClickListener(this);
        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.backToMain:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/vladbobrovskiy/?hl=ru"));
                startActivity(intent);
                break;
            case R.id.buttonMaps:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:49.85805889,24.02611256"));
                startActivity(intent);
                break;
            case R.id.buttonCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0501833403"));
                startActivity(intent);
                break;
            case R.id.button4:
                Intent intent1 = new Intent(this, NavigationActivity.class);
                startActivity(intent1);
                break;


        }
    }
}
