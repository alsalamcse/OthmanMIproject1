package com.othman.markit.firstscreens.appscreens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.othman.markit.R;

import java.util.ArrayList;

public class GroupActivity extends AppCompatActivity {
private ListView myGroupMembers;
private ArrayAdapter<String > arrayAdapter;
private ArrayList<String>arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        myGroupMembers=(ListView)findViewById(R.id.GroupItemsList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem createGroup=menu.add("create a group");


        return true;
    }
}
