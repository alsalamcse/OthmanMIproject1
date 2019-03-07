package com.othman.markit.firstscreens.appscreens;

import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.othman.markit.R;

import java.util.ArrayList;

public class GroupNameActivity extends AppCompatActivity {
private TextView textView;
private ListView membersListView;
private EditText groupName;

ArrayAdapter<String> adapter;
  ArrayList<String> list=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_name);

        membersListView= (ListView) findViewById(R.id.membersListView);
        textView=(TextView)findViewById(R.id.textView);
        groupName=(EditText)findViewById(R.id.editText2);
        adapter=new ArrayAdapter<String>(this,R.layout.activity_group_name,list);

        membersListView.setAdapter(adapter);










    }
}
