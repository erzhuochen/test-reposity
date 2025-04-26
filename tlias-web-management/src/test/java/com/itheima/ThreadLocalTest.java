package com.itheima;

import static org.apache.logging.log4j.internal.map.UnmodifiableArrayBackedMap.getMap;

public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();
    private static ThreadLocal<String> local2 = new ThreadLocal<>();

    public static void main(String[] args){
        local.set("Main Message");
        local2.set("2Main");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + local.get());
            }
        });

        System.out.println(Thread.currentThread().getName() + ":" + local.get());

        System.out.println(Thread.currentThread().getName() + ":" + local2.get());


    }
}
