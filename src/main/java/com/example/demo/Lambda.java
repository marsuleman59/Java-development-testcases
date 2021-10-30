package com.example.demo;

public class Lambda {


    public static void main(String[] args) {

    Calculation add = (a, b) ->{
     System.out.println(a+b);
     return 0;
    };
        Calculation sub = (a, b) ->{

            System.out.println(a-b);
            return 0;
        };

        Calculation mul = (a, b) ->{

            System.out.println(a*b);
            return 0;
        };

        Calculation div = (a, b) ->{

            System.out.println(a/b);
            return 0;
        };
    int a = 4, b = 10;
    initiateCalculus(a, b, add);
    initiateCalculus(a, b, sub);
    initiateCalculus(a, b, mul);
    initiateCalculus(a, b, div);

    int a1 = 330000000;
    long b1 = a1;
        System.out.println("b1 long from int "+b1);
    }

    private static void initiateCalculus(int a, int b, Calculation add) {
        add.calculate(a,b);
    }

    @FunctionalInterface
    public interface Calculation{
        public int calculate(int a, int b);
    }
}
