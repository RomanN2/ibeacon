package com.example.kempi.bluetoothlowenergy;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    MediaPlayer mySong;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySong=MediaPlayer.create(MainActivity.this,R.raw.acdc);

    }


    public void playIT(View v){
        mySong.start();
    }
    public void pauseIT(View v){
        mySong.pause();
    }



    @Override
    protected void onPause(){
        super.onPause();
        mySong.release();

    }
}
