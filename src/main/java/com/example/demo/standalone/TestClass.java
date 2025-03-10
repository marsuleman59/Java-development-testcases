package com.example.demo.standalone;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    static List<String> items = new ArrayList<>();
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        testClass.items.add("Pen");
        testClass.items.add("Pencil");
        testClass.items.add("Box");
        for (String i : items) {
            if (i.indexOf("P") == 0) {
                continue;
            } else {
                System.out.print(i+" ");
            }
        }
    }
}