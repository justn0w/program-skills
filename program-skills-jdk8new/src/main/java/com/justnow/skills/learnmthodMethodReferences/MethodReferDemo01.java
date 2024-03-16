package com.justnow.skills.learnmthodMethodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;


public class MethodReferDemo01 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(100);
//        executorService.submit(() -> System.out.println("task is running!"));


        List<String> lists = Arrays.asList("1", "2", "3", "4");
        //forEach方法的入参是一个函数接口Consumer<? super T> action，可以用lambda表达式进行实例化

        //1 普通lambda表达式
        forEach(lists, x -> System.out.println(x));

        //2 用方法引用进行替换
        forEach(lists, System.out::println);

        forEach(lists, x -> System.out.println( "I am num: " + x));

        lists.forEach(x -> {
            ExecutorService executorService = Executors.newFixedThreadPool(100);
            executorService.submit(() -> System.out.println("task is running!"));
            System.out.println(x);
        });
    }



    public void testClassRefer() {
        List<MethodReferDemoClass> lists = Arrays.asList(new MethodReferDemoClass("Apple"), new MethodReferDemoClass("AAAaaa"), new MethodReferDemoClass("CCCA"), new MethodReferDemoClass("TESTAAAAAA"));
        forEach(lists, MethodReferDemoClass::getCharEqualsA);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }



}

