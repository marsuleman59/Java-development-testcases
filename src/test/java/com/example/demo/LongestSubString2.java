package com.example.demo;

import java.util.HashMap;

public class LongestSubString2 {


    public static void main(String[] args) {
        String input = "abcabcdefgbb";
        System.out.println("Longest Substring Without Repeating Characters: " + longestSubstring(input));
    }


    public static int longestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int maxLength = 0;

        int start = 0;

        for(int end = 0; end < s.length(); end++){

            char currentChar = s.charAt(end);

            if(map.containsKey(currentChar) && map.get(currentChar)>= start){
                start = map.get(currentChar)+1;
            }

            map.put(currentChar, end);
            maxLength = Math.max(maxLength, end-start+1);
            System.out.println("maxLength: "+maxLength+ ", subString current: "+s.substring(start, end+1));
        }

        return maxLength;

    }
}
