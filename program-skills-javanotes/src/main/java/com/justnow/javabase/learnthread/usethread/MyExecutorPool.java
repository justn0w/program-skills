package com.justnow.javabase.learnthread.usethread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author justnow
 * Created on 2023-04-09
 * Description
 */
public class MyExecutorPool {

    public void createMyThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int taskId = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "线程, 执行了任务：" + taskId);
            });
        }
        executorService.shutdown();
    }
}
