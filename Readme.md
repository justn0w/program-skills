#### 记录工作的编程技巧的思想

一 面向对象编程
1.1 重载的巧妙使用

当前方法被多处调用，此时新的业务必须新增字段才能满足，重写该方法可能会出现遗漏的地方
此时便可以考虑重载的方法啦

举例如下：
```java
public class OverLoadDemo1 {

    public static void main(String[] args) {
        OverLoadFunctionDemo1 demo1 = new OverLoadFunctionDemo1();
        demo1.queryUserName("1", "10");

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
}
```

我们通过重载的方法，写一个三个入参的方法，并且让原有的方法调用这个方法，这样就不用在多处修改参数了！

```java
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

```