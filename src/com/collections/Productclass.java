package com.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Productclass {
    int id;
    String name;
    double price;

    Productclass(int id,double price,String name){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public static void main(String[] args) {
        List<Productclass> l=new ArrayList<Productclass>();
        Productclass p1=new Productclass(12,79.3,"Bucket");
        Productclass p2=new Productclass(123,59.3,"Table");
        Productclass p3=new Productclass(125,790.7,"Chair");

        l.add(p1);
        l.add(p2);
        l.add(p3);
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the Product Name");
        Boolean flag=true;
        String Productname=s.next();
        for(int i=0;i<l.size();i++){
            if(l.get(i).name.equals(Productname)){
                flag=false;
                System.out.println("Product id "+l.get(i).id);
                System.out.println("Product price "+l.get(i).price);
                break;
            }
        }
        if(flag) System.out.println("Product Not found");
    }
}

