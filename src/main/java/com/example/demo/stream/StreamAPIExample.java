package com.example.demo.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPIExample {

    public static void main(String[] args) {

        int[] numbers = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74};

//        String[] stringArray = {"Suleman", "Adil"};

        var maxValue = Arrays.stream(numbers).mapToObj(operand -> (char) operand).
        filter(value -> value != 'D').map(String::valueOf).reduce("start", (acc, value) -> acc+"," + value);


        System.out.println(maxValue);
    }


    static class InnerClass{
        public static void main(String[] args) {

            List<String> names = new ArrayList<>();

            names.add("Zahid");
            names.add("Basith");
            names.add("Ali");
            names.add("Ahmed");


//            names.stream().forEach(System.out::println);


            names.stream().filter(s -> s.charAt(0) != 'A').forEach(System.out::println);


            Optional<String> max = names.stream().min(Comparator.naturalOrder());

            System.out.println(max);

        }
    }












}
