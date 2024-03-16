package com.justnow.skills.learnFunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionInterfaceFunction {

    public static void main(String[] args) {
        functionDemo();
    }

    public static void functionDemo() {
        Function<String, Integer> lengthFunc = (String s) -> s.length();
        // 简介模式
        // Function<String, Integer> lengthFunc = String::length;

        List<Integer> listRes = functionMap(Arrays.asList("lambdas", "just_now", "test"), lengthFunc);

        System.out.println(listRes);
    }

    public static <T, R> List<R> functionMap(List<T> list, Function<T, R> function) {
        List<R> listRes = new ArrayList<>();

        for (T t : list) {
            listRes.add(function.apply(t));
        }

        return listRes;
    }
}
