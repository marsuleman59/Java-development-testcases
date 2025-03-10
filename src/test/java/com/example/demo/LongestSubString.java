package com.example.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;

public class LongestSubString {
    public static void main(String[] args) {
        String input = "abcdafg";
        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring(input));
    }

    public static int longestSubstring(String s) {
        LocalDateTime localDateTime = LocalDateTime.now();

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;  // Left pointer of the window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and its index is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                // Move the start pointer to the right of the previous occurrence of the character
                start = map.get(currentChar) + 1;
            }

            // Update the map with the current character's index
            map.put(currentChar, end);

            // Calculate the length of the current substring
            maxLength = Math.max(maxLength, end - start + 1);
            System.out.println("Current substring: " + s.substring(start, end + 1) + ", maxLength: " + maxLength);
        }
        long timeTaken = Duration.between(localDateTime, LocalDateTime.now()).toMillis();
        System.out.println("milli seconds: "+timeTaken);
        return maxLength;

    }
}
