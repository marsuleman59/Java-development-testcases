package com.example.demo.standalone;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bril {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();

        stringList.add("Suleman");
        stringList.add("");
        stringList.add("Abdul");
        stringList.add("");
        stringList.add("Rasheed");
        stringList.add("Mohamed");
        stringList.add("");

            final String collectedString = stringList.stream().filter(str -> str.length()>=3).map(str -> str.substring(Math.abs(str.length() - 3))).collect(Collectors.joining(","));

        AtomicInteger atomicInteger = new AtomicInteger();

        long count = stringList.stream().filter((s) -> !(s.length() == 0)).count();
        System.out.println(count);

        Set<String> strings = new HashSet<>();

        stringList.stream().forEach(s -> strings.add(s));

        System.out.println(strings);


        // Array of Char - Print each char. and how many times it is repeated
        char[] chars = {'a','b','c','d','a'};

        HashMap<Character, Integer> hashMap = new HashMap<>();

//        for (int i=0; i<chars.length; i++){
//
//            if(hashMap.get(chars[i] == null){
//            hashMap.put(chars[i], ())+1);
//        }
//        }

        System.out.println(hashMap);
//
//        for (int i=0; i< chars.length; i++){
//            int count = 1;
//            for (int j = 0; j <i; j++) {
//                    if (chars[i] == chars[j]){
//                        count++;
//                    }
//            }
//            System.out.println("Char: "+chars[i] + " is repeated:"+count+" times");
//            count = 0;
//        }


        // Employee Contact table
        // Eid - Contact type - Value

//        1 - phone - 1234
//         1- phone - 3434

//        select distinct (eid) from employeeContacts join (select * from employeeContacts) groupby max contacttype;

//        select eid from employee where contactType is null;

    }
}
