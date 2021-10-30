package com.example.demo.standalone;

import com.example.demo.Employee;

import java.util.HashMap;

public class HashCollisionCheckMain {
    public static void main(String[] args) {
        String s = "a";
        String s1 = "b";
        String s2 = s+s1;
        HashMap<Employee, Integer> employeeHashMap = new HashMap<>();

        Employee employee = new Employee("Suleman", "001");
        Employee employee2 = new Employee("Suleman", "001");

        Employee employee3 = new Employee("Suleman", "001");
        Employee employee4 = employee3;

        employeeHashMap.put(employee, 1);
        employeeHashMap.put(employee2, 1);
        employeeHashMap.put(employee3, 1);
        employeeHashMap.put(employee4, 1);
        System.out.println("Added to map");
        employeeHashMap.get(employee);
        employeeHashMap.get(employee2);
        employeeHashMap.get(employee3);
        employeeHashMap.get(employee4);
        System.out.println("Retrieved from map");


    }
}
