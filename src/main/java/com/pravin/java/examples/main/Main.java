package com.pravin.java.examples.main;


import com.pravin.java.examples.recordbuilder.Employee;
import com.pravin.java.examples.recordbuilder.EmployeeBuilder;

public class Main {
    public static void main(String[] args) {

        //Using Java record
        /*Employee employee = new Employee.EmployeeBuilder()
                .id(1l)
                .name("pravin")
                .company("dummy")
                .age(30)
                .build();*/

        //Using lombok library
        /*Employee employee = Employee.builder()
                .id(1l)
                .name("pravin")
                .company("dummy")
                .age(30)
                .build();*/

        Employee employee = EmployeeBuilder.builder()
                .id(1l)
                .name("pravin")
                .company("dummy")
                .age(30)
                .build();

        System.out.println(employee);
    }
}
