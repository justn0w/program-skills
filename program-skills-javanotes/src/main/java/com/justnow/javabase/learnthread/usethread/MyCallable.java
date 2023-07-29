package com.justnow.javabase.learnthread.usethread;

import java.util.concurrent.Callable;

/**
 * @author justnow
 * Created on 2023-04-09
 * Description
 */
public class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("通过实现Callable接口, 创建线程");
        return 8;
    }
}
