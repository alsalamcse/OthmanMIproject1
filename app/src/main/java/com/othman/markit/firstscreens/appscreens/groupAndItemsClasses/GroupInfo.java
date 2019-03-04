package com.othman.markit.firstscreens.appscreens.groupAndItemsClasses;

import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Member;

public class GroupInfo extends User {
    private static String groupName;
    private static String user;



    public GroupInfo(String memberName,String lastname,User user){
        super(memberName,lastname);
        this.groupName=groupName;

    }



    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }



}
