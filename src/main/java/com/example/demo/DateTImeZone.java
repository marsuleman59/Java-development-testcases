//package com.example.demo;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.time.*;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//
//class DateTImeZonedClass {
//
//    public static void main(String[] args) throws IOException {
//        java.time.LocalDate date = java.time.LocalDate.ofYearDay(2020, 35);
////
////        System.out.println(date.toString());
//
//        CharSequence text;
//        DateTimeFormatter formatter;
//        LocalDate date1 = LocalDate.parse("Jan/18/2020", DateTimeFormatter.ofPattern("MMM/d/y"));
////        System.out.println(date1.toString());
//
//        LocalDate date2 = date1.minusDays(1011);
////        System.out.println(date2.toString());
//
////        System.out.println("Period.between(date1, date2):: "+Period.between(date2, date1).getDays());
//
//        LocalTime localTime = LocalTime.parse("13:13:13", DateTimeFormatter.ISO_TIME);
//
//        LocalDateTime localDateTime = date1.atTime(localTime);
////        System.out.println("localDateTime" + localDateTime.toString());
//
//        Instant instant = Instant.now();
////        System.out.println(instant.toString() +" , "+instant.toEpochMilli() + " , " + instant.getEpochSecond());
//        LocalDateTime localDateTime1 = localDateTime.parse("1995-01-20T00:00:00", DateTimeFormatter.ISO_DATE_TIME);
////        System.out.println("Birthday" + localDateTime1.plus(Duration.ofDays(2)));
//
////        Period period = Period.between(date2, date1);
////
////        Duration duration = Duration.between(date2, date1);
//
////        period.getDays();
////        duration.toDays();
//
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();
//        System.out.println(zonedDateTime);
//
//        ZonedDateTime sameInstantZoneID = zonedDateTime.withZoneSameInstant(ZoneId.of(ZoneId.getAvailableZoneIds().iterator().next()));
//
//        System.out.println("sameInstantZoneID :: "+ sameInstantZoneID.toString());
//
//        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
//        String readLine = br.readLine();
//        System.out.println(readLine);
//    }
//}
