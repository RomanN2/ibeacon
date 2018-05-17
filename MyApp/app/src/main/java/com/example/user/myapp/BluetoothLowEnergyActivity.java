package com.example.user.myapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class BluetoothLowEnergyActivity extends AppCompatActivity {
    private static final String IS_PLAYED_BEFORE_KEY  = "isPlayedBefore";
    private static final String DURATION_LENGTH_KEY  = "durationLength";

    private MediaPlayer mMediaPlayer;
    private boolean isPlayedBefore;
    private int mDurationLength;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth_low_energy_activity);
        initViews();
    }

    private void initViews() {
        mMediaPlayer = MediaPlayer.create(this, R.raw.acdc_song);
        ImageButton pauseSoundButton = findViewById(R.id.mPauseSoundButton);
        ImageButton playSoundButton = findViewById(R.id.mPlaySoundButton);
        pauseSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pauseSound();
            }
        });

        playSoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        handlePlayerOnPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isPlayedBefore) {
            playSound();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (isPlayedBefore) {
            playSound();
        }
    }

    public void playSound() {
        mMediaPlayer.seekTo(mDurationLength);
        mMediaPlayer.start();
    }

    public void pauseSound() {
        mMediaPlayer.pause();
        mDurationLength = mMediaPlayer.getCurrentPosition();
    }

    private void handlePlayerOnPause() {
        isPlayedBefore = mMediaPlayer.isPlaying();
        if (mMediaPlayer.isPlaying()) {
            pauseSound();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_PLAYED_BEFORE_KEY, isPlayedBefore);
        outState.putInt(DURATION_LENGTH_KEY, mMediaPlayer.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        isPlayedBefore = savedInstanceState.getBoolean(IS_PLAYED_BEFORE_KEY);
        mDurationLength = savedInstanceState.getInt(DURATION_LENGTH_KEY);
    }
}

