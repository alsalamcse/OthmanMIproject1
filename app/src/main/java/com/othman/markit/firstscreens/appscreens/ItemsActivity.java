package com.othman.markit.firstscreens.appscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.othman.markit.R;

public class ItemsActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Tomatos,Meat,Apple,Orange,Corn,Garlic,IceCream,Cucumber,Rice,Beans,Ketchup,Carrot;
   public static String  groupName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        Tomatos=(Button)findViewById(R.id.Tomatos);
        Meat=(Button)findViewById(R.id.Meat);
        Apple=(Button)findViewById(R.id.Apple);
        Orange=(Button) findViewById(R.id.Orange);
        Corn=(Button) findViewById(R.id.Corn);
        Garlic=(Button)findViewById(R.id.Garlic);
        IceCream=(Button)findViewById(R.id.IceCream);
        Cucumber=(Button)findViewById(R.id.Cucumber);
        Rice=(Button)findViewById(R.id.Rice);
        Beans=(Button)findViewById(R.id.Beans);
        Ketchup=(Button)findViewById(R.id.Ketchup);
        Carrot=(Button)findViewById(R.id.Carrot);
        groupName=getIntent().getExtras().getString("groupName");

        Tomatos.setOnClickListener(this);
        Meat.setOnClickListener(this);
        Apple.setOnClickListener(this);
        Orange.setOnClickListener(this);
        Corn.setOnClickListener(this);
        Garlic.setOnClickListener(this);
        IceCream.setOnClickListener(this);
        Cucumber.setOnClickListener(this);
        Rice.setOnClickListener(this);
        Beans.setOnClickListener(this);
        Ketchup.setOnClickListener(this);
        Carrot.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Tomatos:
                Intent intent=new Intent(ItemsActivity.this,ItemAmount.class);
                intent.putExtra("x",Tomatos.getText());
                intent.putExtra("groupName",groupName);

            case R.id.Meat:
                Intent intent2=new Intent(ItemsActivity.this,ItemAmount.class);
                intent2.putExtra("x",Meat.getText());
                intent2.putExtra("groupName",groupName);
        }
    }
}
