package com.example.demo.codeingchallenge;

public class RecursionStringReverse {


    public static void main(String[] args) {
        String strReversed = "";
        strReversed = reverseStringWithRecursion("Suleman");
        System.out.println("Reversed String is: " + strReversed);

    }

    private static String reverseStringWithRecursion(String str) {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        System.out.println("jhv");
        return reverseStringWithRecursion(str.substring(1)) + str.charAt(0);
    }
}