package com.othman.markit.firstscreens.groupActivity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.ItemsActivity;

public class TheItemGroupActivity extends AppCompatActivity {
    FirebaseAuth auth;
    DatabaseReference databaseReference;
    private ListView listOfItems;
    private ArrayAdapter arrayAdapter;
    private FloatingActionButton addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_item_group);
        final String groupname=getIntent().getExtras().getString("t");
        arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1);
        listOfItems=(ListView)findViewById(R.id.listOfItems);
        addBtn=(FloatingActionButton)findViewById(R.id.addBtn);
        listOfItems.setAdapter(arrayAdapter);
        auth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Groups");
        Window window=getWindow();
        window.setTitle(groupname);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TheItemGroupActivity.this, ItemsActivity.class);
                i.putExtra("groupName",groupname);
                startActivity(i);
            }
        });

        databaseReference.child(groupname).child("Items").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arrayAdapter.clear();
                for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    arrayAdapter.add(dataSnapshot1.getValue()+" "+dataSnapshot1.getKey());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
