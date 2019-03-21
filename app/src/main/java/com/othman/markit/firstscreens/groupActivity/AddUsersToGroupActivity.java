package com.othman.markit.firstscreens.groupActivity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.AddFriendActivity;
import com.othman.markit.firstscreens.groupAndItemsClasses.User;

import java.util.ArrayList;
import java.util.Stack;

public class AddUsersToGroupActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private ArrayList arrayList;
    FirebaseAuth auth;
    FirebaseUser user;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_users_to_group);
        listView=(ListView)findViewById(R.id.UsersListView);
        arrayAdapter=new ArrayAdapter(AddUsersToGroupActivity.this,R.layout.activity_add_users_to_group);


    }

    public void enterDataToList(){
        databaseReference.child("Users:").child("First name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayAdapter.clear();
                for (DataSnapshot d: dataSnapshot.getChildren()){
                    String addItem=dataSnapshot.child("Users:").child("First name").getValue().toString();
                    arrayAdapter.add(addItem);




                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
