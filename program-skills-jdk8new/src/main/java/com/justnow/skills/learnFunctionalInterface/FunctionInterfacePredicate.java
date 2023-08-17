package com.justnow.skills.learnFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author justnow
 * Created on 2023-08-16
 * Description
 */
public class FunctionInterfacePredicate {

    public static void main(String[] args) {
        //predicateDemo01();

        consumerDemo01();
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> res = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                res.add(t);
            }
        }
        return res;
    }

    public static void predicateDemo01() {
        Predicate<String> nonEmptyFilter = (String s) -> !s.isEmpty();
        List<String> list = Arrays.asList("1", "2", "3", "", "4");
        System.out.println("过滤前：" + list.toString());
        List<String> filter = filter(list, nonEmptyFilter);
        //简洁模式
        List<String> filter1 = filter(list, s -> !s.isEmpty());

        System.out.println("过滤后：" + filter.toString());
        System.out.println("过滤后：" + filter1.toString());

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
