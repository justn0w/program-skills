package com.justnow.javabase.learnobjectoriented;

/**
 * 动物类
 */
public class Animal {

    public void sound() {
        System.out.println("动物发出声音");
    }

    public static void main(String[] args) {
        //1 多态
        Animal animal01 = new Dog();
        Animal animal02 = new Cat();
        animal01.sound();
        animal02.sound();

        //2 向上转型
        Animal animal03 = new Dog(); //向上转型:指将一个子类的对象引用赋值给其父类类型的引用变量
        animal03.sound();

        //3 向下转型
        if (animal03 instanceof Dog) { //在进行向下转型之前，应该使用 instanceof 运算符进行类型检查，以避免出现异常情况。
            Dog dog = (Dog) animal03; //向下转型:指将一个父类类型的引用变量转换为其子类类型的引用变量
            dog.eat();
        }


    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("汪汪叫");
    }

    public void eat() {
        System.out.println("dog is eating");
    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("喵喵叫");
    }
}
