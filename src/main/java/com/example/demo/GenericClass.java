package com.example.demo;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenericClass<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {

//        GenericClass<Integer> gClass = new GenericClass<>();
//
//        gClass.setT(1);
//
//        Integer t1String = gClass.getT();
//        System.out.println(t1String);


//        ArrayList<String> strings = new ArrayList<>();

        TreeSet<Integer> treeSet = new TreeSet<>(Integer::compareTo);
        treeSet.add(10);
//        treeSet.add(20);
        treeSet.add(30);
        treeSet.add(40);
        treeSet.add(50);
        treeSet.add(60);
        treeSet.add(70);
//        System.out.println(treeSet);
//        System.out.println(treeSet.pollLast());
//        System.out.println(treeSet);

        TreeMap<Integer, Integer> integerTreeMap = new TreeMap<>();

//        ArrayDeque<String> doubleQueue = new ArrayDeque<>();
//        doubleQueue.push("Water");
//        doubleQueue.push("Land");
//        doubleQueue.push("Roaming");
//        doubleQueue.push("Filter");
//        System.out.println(doubleQueue);
//        String element = doubleQueue.element();
//        System.out.println(element);
//        System.out.println(doubleQueue);
//        doubleQueue.pop();
//        System.out.println("element popped");
//        System.out.println(doubleQueue);


        ArrayList<String> strings = new ArrayList<>();
        strings.add("Suleman");
        strings.add("Afreen");
        strings.add("Farha");
        strings.add("Suleman");
        strings.add("Mohammed");
        strings.add("Mohammed");
        strings.add("Minnu");
        strings.add("Ammu");

        Collections.sort(strings, Comparator.naturalOrder());

        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("Suleman",231);
        stringMap.put("Afreen",221);
        stringMap.put("Suleman",14);
        stringMap.put("Farha",1);
        stringMap.put("Farha",135);
        stringMap.put("Mohammed",111);

        stringMap.entrySet().stream().sorted(Comparator.comparingInt(Map.Entry::getValue));

//        System.out.println(stringMap);

        List<Integer> evenInts = IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .boxed()
                .collect(Collectors.toList());

//        System.out.println(evenInts);

        List<Double> doubles = new ArrayList<>();
        doubles.add(1D);

        doubles.add(122D);
        doubles.add(1333D);
        doubles.add(13453D);
        doubles.add(665D);
        doubles.add(8989D);
        doubles.add(454D);
        doubles.add(1212D);

        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String, List<Locale>> collect = locales.collect(Collectors.groupingBy(Locale::getCountry));

        collect.forEach((s, locales1) -> System.out.println(s + "::" +locales1));

    }
}
