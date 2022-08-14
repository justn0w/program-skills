package com.justnow.skills.overload;

import org.omg.CORBA.OBJ_ADAPTER;

import java.util.HashMap;
import java.util.Map;

/**
 * @author justnow
 * Created on 2022-08-15
 * Description
 */
public class OverLoadDemo1 {

    public static void main(String[] args) {
        OverLoadFunctionDemo1 demo1 = new OverLoadFunctionDemo1();
        demo1.queryUserName("1", "10");

        OverLoadFunctionDemo2 demo2 = new OverLoadFunctionDemo2();
        demo1.queryUserName("1", "10");
        demo2.queryUserName("1", "10", "boy");

    }

    static class OverLoadFunctionDemo1 {

        //假如，共有20个地方调用了该方法
        public void queryUserName(String studentId, String age) {
            Map<String, Object> conditionMap = new HashMap<>();
            //1. 构建mapper入参
            conditionMap.put("studentId", studentId);
            conditionMap.put("age", age);
            //2. 查询dao层
            //3. 打印结果
        }
    }

    static class OverLoadFunctionDemo2 {

        //假如，共有20个地方调用了该方法
        public void queryUserName(String studentId, String age) {
            queryUserName(studentId, age, null);
        }

        public void queryUserName(String studentId, String age, String gender) {
            Map<String, Object> conditionMap = new HashMap<>();
            //1. 构建mapper入参
            conditionMap.put("studentId", studentId);
            conditionMap.put("age", age);
            if (gender != null && gender.length() > 0) {
                conditionMap.put("gender", gender);
            }
            //2. 查询dao层
            //3. 打印结果
        }
    }
}
