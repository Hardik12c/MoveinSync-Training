package com.thread;

class isAlive1 implements Runnable{
    public void run()
    {
        try{
            for(int i=0;i<5;i++)
            {
                System.out.println(Thread.currentThread().getName()+i);
                Thread.sleep(1000);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

public class IsAliveDemo
{
    public static void main(String[] args) {
        isAlive1 obj=new isAlive1();
        Thread t1=new Thread(obj);
        Thread t2=new Thread(obj);
        t1.start();
        t2.start();
        System.out.println(t1.isAlive());
        System.out.println(t2.isAlive());
        try{
            t1.join();
            t2.join();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        System.out.println("after join"+t1.isAlive());
        System.out.println("after join"+t2.isAlive());
        System.out.println("main thread finishing last");
    }
}
