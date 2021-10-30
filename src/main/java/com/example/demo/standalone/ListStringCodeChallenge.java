package com.example.demo.standalone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStringCodeChallenge {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("Apple");
        stringList.add("Ball");
        stringList.add("Cat");
        stringList.add("Dog");
        stringList.add("Elephant");
        stringList.add("Frog");
        stringList.add("Ghost");
        stringList.add("HandCraft");


        // Printing all the length of the string in the list
        for (int i=0; i < stringList.size(); i++){
            System.out.println("String at index: ["+i+"] has String: ["+stringList.get(i)+"] of length: ["+stringList.get(i).length()+"]");
        }

        System.out.println("########################################");

        //Reverse of the elements in the list

        Collections.reverse(stringList);
        System.out.println(stringList);


        //Reverse each of the element in the List

        List<String> reversedStrings = new ArrayList<>();

        for (int i=0; i < stringList.size(); i++){
        StringBuilder builder = new StringBuilder(stringList.get(i));
        reversedStrings.add(String.valueOf(builder.reverse()));
        }

        reversedStrings.forEach(o -> System.out.println(o));

    }
}
