package com.Function;

interface i{
    void display();
}
public class Functional_Interfaces {
    public static void main(String[] args) {
        i a=()->{
            System.out.println("Hello");
        };
        a.display();
    }
}
