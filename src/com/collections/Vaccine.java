package com.collections;

import java.util.ArrayList;

public class Vaccine {
    private int age;
    private int dosage;

    Vaccine(int age){
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }
}
class VacinationCamp{
    ArrayList<Vaccine> arr=new ArrayList<Vaccine>();

    void assignVaccine(){
        for(Vaccine v:arr){
            if(v.getAge()>=45){
                v.setDosage(250);
            } else if (v.getAge()>=20) {
                v.setDosage(200);
            }else{
                v.setDosage(100);
            }
        }
    }
    float Vaccineinjected(){
        float total=0f;
        for(Vaccine v:arr){
            total+=v.getDosage();
        }
        return total;
    }

    public static void main(String[] args) {
        VacinationCamp vcc=new VacinationCamp();
        Vaccine v1=new Vaccine(20);
        Vaccine v2=new Vaccine(29);
        Vaccine v3=new Vaccine(50);
        vcc.arr.add(v1);
        vcc.arr.add(v2);
        vcc.arr.add(v3);
        vcc.assignVaccine();
        System.out.println(vcc.Vaccineinjected());

    }
}