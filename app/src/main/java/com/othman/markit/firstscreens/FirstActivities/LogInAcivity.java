package com.othman.markit.firstscreens.FirstActivities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.MainActivity;

public class LogInAcivity extends AppCompatActivity {
private EditText email,password;
private Button signIn;
private TextView needAcount;

FirebaseAuth auth1122;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_acivity);
        signIn=(Button)findViewById(R.id.logIn);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        needAcount=(TextView)findViewById(R.id.NeedAcount);

        auth1122=FirebaseAuth.getInstance();


        needAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toSigUp=new Intent(LogInAcivity.this,SignUpActivity.class);
                startActivity(toSigUp);
            }
        });





       signIn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            dataHandler();

           }
       });

        }

        public void dataHandler(){
        String Email=email.getText().toString();
        String Password=password.getText().toString();
        SignIn(Email,Password);
        }
        private void SignIn(String email,String password){
            FirebaseAuth authLoged=FirebaseAuth.getInstance();
            authLoged.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LogInAcivity.this, "Hi hope you enjoy", Toast.LENGTH_SHORT).show();
                    Intent ToMain=new Intent(LogInAcivity.this,MainActivity.class);
                    startActivity(ToMain);

                }
                else{
                    Toast.makeText(LogInAcivity.this, "Erorr,please check your email and password", Toast.LENGTH_SHORT).show();
                }
                }
            });
        }


}
