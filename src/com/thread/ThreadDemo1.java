package com.thread;
class hellorunner implements Runnable {
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
public class ThreadDemo1 {
    public static void main(String[] args) {
       hellorunner obj=new hellorunner();
       Thread t1=new Thread(obj);
        Thread t2=new Thread(obj);
        Thread t3=new Thread(obj);
        t1.setName("FRed");
        t1.setPriority(7);
        t2.setName("lucy");
        t3.setName("brian");
       t1.start();
       t2.start();
       t3.start();
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
