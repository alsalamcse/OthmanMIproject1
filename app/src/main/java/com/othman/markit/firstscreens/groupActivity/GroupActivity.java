package com.othman.markit.firstscreens.groupActivity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.othman.markit.R;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GroupActivity extends AppCompatActivity {
private ListView myGroupMembers;
private ArrayAdapter<String > arrayAdapter;
private ArrayList<String>arrayList;
DatabaseReference groupRef;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        myGroupMembers.setAdapter(arrayAdapter);
        groupRef= FirebaseDatabase.getInstance().getReference().child("Groups");
        myGroupMembers=(ListView)findViewById(R.id.GroupItemsList);
//        Bundle bundle=getIntent().getExtras();
        final String groupName=getIntent().getExtras().getString("v");


        groupRef.child("Users:").child(auth.getCurrentUser().getUid()).child("Friends:").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayAdapter.clear();
                for (DataSnapshot dataSnapshot1221 : dataSnapshot.getChildren()) {

                    String FriendsFirestName = dataSnapshot.getKey();
                    arrayAdapter.add(FriendsFirestName);


                }
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myGroupMembers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String nameinTheList=(String)myGroupMembers.getItemAtPosition(position);
                groupRef.child("Groups").child(groupName).child("Group members").child(nameinTheList).setValue(nameinTheList);

            }
        });
    }

//    public void CreateAGroup(){
//        groupRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//              String user=dataSnapshot.getChildren().iterator().toString();
//                Iterator iterator=dataSnapshot.getChildren().iterator();
//                while (iterator.hasNext()){
//                 arrayList.add(user);
//                    Toast.makeText(GroupActivity.this, "damn", Toast.LENGTH_SHORT).show();
//
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuItem createGroup=menu.add("create a group");
//
//
//        return true;
//    }
}
