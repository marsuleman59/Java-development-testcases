package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracTest {


    @Test
    public void codeChal(){
//        arr[]={8,4,6,2,1} and x=2 Find the minimum of the sum of elements after performing below operations once.
//        1. one division by x
//        2. one multiplication by x
//        int x=2;
//        int element1 = 0;
//        int element2 = 0;
//        int lowestSum = 0;
//        int[] numbers = {8,4,6,2,1,10,11,7,9};
//        Arrays.sort(numbers);
//        System.out.println(Arrays.toString(numbers));

        


        }


    @Test
    public void panagramCheckTest(){
        String data = "The quick brown fox jumps over the lazy dog";
        String dataWithOnlyChar = data.replaceAll("[^a-zA-Z]","");
        char[] splitData = dataWithOnlyChar.toLowerCase().toCharArray();
        Set<Character> splitDataSet = new HashSet<>();
        System.out.println(splitDataSet.size()+": Size: "+splitDataSet);
        for (char ch: splitData){
        splitDataSet.add(Character.valueOf(ch));
        }
        System.out.println(splitDataSet.size()+": Size: "+splitDataSet);
        System.out.println(String.format("Size of set: [%d] ",splitDataSet.size()));
    }

    @Test
    public void boxingTest(){
        char a = 'a';
        Character.valueOf(a);
    }

    @Test
    public void panagramCheckTest3(){
        String data = "The quick brown fox jumps over the !lazy dog";
        String replace = data.replaceAll("[^a-zA-Z]", "").toUpperCase();
        System.out.println(replace);
        char[] charArray = new char[26];
        for (int i = 0; i < replace.length(); i++) {
            int ch = (int) replace.charAt(i);
            charArray[ch-65] = replace.charAt(i);
        }

    }

    @Test
    public void string1(){
        String str = "Suleman";
        int n = 2;

        String front = "";
        if(str.length() >= 3){
            front = str.substring(0,3);
        }
        else{
            front = str;
        }

        String returnString = "";

        for(int i=0; i<n; i++){
            returnString += front;
        }

        int[] nums = new int[4];
        System.out.println(nums.length);

    }

    @Test
    public void linkedListTest(){
        LinkedList<String> linkedStrings = new LinkedList<>();
        System.out.println("Size of linked list: "+linkedStrings.size());
        linkedStrings.add("Mohammed");
        System.out.println("Size of linked list: "+linkedStrings.size());
        final boolean suleman = linkedStrings.add("Abdul");
        System.out.println("Trying to add the String 'Suleman' again. Status added: "+suleman);
        System.out.println("Size of linked list: "+linkedStrings.size());

        linkedStrings.add("Rasheed");
        linkedStrings.add("Suleman");

        Iterator iterator = linkedStrings.iterator();

        int counter = 0;
        while (iterator.hasNext()){
            System.out.println("Printing node: " +counter++);
            final String next = (String) iterator.next();
            System.out.println(next);
        }

    }

}
