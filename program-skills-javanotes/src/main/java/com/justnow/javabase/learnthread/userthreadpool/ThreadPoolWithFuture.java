package com.justnow.javabase.learnthread.userthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author justnow
 * Created on 2023-04-09
 * Description 结合Future,使用线程池
 */
public class ThreadPoolWithFuture {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    private static final int allDbCount = 8;

    private static final int perDbTableCount = 128;

    //1 扫描全表, 进行解绑
    public void delTokenUserByTokenId(Long tokenId) throws ExecutionException, InterruptedException {
        //1创建Futures列表, 用于接收异步任务处理结果
        List<Future<Long>> futures = new ArrayList<>();

        //2 借助线程池, 异步提交任务, 并发执行批量删除
        for (int curDbIndex = 0; curDbIndex < allDbCount; curDbIndex++) {
            for (int curPerTableIndex = 0; curPerTableIndex < perDbTableCount; curPerTableIndex++) {
                int tableIndex = curDbIndex * perDbTableCount + curPerTableIndex;
                futures.add(executorService.submit(() -> {
                    Long result = 100L;
                    return null;
                }));
            }
        }

        //3 取出执行结果
        for (Future<Long> future : futures) {
            Long aLong = future.get();
        }

        System.out.println("結果");
    }


}
