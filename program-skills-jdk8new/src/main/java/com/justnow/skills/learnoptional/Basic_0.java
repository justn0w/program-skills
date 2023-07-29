package com.justnow.skills.learnoptional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author justnow
 * Created on 2023-07-29
 * Description
 */
public class Basic_0 {


    public static void main(String[] args) {
        Basic_0 basic_0 = new Basic_0();
        basic_0.createOptionalObject();
    }

    //创建Optional对象
    public void createOptionalObject() {

        Optional<Object> empty = Optional.empty();

        Car car = null;
        Optional<Car> optCar = Optional.of(car);

        Optional<Car> optCar2 = Optional.ofNullable(car);

        Consumer<Integer> consumer = System.out::println;
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(consumer);
        List<String> collect = list.stream()
                .map(x -> Utils.getName())
                .collect(Collectors.toList());

        Consumer<Integer> consumer1  =  i -> System.out.println(i);


    }
}


//保险类
class Insurance {
    private String name;

    public String getName() {
        return name;
    }
}

//car类
class Car {
    private Insurance insurance;
    public Insurance getInsurance() { return insurance; }
}

//people类
class Person {
    private Car car;
    public Car getCar() { return car; }
}

class Utils {
    public static String getName() {
        return "1";
    }
}