package com.collections;

import java.util.HashMap;

public class Student {
    HashMap<String,String> mpp=new HashMap<>();

    String addStudentdetails(String name,String id){
        if(mpp.containsKey(name)){
            return "Id generation Failed, name is already present in the database";
        }
        mpp.put(name,id);
        return "Id Generated";
    }
    String deleteId(String name){
        if(mpp.containsKey(name)){
            mpp.remove(name);
            return "Id deleted successfully";
        }
        return "Id not found";
    }
    String searchId(String name){
        if(mpp.containsKey(name)){
            return mpp.get(name);
        }
        return "Id not found";
    }

    public static void main(String[] args) {
        Student s1=new Student();
        Student s2=new Student();
        Student s3=new Student();
        Student s4=new Student();
        System.out.println(s1.addStudentdetails("Sarah","99889"));
        System.out.println(s2.addStudentdetails("John","78985"));
        System.out.println(s3.deleteId("Sarah"));
        System.out.println(s4.searchId("Steve"));;
    }
}
