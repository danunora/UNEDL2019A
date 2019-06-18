package com.dnunora;

import java.sql.Timestamp;

public class Thread2 extends Thread {

    @Override
    public void run() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Thread: " + currentThread().getName() + " :" + timestamp);
        try {
            Thread.sleep(6000);
        }
        catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("Thread: " + currentThread().getName() + " :" + timestamp);
    }
}
