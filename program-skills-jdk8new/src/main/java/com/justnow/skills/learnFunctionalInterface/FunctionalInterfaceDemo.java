package com.justnow.skills.learnFunctionalInterface;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author justnow
 * Created on 2023-08-16
 * Description
 */
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        method1();
        method2();
    }

    //1 使用匿名类执行线程池任务
    public static void method1() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("I am method1 content!");
            }
        });
    }

    //2 使用lambda执行线程池任务
    public static void method2() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        executorService.submit(() -> System.out.println("I am method2 content!"));
    }
}
