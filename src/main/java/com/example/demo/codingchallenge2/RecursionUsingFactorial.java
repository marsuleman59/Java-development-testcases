package com.example.demo.codingchallenge2;

public class RecursionUsingFactorial {
    public static void main(String[] args) {
        int numberFactorial = factorial(5);
        System.out.println(numberFactorial);
    }

    private static int factorial(int fac) {
        if (fac == 1)
            return 1;
        else
            return factorial(fac-1) * fac;
    }
}
