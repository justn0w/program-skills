package com.justnow.skills.learnlambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author justnow
 * Created on 2023-07-29
 * Description
 */
public class LambdaDemo {


    public static void main(String[] args) {

        method01();
        System.out.println("----------------");

        method02();
        System.out.println("----------------");

        method03();
        System.out.println("----------------");

        method04();
        System.out.println("----------------");

        method05();

    }

    public static List<Apple> getListApple() {
        List<Apple> apples = Arrays.asList(
                new Apple(2, "2-apple"),
                new Apple(3, "3-apple"),
                new Apple(1, "1-apple")
        );

        return apples;


    }

    //1 最原始方法，定义一个比较器
    public static void method01() {

        List<Apple> list = getListApple();
        list.sort(new AppleComparator());
    }

    //2 使用匿名类
    public static void method02() {
        List<Apple> list = getListApple();
        list.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        list.forEach(System.out::println);
    }

    //3 使用Lambda表达式进行优化
    public static void method03() {

        List<Apple> list = getListApple();
        list.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
        list.forEach(System.out::println);
    }

    //4 使用Function接口进行优化
    public static void method04() {
        List<Apple> list = getListApple();
        Comparator<Apple> c = Comparator.comparing((Apple a) -> a.getWeight());
        list.sort(Comparator.comparing(a -> a.getWeight()));
        list.forEach(System.out::println);
    }

    //5 使用方法引用
    public static void method05() {
        List<Apple> list = getListApple();
        list.sort(Comparator.comparing(Apple::getWeight));
        list.forEach(System.out::println);
    }
}

@Data
@ToString
@AllArgsConstructor
class Apple {

    private Integer weight;

    private String name;
}

class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple a1, Apple a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}
