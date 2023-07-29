package com.justnow.javabase.learnconcurrent.threadquestion;

/**
 * @author justnow
 * Created on 2023-07-09
 * Description
 */
public class ThreadUnSafe implements Runnable {

    private int ticketNum = 10;
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }

    private void buy() {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNum + "张票");
        ticketNum--;
    }
}
