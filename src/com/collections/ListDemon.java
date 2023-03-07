package com.collections;

import java.util.*;

public class ListDemon {
    public static void main(String[] args) {
        List l=new ArrayList();
        l.add("hello");
        l.add("today");
        l.add(5);
        ListIterator it=l.listIterator(l.size());
        while (it.hasPrevious())
        {
            // Iterate in reverse
            System.out.println(it.previous());
        }

//        we can use generics to make a list limit to a particular type
    }
}
