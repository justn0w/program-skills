package com.justnow.skills.learnFunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionInterfaceConsumer {

    public static void main(String[] args) {
        consumerDemo01();
    }

    public static void consumerDemo01() {
        List<String> lists = Arrays.asList("1", "2", "3", "4", "5");

        //1 函数式接口的实例
        Consumer<String> consumerPrint =  (String s) -> System.out.println(s);

        //2 使用lambda表达式作为入参
        forEach(lists, consumerPrint);

        //3 简洁模式
        forEach(lists, (String s) -> System.out.println(s));

        //4 使用方法引用优化lambda表达式
        forEach(lists, System.out::println);

    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
