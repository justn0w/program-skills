package com.justnow.javabase.learnthread.userthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author justnow
 * Created on 2023-06-14
 * Description
 */
public class ThreadPoolWithCompletableFuture {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(100);


    private static final int allDbCount = 8;

    private static final int perDbTableCount = 128;


    public void softDeleteTokenUser() {

        
        for (int i = 0; i < allDbCount; i++) {
            for (int j = 0; j < perDbTableCount; j++) {
                int tableIndex = i * perDbTableCount + j;


            }

        }

    }
}
