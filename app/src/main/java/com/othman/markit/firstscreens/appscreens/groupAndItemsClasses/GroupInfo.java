package com.othman.markit.firstscreens.appscreens.groupAndItemsClasses;

import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Member;

public class GroupInfo {
    private static String groupName;
    private static String member;
   private static FirebaseAuth auth=FirebaseAuth.getInstance();


    public GroupInfo(String groupName,Member member){
        this.groupName=groupName;
        this.member=auth.getCurrentUser().getEmail();
    }



    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }



    public void setMember(String member) {
        this.member = member;
    }



    public String getGroupName() {
        return groupName;
    }


    public String getMember() {
        return member;
    }
}
