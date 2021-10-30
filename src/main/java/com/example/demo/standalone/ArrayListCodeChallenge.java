package com.example.demo.standalone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListCodeChallenge {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(56);
        list.add(59);
        list.add(34);
        list.add(12);
        list.add(90);
        list.add(89);
        list.add(76);
        list.add(32);
        list.add(43);
        list.add(56);

        int sum = list.stream().mapToInt(Integer::intValue).sum();

        int sum2 = 0;

        // Adding numbers of the Integers
        Iterator integerIterator = list.iterator();

        while (integerIterator.hasNext()) {

            sum2 += (int) integerIterator.next();
        }

        System.out.println("Sum of the numbers with Iterator: " + sum2);


        //Sum of squares of the numbers from the list
        Iterator integerIterator2 = list.iterator();

        int sumSquare2 = 0;
        while (integerIterator2.hasNext()) {
            int next = (int) integerIterator2.next();
            sumSquare2 += next * next;
        }

        System.out.println("Sum of squares of the numbers with Iterator: " + sumSquare2);

        //Sum of squares of  odd numbers from the list
        Iterator integerIterator3 = list.iterator();

        int sumSquareOfOdd = 0;
        while (integerIterator3.hasNext()) {

            int next = (int) integerIterator3.next();
            if (!(next % 2 == 0)) {
                sumSquareOfOdd += next * next;
            }
        }

        System.out.println("Sum of squares of odd the numbers with Iterator: " + sumSquareOfOdd);

        //Sum of squares of  Even numbers from the list
        Iterator integerIterator4 = list.iterator();
        int sumSquareOfEven = 0;
        while (integerIterator4.hasNext()) {

            int next = (int) integerIterator4.next();
            if (next % 2 == 0) {
                sumSquareOfEven += next * next;
            }
        }

        System.out.println("Sum of squares of even the numbers with Iterator: " + sumSquareOfEven);


    }
}
