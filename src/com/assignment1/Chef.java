package com.assignment1;

import java.util.ArrayList;

public class Chef {
    int numberofchef=4;
    ArrayList<Integer> arr=new ArrayList<>();
    int defaulttime=8;

    void processThefood(int time){
        if(arr.size()<numberofchef){
            arr.add(time);
        }else{
            int mntime=Integer.MAX_VALUE;
            int in=-1;
            for(int i=0;i<arr.size();i++){
                if(arr.get(i)<mntime){
                    mntime=arr.get(i);
                    in=i;
                }
            }
            arr.set(in,arr.get(in)+time);
        }
    }

    String getthetime(){
        int mxtime=-1;
        for(int i=0;i<arr.size();i++){
            mxtime=Integer.max(mxtime,arr.get(i));
        }
        if(mxtime==-1){
            return null;
        }
        if(mxtime>=60){
            int t=mxtime/60;
            mxtime%=60;
            defaulttime+=t;
        }
        String mxt=Integer.toString(mxtime);
        String maintime=Integer.toString(defaulttime);
        return maintime+":"+((mxtime>=10)?mxt:"0"+mxt);
    }
}
