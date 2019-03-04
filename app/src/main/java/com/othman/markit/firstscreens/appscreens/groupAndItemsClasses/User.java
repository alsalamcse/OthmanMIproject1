package com.othman.markit.firstscreens.appscreens.groupAndItemsClasses;

import com.google.firebase.database.DatabaseReference;
import com.othman.markit.firstscreens.SignUpActivity;

public class User extends SignUpActivity {
    private String name;
    private String lastname;

    public User(String name, String lastname){
        super(name,lastname);


    }

}
