package com.othman.markit.firstscreens.groupActivity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.othman.markit.R;
import com.othman.markit.firstscreens.groupAndItemsClasses.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class GroupNameActivity extends AppCompatActivity {
private TextView textView;
private ListView membersListView;
private EditText groupName;
private User GroupMember;
FirebaseAuth auth;
FirebaseUser user;
DatabaseReference groupData;
ArrayAdapter<String> adapter;
  ArrayList<String> list=new ArrayList<String>();
  private Button CreateBTN;


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
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        CreateBTN=(Button)findViewById(R.id.CreateBTN);
        CreateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupInfo();

            }
        });


    }

    public void GroupInfo()
    {
        String GroupName=groupName.getText().toString();
        getDataUsers();
        CreateGroup(GroupName);

    }


    private void CreateGroup(String groupName)
    {
        groupData.child("Groups").child(groupName).setValue("").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                Toast.makeText(GroupNameActivity.this, "The group created successfully", Toast.LENGTH_SHORT).show();

            }
            }
        });
    }



            public void getDataUsers(){
        String firstName;
        groupData.child("Users").child(auth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if ((dataSnapshot.exists())&&(dataSnapshot.hasChild("Users:"))){

                    String iterator=dataSnapshot.child("Users:").getValue().toString();
                    list.add(iterator);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



}

}
