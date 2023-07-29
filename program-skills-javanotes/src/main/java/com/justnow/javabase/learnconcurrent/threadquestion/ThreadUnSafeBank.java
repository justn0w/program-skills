package com.justnow.javabase.learnconcurrent.threadquestion;

/**
 * @author justnow
 * Created on 2023-07-15
 * Description
 */
public class ThreadUnSafeBank {
    public static void main(String[] args) {

        // unSafe
        Account account = new Account(100, "结婚基金");
        UnsafeDrawThread you = new UnsafeDrawThread(account,50,"你");
        UnsafeDrawThread girlFriend = new UnsafeDrawThread(account,100,"girlFriend");
        you.start();
        girlFriend.start();

        //safe
//        Account safeAccount = new Account(100, "结婚基金");
//        SafeDrawThread youSafe = new SafeDrawThread(safeAccount,50,"你");
//        SafeDrawThread girlFriendSafe = new SafeDrawThread(safeAccount,100,"girlFriend");
//        youSafe.start();
//        girlFriendSafe.start();
    }
}

//账户
class Account{
    int money ;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class UnsafeDrawThread extends Thread {
    Account account;//账户
    int drawingMoney;//取多少钱
    int nowMoney;//手里多少钱

    public UnsafeDrawThread(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        //判断有没有钱
        if(account.money-drawingMoney<0){
            System.out.println(Thread.currentThread().getName()+"余额不足");
            return;
        }
        //sleep
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //卡内余额=卡里余额-取出钱
        account.money = account.money-drawingMoney;
        //手里钱=手里钱+取出钱
        nowMoney = nowMoney+drawingMoney;
        System.out.println(account.name+"余额为："+account.money);
        //Thread.currentThread().getName()等价于this.getName()
        System.out.println(this.getName()+"手里的钱:"+nowMoney);
    }
}


class SafeDrawThread extends Thread {
    Account account;//账户
    int drawingMoney;//取多少钱
    int nowMoney;//手里多少钱

    public SafeDrawThread(Account account,int drawingMoney,String name){
        super(name);
        this.account=account;
        this.drawingMoney=drawingMoney;
    }

    //取钱
    @Override
    public void run() {
        synchronized (account) {
            //判断有没有钱
            if(account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"余额不足");
                return;
            }
            //sleep
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=卡里余额-取出钱
            account.money = account.money-drawingMoney;
            //手里钱=手里钱+取出钱
            nowMoney = nowMoney+drawingMoney;
            System.out.println(account.name+"余额为："+account.money);
            //Thread.currentThread().getName()等价于this.getName()
            System.out.println(this.getName()+"手里的钱:"+nowMoney);
        }

    }
}

