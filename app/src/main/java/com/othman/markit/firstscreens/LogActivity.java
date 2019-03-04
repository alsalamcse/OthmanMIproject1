package com.othman.markit.firstscreens;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.MainActivity;

public class LogActivity extends AppCompatActivity {
    private EditText Fname,Lname,email,password;
    private Button save;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        Fname=(EditText)findViewById(R.id.Fname);
        Lname=(EditText)findViewById(R.id.Lname);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.Save);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
               String Password = password.getText().toString();
                if(Password.length()>8&&Email.contains("@")) {
                    SignIN(Email, Password);
                    Intent intent2=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent2);

                }

            }
        });

    }
    public void SignIN(String Email,String Password) {
        FirebaseAuth auth=FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LogActivity.this, "Welcome to MarkIt", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }


}

