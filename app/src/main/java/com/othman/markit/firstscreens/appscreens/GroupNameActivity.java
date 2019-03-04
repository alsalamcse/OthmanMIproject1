package com.othman.markit.firstscreens.appscreens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import com.othman.markit.R;

public class GroupNameActivity extends AppCompatActivity {
    private ListView listView;
    private Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_name);



    }
}
