package com.example.user.myapp;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button button1;
    Button button2;
    Button button3;
    Button btnActTwo;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.MyTxt);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        btnActTwo = (Button) findViewById(R.id.btnActTwo);
        btnActTwo.setOnClickListener(this);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId() )  {
                    case R.id.button1:
                        textView.setText("Button 1 was cliked");
                        Toast toast = Toast.makeText(MainActivity.this, "It's btn 1", Toast.LENGTH_SHORT);
                        toast.show();
                        LinearLayout toastImage = (LinearLayout) toast.getView();
                        ImageView imageView = new ImageView(MainActivity.this);
                        imageView.setImageResource(R.drawable.ic_3d_rotation_black_24dp);
                        toastImage.addView(imageView);
                        toast.show();
                        break;
                    case R.id.button2:
                        textView.setText("Button 2 was cliked");
                        Toast toast1 = Toast.makeText(MainActivity.this,"It's btn 2",Toast.LENGTH_SHORT);
                        toast1.show();
                        break;
                    case R.id.button3:
                        textView.setText("Button 3 was cliked");
                        Toast toast2 = Toast.makeText(MainActivity.this,"It's btn 3",Toast.LENGTH_SHORT);
                        toast2.show();
                        break;
                }

            }
        };

        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);

        CheckBox myCbt = (CheckBox) findViewById(R.id.mycbt);
        myCbt.setChecked(true);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnActTwo:
                //TODO call second activity
                Intent intent = new Intent(this,Activity_Second.class);
                startActivity(intent);
                break;
                default:
                    break;
    }
}
    }
