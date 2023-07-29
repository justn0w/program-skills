package com.justnow.javabase.learnconcurrent.thread1;

/**
 * @author justnow
 * Created on 2023-07-09
 * Description
 */
public class Demo02Wait {

    private static Object object = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
        }, "A").start();

        new Thread(() -> {
        }, "B").start();
    }
}
