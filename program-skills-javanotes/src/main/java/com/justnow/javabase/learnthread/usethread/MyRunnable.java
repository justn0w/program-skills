package com.justnow.javabase.learnthread.usethread;

/**
 * @author justnow
 * Created on 2023-04-09
 * Description
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("通过实现Runnable接口, 创建线程");
    }
}
