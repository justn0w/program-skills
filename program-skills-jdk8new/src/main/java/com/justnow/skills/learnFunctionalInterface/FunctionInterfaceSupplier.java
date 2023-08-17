package com.justnow.skills.learnFunctionalInterface;


import java.util.Random;
import java.util.function.Supplier;

public class FunctionInterfaceSupplier {

    public static void main(String[] args) {
        supplierDemo();
    }

    public static void supplierDemo() {

        Supplier<Integer> randomSupplier = () -> {
            Integer randomInteger = new Random().nextInt(100);
            return randomInteger;
        };

        supplierFunc(randomSupplier);

    }

    public static <T> void supplierFunc(Supplier<T> supplier) {
        T t = supplier.get();
        System.out.println("随机数：" + t);
    }

}
