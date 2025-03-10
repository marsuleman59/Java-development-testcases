package com.example.demo.generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        List<Melon> melons = new ArrayList<>();
        melons.add(new Melon(2));
        melons.add(new Melon(3));
        melons.add(new Melon(4));

        MainClass mainClass = new MainClass();
        mainClass.processElements(melons);

        List<WaterMelon> waterMelons = new ArrayList<>();
        waterMelons.add(new WaterMelon(2));
        waterMelons.add(new WaterMelon(3));
        waterMelons.add(new WaterMelon(4));
        mainClass.processElements(melons);

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(2));
        mainClass.processElements(fruits);

    }

    public void processElements(List<? super Melon> melons){
        System.out.println(melons.getClass());
//        melons.stream().forEach(melon -> System.out.println(melon.getA()));
//        melons.stream().max(Comparator.comparing(Melon::))

        List<Melon> melons1 = new ArrayList<>();
        melons.add(new Melon(2));
        melons1.stream().max(Comparator.comparing(Melon::getA)).ifPresent(System.out::println);


    }
}
