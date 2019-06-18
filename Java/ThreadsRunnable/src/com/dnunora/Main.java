package com.dnunora;

public class Main {

    public static void main(String[] args) {
        System.out.println("desde el main thread");

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.setName("Este es el Thread1");
        t2.setName("Este es el Thread2");

        Runnable r1 = new Runnable1();
        Thread mrt = new Thread(new Runnable2());

        new Thread(){
            @Override
            public void run() {
                System.out.println("desde anonymous1 class");
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println("desde anonymous2 class");
            }
        }.start();

        //t1.run();
        t2.start();
        t1.start();
        t2.interrupt();
        r1.run();
        mrt.start();
    }
}
