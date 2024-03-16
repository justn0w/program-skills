package com.justnow.skills._01_generics.typemethod.operatedb;

public interface DbDataOperate {

    <T> Long insert(T t);

    <T> Integer count(T t);
}
