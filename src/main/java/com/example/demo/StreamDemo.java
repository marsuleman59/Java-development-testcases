package com.example.demo;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class StreamDemo {

    AtomicInteger atomicInteger = new AtomicInteger();

    Stream<Integer> streamGenerated =
            Stream.generate(() -> atomicInteger.getAndIncrement()).limit(10);

    Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);


    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        streamDemo.streamIterated.forEach(System.out::println);
            streamDemo.streamIterated.forEach(System.out::println);
        try {
        }
        catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
        finally {

        }
        System.out.println("End of program");
    }
}
