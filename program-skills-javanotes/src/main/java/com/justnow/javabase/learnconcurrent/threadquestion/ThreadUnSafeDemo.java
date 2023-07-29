package com.justnow.javabase.learnconcurrent.threadquestion;

/**
 * @author justnow
 * Created on 2023-07-09
 * Description
 */
public class ThreadUnSafeDemo {

    public static void main(String[] args) {
        ThreadUnSafe threadUnSafe = new ThreadUnSafe();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(threadUnSafe, "第" + i + "个人，开始抢票! ");
            thread.start();
        }

    }
}
