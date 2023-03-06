package com.thread;

class hellorunner1 extends Thread {
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {

        }
    }
    public void run(String s)
    {
        System.out.println(s);
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {

       hellorunner1 t1=new hellorunner1();
        t1.setName("FRed");

        t1.start();

        try{
            for(int i=0;i<5;i++)
            {
                System.out.println("Main thread"+i);
                Thread.sleep(2000);
            }
        }
        catch(Exception e)
        {

        }
    }
}
