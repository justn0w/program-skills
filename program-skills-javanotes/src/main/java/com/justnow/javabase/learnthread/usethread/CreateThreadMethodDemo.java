package com.justnow.javabase.learnthread.usethread;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author justnow
 * Created on 2023-04-09
 * Description
 */
public class CreateThreadMethodDemo {

    public static void main(String[] args) {
        //1 通过实现Runnable接口创建线程
        MyRunnable myRunnable = new MyRunnable();
        Thread firstThread = new Thread(myRunnable);

        firstThread.start();

        //2 通过实现Callable接口创建线程
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer>  futureTask = new FutureTask<>(myCallable);
        Thread secondThread = new Thread(futureTask);
        secondThread.start();


        //3 通过继承Thread类创建线程
        MyThread thirdThread = new MyThread();
        thirdThread.run();

        //4 通过自定义线程池实现线程，如果不手动关闭, 线程池会一直运行
        MyExecutorPool myExecutorPool = new MyExecutorPool();
        myExecutorPool.createMyThreadPool();
    }
}
