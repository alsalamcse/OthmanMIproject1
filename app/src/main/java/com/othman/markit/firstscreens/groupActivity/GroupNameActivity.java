package com.othman.markit.firstscreens.groupActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class GroupNameActivity extends AppCompatActivity {
    private TextView textView;
    private ListView membersListView;
    private EditText groupName;
    private User GroupMember;

    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference groupData;
    ArrayAdapter<String> adapter1122;
    ArrayList<String> list = new ArrayList<String>();
    private Button CreateBTN,chooser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_name);

        textView = (TextView) findViewById(R.id.textView);
        groupName = (EditText) findViewById(R.id.editText2);
        adapter1122 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1);
        groupData = FirebaseDatabase.getInstance().getReference();
        auth = FirebaseAuth.getInstance();

        CreateBTN = (Button) findViewById(R.id.CreateBTN);



//chooser.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        addToListMethod();
//    }
//});
CreateBTN.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (groupName.getText().toString() == null) {
            groupName.setError("enter the name");
            Toast.makeText(GroupNameActivity.this, "enter group name please", Toast.LENGTH_SHORT).show();

        } else {
            String group = groupName.getText().toString();
            groupData.child("Groups").child(groupName.getText().toString()).setValue(groupName.getText().toString());

            Intent ToGroupAct=new Intent(GroupNameActivity.this,GroupActivity.class);
            String groupName1=groupName.getText().toString();
            ToGroupAct.putExtra(groupName1,0);

        }
    }
});


//        imgbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(GroupNameActivity.this, AddUsersToGroupActivity.class);
//                startActivity(i);
//            }
//        });
//        membersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String groupId=auth.getCurrentUser().getUid();
//                String nameInTheList=(String) membersListView.getItemAtPosition(position);
//                HashMap<String,String> hashMap=new HashMap();
//                hashMap.put("Friend first name and last name",nameInTheList);
//                groupData.child("Groups").child(groupName.getText().toString()).child("Friends").child(nameInTheList).setValue(hashMap);
//
//            }
//        });

    }

    public void GroupInfo() {
        String GroupName = groupName.getText().toString();
//        getDataUsers();
        CreateGroup(GroupName);

    }


    private void CreateGroup(String groupName) {
        groupData.child("Groups").child(groupName).child("group members").setValue(groupName).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {


                    Toast.makeText(GroupNameActivity.this, "The group created successfully", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

//    public void addToListMethod() {
//        String currentid=auth.getCurrentUser().getUid();


//        groupData.child("Users:").child(auth.getCurrentUser().getUid()).child("Friends:").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    adapter1122.clear();
//                    for (DataSnapshot dataSnapshot1221 : dataSnapshot.getChildren()) {
//
//                        String FriendsFirestName = dataSnapshot1221.getKey();
//                        adapter1122.add(FriendsFirestName);
//
//
//                }
//
//
//                adapter1122.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//
//            });


//    }


//            public void getDataUsers()
//            {
//
//        groupData.child("Groups").child(groupName.getText().toString()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if ((dataSnapshot.exists())&&(dataSnapshot.hasChild("Users:"))){
//                    Set<String> users=new HashSet<>();
//                 for (DataSnapshot d:dataSnapshot.getChildren()) {
//
//                      users.add(d.getValue().toString());
//                    }
//                    list.clear();
//                    list.addAll(users);
//                    adapter.notifyDataSetChanged();
//
//                    }
//
//                }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
}







