package com.othman.markit.firstscreens.appscreens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.othman.markit.R;

public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem createGroup=menu.add("create a group");


        return true;
    }
}
