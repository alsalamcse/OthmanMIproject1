package com.othman.markit.firstscreens.appscreens;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.othman.markit.R;

public class ItemAmount extends AppCompatActivity {
    private FloatingActionButton plus,minus;
    private TextView tv,kind;
    private Button done;
    public static String groupNAme;
    public static int ItemAmount;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_amount);
        tv=(TextView)findViewById(R.id.Amount);
        kind=(TextView)findViewById(R.id.ItemKind);
        plus=(FloatingActionButton)findViewById(R.id.plus);
        minus=(FloatingActionButton)findViewById(R.id.minus);
        done=(Button)findViewById(R.id.done) ;
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        ItemAmount=1;
        tv.setText(ItemAmount);
        groupNAme=getIntent().getExtras().getString("groupName");
        final String Itemname;
        getWindow().setLayout((int)(width*.8),(int)(height*.4));
        Itemname=getIntent().getExtras().getString("x");
        kind.setText(Itemname);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(ItemAmount++);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ItemAmount>1){
                    tv.setText(ItemAmount-1);

                }
                else{
                tv.setText(ItemAmount);
            }
            }
        });
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            databaseReference.child("Groups").child(groupNAme).child("Items").child(Itemname).setValue(ItemAmount);
                Intent toItem=new Intent(ItemAmount.this,ItemsActivity.class);
                startActivity(toItem);
            }
        });
    }
}
