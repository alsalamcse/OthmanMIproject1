package com.othman.markit.firstscreens.appscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.othman.markit.R;

public class MainActivity extends AppCompatActivity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuformainactivity,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.addFriendMenu:
                Intent toAddFriendActivity=new Intent(MainActivity.this,AddFriendActivity.class);
                startActivity(toAddFriendActivity);
                return true;
            case R.id.createGroup:
                Intent toGroupNameActivity=new Intent(MainActivity.this,GroupNameActivity.class);
                startActivity(toGroupNameActivity);
                return true;





        }
return true;
    }
}
