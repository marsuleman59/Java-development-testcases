package com.example.demo;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
@Author Suleman
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Java8ApplicationTests {

    // Get the largest and the smallest word from a given string while avoiding any special char
    @Test
    public void contextLoads() {
        String data = "This-adis-Suleman &&&&&&&&& 0843u%-- suleman as;lkfnasdf asdf-as-df-asdf-asdf-";
//		String[] splitData = data.toLowerCase().split("[^a-zA-Z0-9]");
        String[] splitData = data.toLowerCase().split("\\s*[^a-zA-Z]+\\s*");
        System.out.println("Array to String: " + Arrays.toString(splitData));
        String largest = Arrays.stream(splitData).max(Comparator.comparingInt(String::length)).orElse(null);
        String smallest = Arrays.stream(splitData).min(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println("largest: " + largest + " Smallest: " + smallest);
        Assert.assertEquals("lkfnasdf", largest);
        Assert.assertEquals("u", smallest);
    }

    // Reversing a given string
    @Test
    public void reverseString() {
        String name = "Bottle is blue";
        String reverString = new StringBuilder(name).reverse().toString();
        System.out.println(reverString);
    }

    // check if the string is palindrome
    @Test
    public void palindromeCheck() {
        String name = "madam";
        String reverString = new StringBuilder(name).reverse().toString();
        boolean result = name.equalsIgnoreCase(reverString);
        System.out.println(result);
        System.out.println(reverString);
    }

    // check if two given Strings are anagram
    @Test
    public void checkAnagram() {
        String letter1 = "mynameismadam";
        String letter2 = "madamsiemanyM";
        char[] letter1Array = letter1.toLowerCase().toCharArray();
        char[] letter2Array = letter2.toLowerCase().toCharArray();
        Arrays.sort(letter1Array);
        Arrays.sort(letter2Array);
        System.out.println(Arrays.toString(letter1Array) + " - " + Arrays.toString(letter2Array));
        boolean equalCheck = Arrays.equals(letter1Array, letter2Array);
        System.out.println(equalCheck);
    }

    // Print a substring out of a headString
    @Test()
    public void subString() {
        String headString = "abcde";
        int head = 0, tail = 3;
        String subString = headString.substring(head, tail);
        System.out.println(subString);
    }

    // Capitalize each word in a given String
    @Test
    public void subString2() {
        StringBuilder stringBuilder = new StringBuilder();
        String data = "Water consist of both hydrogen and oxygen molecules in 2:1 proportion.";
        String[] splitData = data.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splitData.length; i++) {
            builder.append(Character.toUpperCase(splitData[i].charAt(0))).append(splitData[i].substring(1)).append(" ");
        }
        System.out.println(builder);
    }

    //Ignore this test case
    // find out the longest same character word in a given string
    @Test
    public void LongesttupleTest() {
        String data = "aaaaaabbbbccca";
        char[] dataArray = data.toCharArray();
        Arrays.sort(dataArray);
        System.out.println(Arrays.toString(dataArray));
        HashMap<String, Integer> elementCount = new HashMap<>();

        for (char ch : dataArray) {
            if (elementCount.containsKey(Character.toString(ch)))
                elementCount.put(Character.toString(ch), elementCount.get(Character.toString(ch)) + 1);
            else elementCount.put(Character.toString(ch), 1);
        }
        System.out.println(elementCount);
        String key = elementCount.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
        String value = String.valueOf(elementCount.get(key));
        final int indexOf = data.indexOf(key);
        System.out.println("Key: " + key + " Value :" + value + " is the longest tuple in String :" + data + " at index: " + indexOf);
    }

    // Getting files from files system and information using Lambda function
    @Test
    public void fileFilter() {
        FileFilter fileFilter = (File endsWith) -> endsWith.getName().endsWith(".java");
        File files = new File("D:/tmp");
        File[] fileArray = files.listFiles(fileFilter);
        Comparator<File> fileComparator = Comparator.comparingInt(s -> s.getName().length());
        Arrays.sort(fileArray, fileComparator);
        Arrays.stream(fileArray).forEach(file -> System.out.println("File name: " + file + "Last modified: " + file.lastModified()));

    }

    // Sort and store any entity with multiple criteria's
    @Test
    public void sortEmployee() {
        Employee employee1 = Employee.builder().ID("12").name("Suleman").build();
        Employee employee2 = Employee.builder().ID("83").name("Abdul").build();
        Employee employee3 = Employee.builder().ID("54").name("Rasheed").build();
        Employee employee4 = Employee.builder().ID("25").name("Mohammed").build();
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        Collections.sort(employees, Comparator.comparing(Employee::getID).thenComparing(Employee::getName));
        System.out.println(employees);
    }

    // Reverse an array algorithm
    @Test
    public void reverseAnArray() {
        int[] oldArray = {1, 2, 3, 4, 5, 6, 9};
        System.out.println(Arrays.toString(oldArray));
        int[] newArray = new int[oldArray.length];
        int j = newArray.length;
        for (int i = 0; i < oldArray.length; i++) {
            newArray[j - 1] = oldArray[i];
            j = j - 1;
        }
        System.out.println(Arrays.toString(newArray));
    }

    //Find the first repeating Character in a given string
    @Test
    public void firstRepeatedCharacter() {
        String data = "abcda";
        String dataWithNospaces = data.replaceAll("\\s+", "");
        char[] dataCharacters = dataWithNospaces.toCharArray();
        System.out.println(Arrays.toString(dataCharacters));
        HashMap<Character, Character> charPool = new HashMap();
        Character repeat = null;
        for (Character ch : dataCharacters) {
            if (charPool.containsKey(ch)) {
                repeat = ch;
                break;
            } else {
                charPool.put(ch, ch);
            }
        }
        System.out.println(repeat);
        Assert.assertEquals("a", Character.toString(repeat));
    }

    //Encode a given String
    @Test
    public void characterCountEnCoding() {
        String data = "aaaabbbccd"; // Encode the given string in the format - a4b3c2d1
        char[] splitCharData = data.toCharArray();
        System.out.println(Arrays.toString(splitCharData));
        HashMap<Character, Integer> charPool = new HashMap<>();
        for (char ch : splitCharData) {
            if (charPool.containsKey(Character.valueOf(ch))) {
                charPool.put(Character.valueOf(ch), charPool.get(Character.valueOf(ch)) + 1);
            } else {
                charPool.put(Character.valueOf(ch), 1);
            }
        }
        System.out.println(charPool);
        StringBuilder encodingBuilder = new StringBuilder();
        charPool.forEach((k, v) -> encodingBuilder.append(k).append(v));
        System.out.println("Encoded value for: " + data + ": " + encodingBuilder);
        Assert.assertEquals("a4b3c2d1", encodingBuilder.toString());
    }

    // return all such pair whose sum is a given target number
    @Test(timeout = 180)
    public void targetPairSummation() {
        Integer[] splitPairs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 11, 13, 14, 15};
        int targetSummation = 8;
        StringBuilder pairs = new StringBuilder();
        for (int i = 0; i < splitPairs.length; i++) {
            for (int j = 0; j < splitPairs.length; j++) {
                if (splitPairs[i] + splitPairs[j] == targetSummation && !(i == j)) {
                    pairs.append("Pair(").append(splitPairs[i]).append(",").append(splitPairs[j]).append(")").append("-");
                }
            }
        }
        System.out.println(pairs);
    }

    //	second Largest And Smallest Number In An Array
    @Test
    public void secondLargestAndSmallestNumberInAnArray() {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 11, 13, 14, 15};
        Arrays.sort(data);
        System.out.println(Arrays.toString(data));
        Integer secondSmallest = data[1];
        Integer secondLargest = data[data.length - 2];
        System.out.println(data.length);
        Assert.assertEquals(Integer.valueOf(2), secondSmallest);
        Assert.assertEquals(Integer.valueOf(14), secondLargest);
    }

    //Missing panagrams from a sentence
    @Test
    public void MissingPanagramCharCheck() {
        String data = "abcd";
//		Character[] aaa = data.chars().mapToObj(c-> (char)c).toArray(Character[]::new);
//		System.out.println(Arrays.toString(aaa));
//		String data = "The quick brown fox jumps over the lazy do";
        String removeSpacesData = data.replaceAll("\\s+", "");
        Character[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] stringAlphabets = removeSpacesData.toLowerCase().toCharArray();
        Character[] stringCharacter = ArrayUtils.toObject(stringAlphabets);
        Set<Character> standardCharacters = new HashSet<>();
        Set<Character> missingStringCharacters = new HashSet<>();
        Collections.addAll(standardCharacters, alphabets);
        Collections.addAll(missingStringCharacters, stringCharacter);
        standardCharacters.removeAll(missingStringCharacters);
        System.out.println(standardCharacters + "-Missing Char count: " + standardCharacters.size());
        Assert.assertEquals(standardCharacters.size(), 22);
    }

    @Test
    public void panagramCheck() {
        String data1 = "The quick brown fox jumps over the lazy dog";
        String data = data1.toLowerCase();
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z') {
                characters.add(data.charAt(i));
            }
        }
        String result = characters.size() == 26 ? "true" : "false";
        System.out.println("Given sentence has all characters: " + result);
    }

    @Test
    public void panagramMissingChar() {
        String data1 = "";
        String data = data1.toLowerCase();
        boolean[] missingChar = new boolean[26];
        StringBuilder missingCharsString = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) >= 'a' && data.charAt(i) <= 'z') {
                missingChar[data.charAt(i) - 'a'] = true;
            }
        }
        for (int i = 0; i < missingChar.length; i++) {
            if (missingChar[i] == false) {
                missingCharsString.append(Character.toChars(i + 'a'));
            }
        }
        System.out.println(missingCharsString);
    }

    // Remove duplicates from array
    @Test
    public void removeDuplicatesFromArray() {
        Integer[] numbersArray = {1, 2, 3, 1, 2, 3};
        HashSet<Integer> integerHashSet = new HashSet<>();
        Collections.addAll(integerHashSet, numbersArray);
        System.out.println(integerHashSet);
        Assert.assertEquals(3, integerHashSet.size());
    }

    @Test
    public void fibonacciSeries() {
        int maxNumber = 10;
        int previousNumber = 0;
        int nextNumber = 1;
        System.out.print("Fibonacci Series of " + maxNumber + " numbers:");
        for (int i = 1; i <= maxNumber; i++) {
            System.out.print(previousNumber + " ");
            /* On each iteration, we are assigning second number
             * to the first number and assigning the sum of last two
             * numbers to the second number
             */
            int sum = previousNumber + nextNumber;
            previousNumber = nextNumber;
            nextNumber = sum;
        }
    }

    @Test
    public void asd() {
        String[] arr = {"A", "B", "C", "D"};
        int n = arr.length;
        int N = (int) Math.pow(2d, Double.valueOf(n));
        for (int i = 1; i < N; i++) {
            String code = Integer.toBinaryString(N | i).substring(1);
            for (int j = 0; j < n; j++) {
                if (code.charAt(j) == '1') {
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }

    @Test
    public void asdasd() {
        String s = "satel";
        StringBuilder temp = new StringBuilder(s);

        for (int i = 0; i < temp.length(); i++) {
            for (int j = i; j <= temp.length(); j++) {
                System.out.println(temp.subSequence(i, j));
                if (temp.subSequence(i, j).length() > 1) {
                    System.out.println(new StringBuilder(temp.subSequence(i, j).toString()).reverse());
                }
            }
        }
    }

    @Test
    public void dfg() {
        StringBuilder temp = new StringBuilder("abcd");
        System.out.println(temp.subSequence(0, 3));

    }

//	@Test
//    public void uniqueSubStringsRoundTrip(){
//        long startTime = System.nanoTime();
//	    CodingC2.combocheck();
//        long endTime = System.nanoTime();
//        long totalTime =  (endTime - startTime) / 10000L;
//        System.out.println("RoundTrip " + totalTime + " ms");
//    }

    @Test
    public void addOneToTheArray() {
        int[] numbers = {0, 9, 9, 9, 5, 9, 9, 9, 9};
        int newArrayLenth;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            stringBuilder.append(numbers[i]);
        }
        int addedOneToInteger = Integer.parseInt(stringBuilder.toString()) + 1;
        String stringAddOn = String.valueOf(addedOneToInteger);
        char[] newArray = stringAddOn.toCharArray();
        if (numbers.length == newArray.length)
            newArrayLenth = numbers.length;
        else
            newArrayLenth = (numbers.length) + 1;
        int[] newNumbers = new int[newArrayLenth];
        for (int i = 0; i < newArray.length; i++) {
            newNumbers[i] = Character.getNumericValue(newArray[i]);
        }
        System.out.println(Arrays.toString(newNumbers));

    }

    @Test
    public void ifElse() {
        int a = 2, b = 3;
        if (a == 2)
            System.out.println("3333");
        if (b == 3)
            System.out.println("========================");
        else
            System.out.println("###################");
        System.out.println("&&&&&&&&&&&&&&&&&&");
    }

    @Test
    public void streamTest() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        String data = "Water consist of both hydrogen and oxygen molecules in 2:1 proportion.";
        String[] list1 = data.split(" ");
        String integerStream = Arrays.stream(list1).map(i -> atomicInteger.incrementAndGet() % 2 == 0 ? i : i.toUpperCase()).collect(Collectors.joining(" "));
        System.out.println(integerStream);
        System.out.println(atomicInteger);
        System.out.println(IntStream.rangeClosed(0, 5).average().getAsDouble());
        System.out.println(IntStream.of(1, 0, 1, 1, 1, 1, 1, 1).allMatch(value -> value / value == 1));
    }

    @Test
    public void largestWordUsingINTStream() {
        String data = "Water consist of both hydrogen and oxygen molecules in 2:1 proportion.";
        System.out.println(Arrays.stream(data.split(" ")).max(Comparator.comparingInt(String::length)).get());
    }

    @Test
    public void InteStream() {
        final Stream<Integer> intStream = IntStream.of(1).boxed();
        System.out.println(intStream);
    }

    @Test
    public void parallelStream() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            integerList.add(i);
        }
        Stream<Integer> seqStream = integerList.stream();
        Stream<Integer> parallelStream = integerList.parallelStream();
        Stream<Integer> intSeqStream = seqStream.filter(i -> i > 90);
        intSeqStream.forEach(i -> System.out.println("Sequential Stream: " + i));
        System.out.println("*********************************");
        Stream<Integer> parallelStreamIntegers = parallelStream.filter(i -> i > 90);
        parallelStreamIntegers.forEach(i -> System.out.println("Parallel Stream: " + i));
    }

    @Test
    public void intStream1() {
        Stream<Integer> integerStream = IntStream.rangeClosed(1, 11111).boxed();
        List<Integer> collect = integerStream.collect(Collectors.toList());
        System.out.println(
                collect.parallelStream().max(Integer::compareTo).get());
    }

    @Test
    public void forLoop() {
        int i = 15;
        for (int n = 1; i <= i; i++) {
            if (n % 3 == 0 && n % 5 == 0) {
                System.out.println("fizzBuzz");
            } else if (n % 3 == 0 && !(n % 5 == 0)) {
                System.out.println("Fizz");
            } else if (!(n % 3 == 0) && n % 5 == 0) {
                System.out.println("Buzz");
            } else
                System.out.println(n);
        }
    }

    @Test
    public void XPath() {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
    }

    @Test
    public void newGen() {
        ArrayList<String> stringsList = new ArrayList<>();
        Thread thread = new Thread();
        stringsList.add("ykc 82 01");
        stringsList.add("eo first qpr cdd");
        stringsList.add("09z cat hamster");
        stringsList.add("06f 12 25 6");
        stringsList.add("az0 first");
        stringsList.add("236 mat dog rabbit snake");
        ArrayList<String[]> oldGenArrayList = new ArrayList<>();
        LinkedHashMap<Integer, String> mapData = new LinkedHashMap<>();
        for (int i = 0; i < stringsList.size(); i++) {
            String[] stringSplitArray = stringsList.get(i).split("\\s+");
            if (stringSplitArray[1].charAt(0) >= 'a' && stringSplitArray[1].charAt(0) <= 'z') {
                oldGenArrayList.add(stringSplitArray);
            } else {
                mapData.put(stringSplitArray.length, stringSplitArray.toString());
            }
        }
        Comparator<String[]> comparator = Comparator.comparingInt(value -> value.length);
        Comparator<String[]> comparator2 = Comparator.comparingInt(o -> o[1].charAt(0));
        oldGenArrayList.sort(comparator.thenComparing(comparator2));
//        Collections.reverseOrder(comparator.thenComparing(comparator2));
//        oldGenArrayList.sort(Comparator.comparingInt((String)value -> value.length).thenComparing((String[])o -> o[1].charAt(0)));
        oldGenArrayList.forEach(strings -> System.out.println(Arrays.toString(strings)));
    }


    @Test
    public void leastDiff() {
        int[] ints = {5, 25, 100, 26, 190};
        int pair1 = 0;
        int pair2 = 0;
        Arrays.sort(ints);
        int leastDifference = ints[ints.length - 1];
        System.out.println(Arrays.toString(ints));
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i + 1] - ints[i] < leastDifference) {
                leastDifference = ints[i + 1] - ints[i];
                pair1 = i;
                pair2 = i + 1;
            }
        }
        System.out.println("leastDifference::" + leastDifference);
        System.out.println("Index of pair is " + pair1 + "," + pair2);
    }

    @Test
    public void doubleChar(){
        String name = "Cartoon";
        StringBuilder  stringBuilder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            stringBuilder.append(name.charAt(i)).append(name.charAt(i));
        }
        System.out.println(stringBuilder);
    }

    @Test
    public void FirstNonRepetitiveChar(){
        HashMap<Character,Integer> charCount = new HashMap<>();
        String str = "aaaabbbbcdddeeeeefgggghhhhhhijjjjkkkkkklmmmmmnnn";
        for (int i = 0; i < str.length(); i++) {
            if (!charCount.containsKey(str.charAt(i))){
                charCount.put(str.charAt(i), 1);
            }
            else {
                charCount.put(str.charAt(i),charCount.get(str.charAt(i))+1);
            }
        }
        int count = charCount.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(str.length() + ":actual lenght from string, " +count+ ": Length from HashMap.");
        System.out.println(charCount);
        int thirdNonRep = 0;
        for (int i = 0; i < str.length(); i++) {
                if (!(charCount.get(str.charAt(i)) > 1)) {
                    thirdNonRep++;
                }
            if (thirdNonRep == 3) {
                System.out.println("Third non repetative char: "+str.charAt(i));
                break;
            }
        }
        
        
        
    }


}
