package com.example.demo.codingchallenge2;

public class ExcelCharExample {

    static int i = 0;

    public static void main(String[] args) {

        System.out.println(generateExcelString(156));
    }

    private static String generateExcelString(int number){
        StringBuilder init = new StringBuilder();
        int divisor = 0;
        while (divisor > 26) {
            divisor = number / 26;
            init.append(Character.toString('A' + divisor));

        }

        int mod = number % 26;

        init.append(Character.toString('A' + mod));

        return init.toString();

    }
}
