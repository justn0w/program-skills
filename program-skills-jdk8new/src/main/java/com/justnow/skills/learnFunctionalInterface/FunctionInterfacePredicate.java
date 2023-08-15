package com.justnow.skills.learnFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author justnow
 * Created on 2023-08-16
 * Description
 */
public class FunctionInterfacePredicate {

    public static void main(String[] args) {
        predicateDemo01();
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

}
