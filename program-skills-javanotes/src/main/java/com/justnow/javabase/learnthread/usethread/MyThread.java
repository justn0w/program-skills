package com.justnow.javabase.learnthread.usethread;

/**
 * @author justnow
 * Created on 2023-04-09
 * Description
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("通过继承Thread类, 创建线程");
    }
}
