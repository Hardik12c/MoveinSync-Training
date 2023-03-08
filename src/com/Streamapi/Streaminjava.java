package com.Streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streaminjava {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(2, 1, 3, 5, 6, 7, 3, 8, 9);
        Stream<Integer> st = l.stream().sorted().distinct().map(i->i*2);
        st.forEach(i-> System.out.println(i));
    }
}
