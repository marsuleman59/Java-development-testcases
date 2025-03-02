package com.example.demo.codingchallenge2;

class LongestPalindromeSolution {
    public static String longestPalindrome(String s) {

        if(s.length() ==1){
            return s;
        }

        String longestPalindrome = "";
        for(int i=0; i<s.length(); i++){

            for(int j = i+1; j<=s.length(); j++){
                String subString = s.substring(i,j);
                boolean isPalindrome = isPalindrome(subString);
                if(isPalindrome && subString.length() > longestPalindrome.length()){
                    longestPalindrome = subString;
                }
            }
        }
        return longestPalindrome;
    }

    private static boolean isPalindrome(String subString){
        return new StringBuilder(subString)
                .reverse().toString().equalsIgnoreCase(subString);
    }

    public static void main(String[] args) {
        String longestPalindrome = LongestPalindromeSolution.longestPalindrome("CCCCCCCCCCCCCCCCCCCCCCCCCCCCC");

        if (!longestPalindrome.equalsIgnoreCase("CCCCCCCCCCCCCCCCCCCCCCCCCCCCC")){
            System.err.println("error in code");
        }
    }
}