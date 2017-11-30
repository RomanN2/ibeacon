package com.example.admin.menuapp2version30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SaveActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        Button buttonmain;
        buttonmain = (Button) findViewById(R.id.buttonmain);
        buttonmain.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonmain:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);


    }
}
        }
