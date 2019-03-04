package com.othman.markit.firstscreens;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.othman.markit.R;

public class FirstActivity extends AppCompatActivity {
private FloatingActionButton floatingActionButton;
private TextView textView;
private ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textView=(TextView)findViewById(R.id.textView);
        imageView2=(ImageView)findViewById(R.id.imageView2);
       floatingActionButton=(FloatingActionButton) findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogActivity = new Intent(FirstActivity.this,SignUpActivity.class);
        startActivity(toLogActivity);
        }
        });

        }
        }
