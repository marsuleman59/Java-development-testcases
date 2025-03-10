//package com.example.demo;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import java.io.File;
//import java.io.FileFilter;
//import java.util.*;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//@SpringBootApplication
//public class CodingC {
//	static String data = "ABDEFGABEF";
//	static char[] splitData = data.toCharArray();
////	static String[] goodStringArray = new String[10];
//	static int stringEndPoint = 1;
//
//	public static void main(String[] args)  {
////		Given a string, find the length of the longest substring without repeating characters.
////		For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”,
////		with length 6. For “BBBB” the longest substring is “B”, with length 1
//		Set<String> goodStringArray = new HashSet<>();
//		System.out.println(Arrays.toString(splitData));
//		int temp = 0;
//
//		for (int i = 0; i < splitData.length; i++) {
//			if (splitData[i] == availData(splitData[i], i,temp) ){
//
//			}
//			else {
//				goodStringArray.add(data.substring(temp, stringEndPoint));
//				temp = i;
//			}
//		}
//		System.out.println(goodStringArray);
//	}
//	private static char availData(char charData, int i, int temp) {
//		for (int j = i; j< splitData.length;j++ ) {
//		if (splitData[j] == charData &&  !(splitData[j] ==charData)) {
//			stringEndPoint = j;
//		}
//
//		}
//		return charData;
////		return 0;
//	}
//
//}
//
