package com.example.demo.time;

import com.example.demo.LocalDateCodeExample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TimeApiExample {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now(ZoneOffset.UTC);
        LocalDate localDate2 = LocalDate.now(ZoneOffset.UTC).plusDays(2);
        LocalDateTime localDateTime = LocalDateTime.now();


        System.out.println(localDate);
        System.out.println(localDateTime);


        Map<String, String> hashMap = Collections.synchronizedMap(new HashMap<>());



    }

}
