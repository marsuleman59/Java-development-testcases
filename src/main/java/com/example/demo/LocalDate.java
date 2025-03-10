package com.example.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Comparator;

public class LocalDate {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime localDateTime1 = localDateTime.plusDays(10);

        Duration duration = Duration.between(localDateTime, localDateTime1);
        System.out.println(duration);

        Comparator<String> comparator =  Comparator.nullsFirst((o1, o2) -> o1.hashCode());

    }
}
