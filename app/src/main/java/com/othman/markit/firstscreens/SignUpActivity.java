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

    private Button save;
    FirebaseAuth auth;
    FirebaseUser user;




    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Fname=(EditText)findViewById(R.id.Fname);
        Lname=(EditText)findViewById(R.id.Lname);
        email=(EditText)findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        save=(Button)findViewById(R.id.Save);
        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        databaseReference=FirebaseDatabase.getInstance().getReference();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString();
               String Password = password.getText().toString();
               String firstname=Fname.getText().toString();
               String lastName=Lname.getText().toString();
                if(Password.length()>8&&Email.contains("@")) {
                    SignIN(Email, Password);
                    saveUserInfo(firstname,lastName);


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

                    Intent intent3=new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent3);
                    finish();


                }
                else {
                    Toast.makeText(SignUpActivity.this, "Check email and password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
     public void saveUserInfo(String firstName,String LastName){
         User user=new User(firstName,LastName);
         databaseReference.child(Fname.getText().toString()).setValue(user);


     }


}

