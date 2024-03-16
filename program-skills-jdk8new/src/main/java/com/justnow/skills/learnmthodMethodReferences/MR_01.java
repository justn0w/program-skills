package com.justnow.skills.learnmthodMethodReferences;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MR_01 {

    public static void main(String[] args) {
        refStatic();
        refInstance();
        refClass();
    }

    public static void refStatic() {
        List<Employee> lists = Arrays.asList(
                new Employee("a", 30),
                new Employee("z", 20),
                new Employee("e", 40)
        );

        //排序前
        System.out.println("排序前");
        lists.forEach(employee -> System.out.println(employee));

        //排序后
        System.out.println("排序后");
        //1 使用普通匿名类进行排序
        Collections.sort(lists, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        //2 使用lambda表达式进行排序
        Collections.sort(lists, (e1, e2) -> {
            return Employee.compareByAge(e1, e2);
        });

        //3 使用静态方法类型的方法引用
        Collections.sort(lists, Employee::compareByAge);

        lists.forEach(employee -> System.out.println(employee));
    }

    public static void refInstance() {
        List<Employee> lists = Arrays.asList(
                new Employee("a", 30),
                new Employee("z", 20),
                new Employee("e", 40)
        );

        EmployeeUtils employeeUtils = new EmployeeUtils();

        Collections.sort(lists, (e1, e2) -> employeeUtils.compareByName(e1, e2));

        Collections.sort(lists, employeeUtils::compareByName);
        lists.forEach(System.out::println);
    }

    public static void refClass() {
        List<Employee> lists = Arrays.asList(
                new Employee("a", 30),
                new Employee("z", 20),
                new Employee("e", 40)
        );

        forEach(lists, e -> e.employeeToString());

        forEach(lists, Employee::employeeToString);
    }

    public static void refNew() {

        Supplier<Employee> supplier = () -> new Employee();

        //1 使用lambda表达式
        Employee.create(supplier);

        //2 使用方法引用
        Employee.create(Employee::new);
    }

    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }


}

