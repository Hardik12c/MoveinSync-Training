package com.Policy;


import java.util.HashMap;
import java.util.Scanner;

class InvalidInsurancename extends Exception{
    public InvalidInsurancename(String msg){
        System.out.println(msg);
    }
}
public class Insurance {
    HashMap<String,Integer> mpp=new HashMap<>();

    void addtomap(String name,Integer id) throws InvalidInsurancename{
        if(mpp.containsKey(name)){
            throw new InvalidInsurancename("This policy already exist");
        }
        mpp.put(name,id);
    }

    void search(String word){
        for(String name:mpp.keySet()){
            if(name.contains(word)){
                System.out.println(mpp.get(name));
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Insurance in=new Insurance();
        System.out.println("Please Enter the number of Policies You want to give");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter the policy id");
            int id=sc.nextInt();
            System.out.println("Enter the policy name");
            String s=sc.nextLine();
            sc.nextLine();
            in.addtomap(s,id);
        }
        System.out.println("Enter the word u want to search");
        String word=sc.next();
        in.search(word);
    }
}

