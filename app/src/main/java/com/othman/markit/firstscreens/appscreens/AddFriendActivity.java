package com.othman.markit.firstscreens.appscreens;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

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
import java.util.Iterator;

public class AddFriendActivity extends AppCompatActivity {
    private EditText searchEd;
    private Button btnSearch;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;
    ListView listView;
    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
        searchEd=(EditText)findViewById(R.id.serchED);
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        listView=(ListView)findViewById(R.id.FriendsList);
        btnSearch=(Button)findViewById(R.id.search);
        listView.setAdapter(arrayAdapter);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inforetievte();
            }
        });


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String friendName=(String)listView.getItemAtPosition(position);
                HashMap <String,String>hashMap=new HashMap<>();
                hashMap.put("Friend's name",friendName);
              databaseReference.child("Users:").child(auth.getCurrentUser().getUid()).child("Friends").child(friendName).setValue(hashMap);
            }
        });


    }



    public void inforetievte(){
        String searchPlain=searchEd.getText().toString();
        searchMethod(searchPlain);
    }



    public void searchMethod(final String searchPlain){
        databaseReference.child("Users:").orderByChild("First name").equalTo(searchPlain).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    arrayAdapter.clear();
                   for(DataSnapshot d:dataSnapshot.getChildren()){
                       //String searchName=dataSnapshot.child("Users:").child("First name").getValue().toString();
//                       if (searchPlain.contains(searchxName)){
//                           arrayAdapter.add(searchName);
//                       }
                       String value=d.child("First name").getValue().toString();
                       String lastName=d.child("Last name").getValue().toString();
//                       String value = d.getValue(String.class);
                       arrayAdapter.add(value +" "+ lastName);
                   }

                   arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
