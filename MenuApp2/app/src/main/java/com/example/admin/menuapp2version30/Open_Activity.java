package com.example.admin.menuapp2version30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Open_Activity extends AppCompatActivity implements View.OnClickListener {
    Button btnmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_);
        btnmain = (Button) findViewById(R.id.btnmain);
        btnmain.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnmain:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);

        }
    }
}
