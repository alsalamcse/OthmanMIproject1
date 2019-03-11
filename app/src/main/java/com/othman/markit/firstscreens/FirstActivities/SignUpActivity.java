package com.othman.markit.firstscreens.FirstActivities;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.othman.markit.R;
import com.othman.markit.firstscreens.appscreens.MainActivity;
import com.othman.markit.firstscreens.groupAndItemsClasses.User;

import java.util.HashMap;

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
                insertInfo();
                    Toast.makeText(SignUpActivity.this, "hi", Toast.LENGTH_SHORT).show();
                Intent toMainActivityfromSignUpActivity=new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(toMainActivityfromSignUpActivity);

            }
        });

    }
    public void insertInfo(){
       String email1=email.getText().toString();
       String password1=password.getText().toString();
        String firstname=Fname.getText().toString();
        String lastname=Lname.getText().toString();
        SignUp(email1,password1);
        saveUserInfo(firstname,lastname);
    }




    public void SignUp(String Email, String Password) {
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


     public void saveUserInfo(final String firstName, final String LastName){
        String emailForData=email.getText().toString();
         User user=new User(firstName,LastName);
         databaseReference.child("Users").setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
             @Override
             public void onComplete(@NonNull Task<Void> task) {
                 if (task.isSuccessful()){
                     Toast.makeText(SignUpActivity.this, "hello", Toast.LENGTH_SHORT).show();
                     HashMap<String,String> profileInfo=new HashMap<>();
                     profileInfo.put("First name:",firstName);
                     profileInfo.put("Last name:",LastName);

                 }
                 else{
                     Toast.makeText(SignUpActivity.this, "check your first name and last name", Toast.LENGTH_SHORT).show();
                 }
             }
         });


     }


}

