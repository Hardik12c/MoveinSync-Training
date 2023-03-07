package com.collections;

import java.util.HashMap;

public class Population {
    HashMap<String,Integer> mpp=new HashMap<>();

    String maxpopulation(){
        String maxpop="";
        int mx=Integer.MIN_VALUE;
        for(String data:mpp.keySet()){
            if(mpp.get(data)>mx){
                maxpop=data;
                mx=mpp.get(data);
            }
        }
        return maxpop;
    }
    String minpopulation(){
        String minpop="";
        int mn=Integer.MAX_VALUE;
        for(String data:mpp.keySet()){
            if(mpp.get(data)<mn) {
                minpop = data;
                mn = mpp.get(data);
            }
        }
        return minpop;
    }

    Long totalpopulation(){
        Long total=0l;
        for(Integer i:mpp.values()){
            total+=i;
        }
        return total;
    }
    public static void main(String[] args) {
        Population obj = new Population();
        obj.mpp.put("India",26382898);
        obj.mpp.put("USA",82738);
        obj.mpp.put("UK",92732);
        System.out.println(obj.maxpopulation());
        System.out.println(obj.minpopulation());
        System.out.println(obj.totalpopulation());
    }
}
