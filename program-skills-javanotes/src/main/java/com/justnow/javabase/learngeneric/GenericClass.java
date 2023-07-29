package com.justnow.javabase.learngeneric;

/**
 * @author justnow
 * Created on 2023-05-08
 * Description
 */
public class GenericClass<T> {
    private T value;

    public GenericClass(T value) {

    }

    public T getValue() {
        return value;

    }

    public void setValue(T value) {
        this.value = value;
    }
}
