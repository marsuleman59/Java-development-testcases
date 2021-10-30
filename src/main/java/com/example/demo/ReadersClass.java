package com.example.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadersClass {
    public static void main(String[] args) {
        String age = null;
        String name = null;
//        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));) {
//            System.out.println("Enter name");
//            name = bufferedReader.readLine();
//            System.out.println("Enter age");
//            age = bufferedReader.readLine();
////            Stream<String> lines = bufferedReader.lines();
////
////            String collector = lines.collect(Collectors.joining(", "));
////            System.out.println(collector);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//finally {
//            System.out.println("BufferedReader, Name :: " + name+ " , age :: "+age);
//
//        }

//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter a number, not a string");
//        Long a = scanner.nextLong();
//        System.out.println(a);
//        scanner.close();

        System.out.println("System.console().readLine() :: " + System.console().readLine());;
    }
}
