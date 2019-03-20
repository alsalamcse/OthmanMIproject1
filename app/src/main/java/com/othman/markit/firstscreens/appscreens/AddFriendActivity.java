package com.othman.markit.firstscreens.appscreens;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
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
import java.util.Iterator;

public class AddFriendActivity extends AppCompatActivity {
    private EditText searchEd;
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
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.activity_add_friend);
        listView=(ListView)findViewById(R.id.FriendsList);
        listView.setAdapter(arrayAdapter);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference();


    }


    public void inforetievte(){
        String searchPlain=searchEd.getText().toString();
        searchMethod(searchPlain);
    }
    public void searchMethod(final String searchPlain){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterator iterator=dataSnapshot.getChildren().iterator();

                    while (iterator.hasNext())
                    {
                        if (searchPlain.contains(iterator.toString())){
                     arrayList.add(dataSnapshot.child("Users").toString());

                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

}
