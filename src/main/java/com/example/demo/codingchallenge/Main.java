package com.example.demo.codingchallenge;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * ========================= PROBLEM STATEMENT =========================
 * Write a Java program to check if two strings are anagrams using Stream API.
 *
 * Example:
 * Input:
 * String s1 = "secure";
 * String s2 = "rescue";
 * Output:
 * Two strings are anagrams
 *
 * The program should return "Two strings are anagrams" if both strings contain
 * the same characters in any order, else return "Two strings are NOT anagrams".
 * =====================================================================
 */

public class Main {
    public static void main(String[] args) {
        // Example test cases
        List<String[]> testCases = Arrays.asList(
                new String[]{"secure", "rescue"},
                new String[]{"listen", "silent"},
                new String[]{"triangle", "integral"},
                new String[]{"java", "python"},
                new String[]{"abcd", "dcba"},
                new String[]{"hello", "world"}
        );

        List<String> expectedOutputs = Arrays.asList(
                "Two strings are anagrams",
                "Two strings are anagrams",
                "Two strings are anagrams",
                "Two strings are NOT anagrams",
                "Two strings are anagrams",
                "Two strings are NOT anagrams"
        );

        int passed = 0;
        int failed = 0;

        for (int i = 0; i < testCases.size(); i++) {
            String userOutput = runUserFunction(testCases.get(i)[0], testCases.get(i)[1]);  // Call user's function

            if (userOutput.equals(expectedOutputs.get(i))) {
                passed++;
            } else {
                failed++;
                System.out.println("❌ Test Case " + (i + 1) + " Failed");
                System.out.println("Expected:\n" + expectedOutputs.get(i));
                System.out.println("Got:\n" + userOutput);
                System.out.println("--------------------------------");
            }
        }

        // Final test case results
        System.out.println("✅ Passed: " + passed);
        System.out.println("❌ Failed: " + failed);
    }

    // Function that the candidate needs to implement
    public static String runUserFunction(String s1, String s2) {
        // ===========================
        // 👉 START YOUR CODE BELOW 👇
        // ===========================

        String str = new String();
        String str1 = new String();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        ConcurrentHashMap<Character, Integer> map1 = new ConcurrentHashMap<Character, Integer>();

   return s1
           .chars()
           .sorted()
           .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
           .toString()
           .equals(s2.chars().sorted()
                   .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString()) ? "Two strings are anagrams" : "Two strings are NOT anagrams";

        // ===========================
        // 👆 END YOUR CODE HERE 👆
        // ===========================

    }
}