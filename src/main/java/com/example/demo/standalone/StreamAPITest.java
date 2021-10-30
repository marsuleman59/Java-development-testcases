package com.example.demo.standalone;

import java.util.ArrayList;
import java.util.List;

public class StreamAPITest {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("Suleman");
        stringList.add("Abdul");
        stringList.add("Mohammed");

        stringList.stream().mapToInt(s -> s.length()).forEach(s -> System.out.println(s));

    }
}
