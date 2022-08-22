package com.justnow.javabase.learnthread;

import com.justnow.core.domain.db.StudentDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author justnow
 * Created on 2022-08-17
 * Description
 */
public class UseThreadPoolDemo {
    public void ThreadPoolDemo01BatchQuery(Set<Integer> studentIdSet) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CountDownLatch countDownLatch = new CountDownLatch(studentIdSet.size());
        List<StudentDO> res = new ArrayList<>();
        //1. for循环中，任务会被子线程给执行了
        for (Integer id : studentIdSet) {
            executorService.execute(() -> {
                try {
                    StudentDO studentDO = queryStudentById(id);
                    res.add(studentDO);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();

        //2. 执行后面的逻辑

    }

    /**
     * 模拟查询数据库
     * @param id
     * @return
     */
    public StudentDO queryStudentById(Integer id) {
        StudentDO studentDO = new StudentDO();
        studentDO.setId(100L);
        System.out.println("根据id查询数据库");
        return studentDO;
    }

}
