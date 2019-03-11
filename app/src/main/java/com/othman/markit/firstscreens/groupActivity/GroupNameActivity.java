package com.othman.markit.firstscreens.groupActivity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.othman.markit.R;
import com.othman.markit.firstscreens.groupAndItemsClasses.User;

import java.util.ArrayList;

public class GroupNameActivity extends AppCompatActivity {
private TextView textView;
private ListView membersListView;
private EditText groupName;
private User GroupMember;
DatabaseReference groupData;
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
        groupData=FirebaseDatabase.getInstance().getReference();
        membersListView.setAdapter(adapter);


    }
    public void GroupInfo()
    {
        String GroupName=groupName.getText().toString();
        CreateGroup(GroupName);

    }


    private void CreateGroup(String groupName)
    {
        groupData.child("Groups").child(groupName).setValue("").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(GroupNameActivity.this, "The group created successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
