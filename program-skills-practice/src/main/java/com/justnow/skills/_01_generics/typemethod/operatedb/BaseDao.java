package com.justnow.skills._01_generics.typemethod.operatedb;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao implements DbDataOperate{

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public <T> Long insert(T t) {

        String name = t.getClass().getSimpleName();
        String mapperId = name + ".insert"; //mapperName.methodName;
        long value = sqlSessionTemplate.insert(mapperId, t);

        return value;
    }

    @Override
    public <T> Integer count(T t) {
        return null;
    }
}
