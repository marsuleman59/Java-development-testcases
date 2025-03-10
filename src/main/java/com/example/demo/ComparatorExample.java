package com.example.demo;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Comparator<String> comparator =  Comparator.nullsFirst((o1, o2) -> o1.hashCode());

    }
}
