package com.justnow.javabase.learnconcurrent.thread1;

/**
 * @author justnow
 * Created on 2023-07-08
 * Description
 */
public class Demo01 {

    public static void main(String[] args) throws InterruptedException {

        String name = Thread.currentThread().getName();
        System.out.println("main方法name=" + name);
        new Thread(() -> {
            System.out.println("1");
        }, "A").start();

        new Thread(() -> {
            System.out.println("2");
        }).start();

        new Thread(() -> {
            System.out.println("3");
        }).start();
    }
}
