//package com.example.demo;
//
//import org.apache.commons.lang3.ArrayUtils;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.util.*;
//
//@SpringBootApplication
//public class CodingC2 {
//    static String data = "abcdefghijklmnopqrstuvwxyz";
//    static Character[] splitData = ArrayUtils.toObject(data.toLowerCase().toCharArray());
//    static LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
//    static Set<String> uniqueSubString = new HashSet<>();
//
//    public static void main(String[] args) {
//
//
//    }
//
//    public static void combocheck() {
//        //		Given a string, find the length of the longest substring without repeating characters.
////		For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”,
////		with length 6. For “BBBB” the longest substring is “B”, with length 1
//        long startTime = System.nanoTime();
//        for (int i = 0; i < splitData.length; i++) {
//            if (!linkedHashMap.containsKey(splitData[i])) {
//                linkedHashMap.put(splitData[i], i);
//            } else {
//                uniqueSubString.add(data.substring(linkedHashMap.get(splitData[i]), i));
//
//            }
//        }
//        if (splitData.length == linkedHashMap.size()) {
//            uniqueSubString.add(data);
//        }
//        System.out.println(uniqueSubString.stream().max(Comparator.comparingInt(String::length)).get());
//
//    }
//}
//
