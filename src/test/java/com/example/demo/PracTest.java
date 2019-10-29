package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PracTest {

    @Test
    public void panagramCheckTest(){
        String data = "The quick brown fox jumps over the lazy dog";
        String dataWithOnlyChar = data.replaceAll("[^a-zA-Z]","");
        char[] splitData = dataWithOnlyChar.toLowerCase().toCharArray();
        Set<Character> splitDataSet = new HashSet<>();
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
}
