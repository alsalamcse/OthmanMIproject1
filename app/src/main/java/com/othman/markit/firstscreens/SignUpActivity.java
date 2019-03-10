package com.othman.markit.firstscreens;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.MainActivity;
import com.othman.markit.firstscreens.appscreens.groupAndItemsClasses.User;

public class SignUpActivity extends AppCompatActivity {
    private EditText Fname,Lname,email,password;
    private DatabaseReference databaseReference;


    private Button save,test;
   private FirebaseAuth auth;
   private FirebaseUser user;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Fname=(EditText)findViewById(R.id.Fname);
        Lname=(EditText)findViewById(R.id.Lname);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.Save);
        test=(Button)findViewById(R.id.test);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference();


        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tomain=new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(tomain);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(password.getText().toString().length()>8&&email.getText().toString().contains("@")) {
                    SignIN(email.getText().toString() ,password.getText().toString());
                    saveUserInfo(Fname.getText().toString(),Lname.getText().toString());


                }
                else{
                    Toast.makeText(SignUpActivity.this, "please check your email and password", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }




    public void SignIN(String Email, String Password) {
        FirebaseAuth auth=FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(SignUpActivity.this, "Welcome to MarkIt", Toast.LENGTH_SHORT).show();


                }
                else {
                    Toast.makeText(SignUpActivity.this, "Check email and password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
     public void saveUserInfo(String firstName,String LastName){
         User user=new User(firstName,LastName);
         databaseReference.child(email.getText().toString()).child(firstName).child(LastName).setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
             public void onComplete(@NonNull Task<Void> task) {
                 if (task.isSuccessful()){
                     Toast.makeText(SignUpActivity.this, "hello", Toast.LENGTH_SHORT).show();

                 }
                 else{
                     Toast.makeText(SignUpActivity.this, "check your first name and last name", Toast.LENGTH_SHORT).show();
                 }
             }
         });


     }


}

