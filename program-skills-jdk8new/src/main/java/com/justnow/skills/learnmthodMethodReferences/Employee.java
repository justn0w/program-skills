package com.justnow.skills.learnmthodMethodReferences;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Supplier;

@Data
@AllArgsConstructor
public class Employee {

    String name;

    Integer age;

    public Employee() {

    }

    public static int compareByAge(Employee a, Employee b) {
        return a.age.compareTo(b.age);
    }

    public void employeeToString() {
        System.out.println(name + ":" + age);
    }

    public static Employee create(Supplier<Employee> employeeSupplier) {
        return employeeSupplier.get();
    }

}
