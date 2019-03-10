package com.othman.markit.firstscreens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.MainActivity;

public class SplashActivity extends AppCompatActivity {
private ImageView imageView;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.imageView);
        auth=FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!=null&&auth.getCurrentUser().getEmail()!=null){
            Intent intent=new Intent(getApplicationContext(),LogInAcivity.class);

        }
        Thread splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent MainActIntent=new Intent(getApplicationContext(),FirstActivity.class);
                    startActivity(MainActIntent);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        };
        splashThread.start();
    }
}
