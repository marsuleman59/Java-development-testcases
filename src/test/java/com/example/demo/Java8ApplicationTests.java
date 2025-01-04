package com.example.demo;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
@Author Suleman
 */

public class Java8ApplicationTests {

    public static void sortArray(char[] arrayToSort) {
        for (int i = 0; i < arrayToSort.length; i++) {
            for (int j = i + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[i] > arrayToSort[j]) {
                    char temp = arrayToSort[i];
                    arrayToSort[i] = arrayToSort[j];
                    arrayToSort[j] = temp;
                }
            }
        }
    }

    public static boolean linearCharArrayCheck(char[] strCharA, char[] strCharB) {
        for (int i = 0; i < strCharA.length; i++) {
            if (strCharA[i] != strCharB[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isCharFrequencyEqual(char[] strCharA, char[] strCharB) {

        sortArray(strCharA);
        sortArray(strCharB);

        return linearCharArrayCheck(strCharA, strCharB);

    }

    private static Stream<Arguments> inputPrimeNumbers() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(3, true),
                Arguments.of(5, true),
                Arguments.of(7, true),
                Arguments.of(11, true),
                Arguments.of(13, true),
                Arguments.of(17, true),
                Arguments.of(19, true),
                Arguments.of(23, true),
                Arguments.of(29, true),
                Arguments.of(71, true),
                Arguments.of(73, true),
                Arguments.of(79, true),
                Arguments.of(89, true),
                Arguments.of(81, false),
                Arguments.of(4, false),
                Arguments.of(9, false),
                Arguments.of(12, false),
                Arguments.of(16, false)
        );
    }

    // Get the largest and the smallest word from a given string while avoiding any special char
    @Test
    public void testRegex() {
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
    public void reverseStringWithStringBuilder() {
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
        StringBuilder stringBuilder = new StringBuilder(5);
        String data = "Water consist of both hydrogen and oxygen molecules in 2:1 proportion.";
        String[] splitData = data.split("[\\s]");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < splitData.length; i++) {
            builder.append(Character.toUpperCase(splitData[i].charAt(0))).append(splitData[i].substring(1)).append(" ");
        }
        System.out.println(builder);
    }

    @Test
    public void concat() {
        String str = "a";
        String aa = str.concat("aa");
        String newstr = aa.replace('a', 'b');
        System.out.println(newstr);
    }

    // find out the longest same character word in a given string
    @Test
    public void LongesttupleTest() {
        String data = "abbbbbbbbbbbbbbbbbbbccccccccccccc";

        HashMap<String, Integer> tupleLengthMap = new HashMap<>();

        int pointer = 0;
        for (int i = 0; i < data.length(); i++) {

            if (i + 1 < data.length() && data.charAt(i) == data.charAt(i + 1)) {
            } else {
                tupleLengthMap.put(data.substring(pointer, i + 1), data.substring(pointer, i + 1).length());
                pointer = i + 1;

            }
        }

        String longestKey = tupleLengthMap.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();

        System.out.println(longestKey);
    }

    // Getting files from files system and information using Lambda function
    @Test
    public void fileFilter() {
        FileFilter fileFilter = (File endsWith) -> endsWith.getName().endsWith(".java");
        File files = new File("/Users/suleman/Desktop");
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

    // Reverse an array algorithm
    @Test
    public void reverseAnArray2() {
        int[] oldArray = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < oldArray.length/2; i++) {

            int swap1 = oldArray[i];
            int swap2 = oldArray[oldArray.length  - i -1];

            oldArray[i] = swap2;
            oldArray[oldArray.length  - i -1] = swap1;

        }

        System.out.println(Arrays.toString(oldArray));
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

        String str = "A";
        switch (str) {
            case "a":
                System.out.println("a");
                break;
            default:
                System.out.println("def");
            case "h":
                System.out.println("A");
        }

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

//	@Test
//    public void uniqueSubStringsRoundTrip(){
//        long startTime = System.nanoTime();
//	    CodingC2.combocheck();
//        long endTime = System.nanoTime();
//        long totalTime =  (endTime - startTime) / 10000L;
//        System.out.println("RoundTrip " + totalTime + " ms");
//    }

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
    public void stringPermutation() {
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
        System.out.println(IntStream.of(1, 1, 1, 1, 1, 1, 1, 1).allMatch(value -> value / value == 1));
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
    public void doubleChar() {
        String name = "Cartoon";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            stringBuilder.append(name.charAt(i)).append(name.charAt(i));
        }
        System.out.println(stringBuilder);
    }

    @Test
    public void reverseStringWithMultipleArrays() {
        String stringToReverse = "ABCDE";
        char[] stringArray = stringToReverse.toCharArray();
        char[] newCharArray = new char[stringArray.length];
        int count = stringArray.length - 1;
        System.out.println(stringArray.length);
        for (int i = 0; i < stringArray.length; i++) {
            newCharArray[i] = stringArray[count--];
        }


//        String reversedString = stringArray.toString();
        System.out.println(ArrayUtils.toString(newCharArray));
    }

    @Test
    public void reverseStringWithSingleArrays() {
        String stringToReverse = "RestInHome";
        char[] stringArray = stringToReverse.toCharArray();
        int arrayLength = stringArray.length / 2;
        int count = stringArray.length - 1;
        for (int i = 0; i < arrayLength; i++) {
            char ch1 = stringArray[i];

            char ch2 = stringArray[count];

            stringArray[count] = ch1;
            stringArray[i] = ch2;
            count--;
        }

        System.out.println(ArrayUtils.toString(stringArray));
    }

    @Test
    public void FirstNonRepetitiveChar() {
        HashMap<Character, Integer> charCount = new HashMap<>();
        String str = "aaaabbbbcdddeeeeefgggghhhhhhijjjjkkkkkklmmmmmnnn";
        for (int i = 0; i < str.length(); i++) {
            if (!charCount.containsKey(str.charAt(i))) {
                charCount.put(str.charAt(i), 1);
            } else {
                charCount.put(str.charAt(i), charCount.get(str.charAt(i)) + 1);
            }
        }
        int count = charCount.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println(str.length() + ":actual lenght from string, " + count + ": Length from HashMap.");
        System.out.println(charCount);
        int thirdNonRep = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!(charCount.get(str.charAt(i)) > 1)) {
                thirdNonRep++;
            }
            if (thirdNonRep == 3) {
                System.out.println("Third non repetative char: " + str.charAt(i));
                break;
            }
        }
    }

    // To-do
    @Test
    public void brickProblem() {
        int small = 2;
        int large = 1;
        int goal = 8;

        if (large * 5 == goal || small == goal) {
            System.out.println("True");
        }
//        else if ((goal*5)){
//            System.out.println("Else if");
//        }

    }

    @Test
    public void evenlySpaced() {
        int a = 2, b = 4, c = 6;

        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (b > c) {
            int temp = c;
            c = b;
            b = temp;
        }

        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        System.out.println("A: " + a + " B:" + b + " C:" + c);

        if (b - a == c - b) {
            System.out.println("Evenly spaced");
        } else {
            System.out.println("Not Evenly spaced");
        }
    }

    @Test
    public void loneSum() {
        int a = 1, b = 2, c = 3;

        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }

        if (b > c) {
            int temp = c;
            c = b;
            b = temp;
        }

        if (a > b) {
            int temp = b;
            b = a;
            a = temp;
        }


        int sum = a + b + c;
        System.out.println(sum);
    }

    public void setMainComparator() {
        Comparator<String> stringComparator = (o1, o2) -> o1.compareTo(o2);

    }

    // select *

//    Emp - name- id - name - add - salary - dept
//    Man - ManId, depId

//    select e.name, e.address from Employee e left join Manager m on e.id = m.id;
//    select e.name, e.address from Employee e  right join Manager m on e.id = m.id;

//    select e.name, e.address from Employee e  full outer join Manager m on e.id = m.id;
//    select e.name, e.address from Employee e  inner join Manager m on e.id = m.id;

    // select max(salary) from Employee;

    //select max(salary) as highestSalaryWithDepartment from Employee group by deptartment;

    //select max(salary) from Employee join on (select dept from Manager group by Department);

    @Test
    public void sortWithString() {
        String sortString = "DEFA";
        String[] stringArray = {"Apple", "AirPods", "Element", "Goat", "Leap", "Integer", "Frog", "Water"};
        List<String> sortedList = new ArrayList<>();

        for (int i = 0; i < sortString.length(); i++) {
            for (int j = 0; j < stringArray.length; j++) {
                if (stringArray[j].startsWith(String.valueOf(sortString.charAt(i))) == true) {
                    sortedList.add(stringArray[j]);
                }
            }
        }

        System.out.println(sortedList);

    }

    /*Program to check if every pair of ten in a given in string starting at index 0 has exactly 3 "?(Question marks)".
    String size not multiple of 10 expected.
    Minimum String size 10.
    */
    @Test
    public void tenPair() {
//        String s = "jhkj?fenm?kjshdf?sldkfj???lskdf";
        String s = "123?567???";
        int pairSeqCount = s.length() % 10;

        System.out.println("Excluding " + (pairSeqCount - 1) + " count from the given string to make pairs of 10");

        int count = 0, pair = 0;
        boolean check = false;
        for (int i = 0; i < (s.length() - pairSeqCount); i++) {
            pair++;

            if (String.valueOf(s.charAt(i)).equals("?")) {
                count++;
            }

            if (pair == 10 && (count < 3 && count > 3)) {
                check = false;

                System.out.println("String is: " + check);
                return;
            } else if (pair == 10 && count == 3) {
                check = true;
                pair = 0;
                count = 0;
            }

        }
        System.out.println("String is: " + check);
    }

    // Integer parser
    @Test
    public void parseInteger() {
        Integer num1 = 12349876;
        int length = num1.toString().length();
        Integer[] numerParsedList = new Integer[length];
        int listIndex = length - 1;
        while (num1 > 10) {
            int modValue = num1 % 10;
            num1 = (num1 / 10);
            numerParsedList[listIndex--] = modValue;
        }
        numerParsedList[0] = num1;

    }

//    @Test
//    public void scanner(){
//        Scanner scanner = new Scanner(System.in);
//        int nextInt = scanner.nextInt();
//        scanner.re
//        String line = scanner.nextLine();
//    }

    @Test
    public void shrinkArrayWithTarget() throws IOException {


        long nanoTime = System.nanoTime();
        int index = 0;
        String target = "a";
        String[] words = {"a", "a", "a", "a", "b", "c", "a"};
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(target))
                integers.add(i);
        }

        String[] array1 = new String[integers.size()];

        Iterator<Integer> integerIterator = integers.iterator();

        while (integerIterator.hasNext()) {
            array1[index++] = words[integerIterator.next()];
        }

        System.out.println("Debug pointer");
        long nanoTime1 = System.nanoTime();
        long elapsedTime = nanoTime1 - nanoTime;

        double elapsedTimeInSecond = (double) elapsedTime / 1_000_000_000;
//        System.out.println("Time taken in seconds: "+elapsedTimeInSecond);

        long convert = TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);

        System.out.println(convert + " seconds");
    }

    @Test
    public void stringReference() {
        String str1 = "abc";
        String str2 = "abc";

        if (str1 == str2 && str1.equals(str2)) {
            System.out.println("Are equal");
        } else {
            System.out.println("Not equal");
        }
    }

    @Test
    public void hackerTest() {
        int x = 3 & 5;
        int y = 3 | 5;
        System.out.println(x);
        System.out.println(y);

    }

    @Test
    public void primeFactorsWithMathPOW() {

        int low = 6;
        int high = 222220;

        long count = 0;
        double multiplePair = 0;

        double powi = 0;
        double powj;

//        int hitCountJ = 0;
//        int hitCountI = 0;

        int hitBreak = 1;

        while (hitBreak < high) {
            hitBreak = hitBreak * 3;
        }

        for (int i = 0; powi < hitBreak; i++) {
            powi = Math.pow(3, i);
            multiplePair = 0;
//            hitCountI++;
            for (int j = 0; multiplePair < high; j++) {

                powj = Math.pow(5, j);
                multiplePair = powi * powj;
//                hitCountJ++;
                if (multiplePair >= low && multiplePair <= high) {
                    count++;
                }
            }
        }
        System.out.println(count);
//        System.out.println("Hit count I:" + hitCountI + " & hit count J: " + hitCountJ);

    }

    @Test
    public void removeDuplicatesFromArray1() {
        int[] integers = {1, 2, 5, 7, 4, 6, 4, 4, 2, 2, 2, 4, 3, 2, 2, 2, 2};
        Set<Integer> integerSet = new HashSet<>();

        for (int number : integers) {
            integerSet.add(number);
        }

        System.out.println(integerSet);

    }

    @Test
    public void permutationString() {
        String str = "abcde";

        Set<String> stringsPermutation = new HashSet<>();

        for (int i = 0; i < (str.length() - 1); i++) {
            for (int j = 0; j > i; j++) {
                stringsPermutation.add(str.substring(i, j));
            }
        }

        System.out.println(stringsPermutation);

    }

    @Test
    public void almostEqualLists() {
        List<String> stringList1 = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();

        //Yes
        stringList1.add("aaabbc");
        stringList2.add("cccbba");

        //No
        stringList1.add("cccccccba");
        stringList2.add("cccbba");

        //Yes
        stringList1.add("");
        stringList2.add("");

        //No
        stringList1.add("a");
        stringList2.add("d");


        int sizeList1 = stringList1.size();
        int sizeList2 = stringList2.size();
        List<String> finalResult = new ArrayList<>(sizeList1);

        if (sizeList1 != sizeList2) {
            return;
        }


        for (int i = 0; i < sizeList1; i++) {
            String str1 = stringList1.get(i);
            String str2 = stringList2.get(i);

            HashMap<Character, Integer> charCountMap1 = new HashMap<>();
            HashMap<Character, Integer> charCountMap2 = new HashMap<>();

            //Adding all char's to hash map with initial value 0
//            IntStream.rangeClosed((int) 'a', (int) 'z')
//                    .forEach(ch -> charCountMap1.put((char) ch, 0));
//
//            charCountMap2.putAll(charCountMap1);

            for (int j = 0; j < str1.length(); j++) {
//                int count = charCountMap1.get(str1.charAt(j));
                if (charCountMap1.containsKey(str1.charAt(j))) {
                    charCountMap1.put(str1.charAt(j), charCountMap1.get(str1.charAt(j)) + 1);
                } else {
                    charCountMap1.put(str1.charAt(j), 1);
                }

            }

            for (int j = 0; j < str2.length(); j++) {
                if (charCountMap2.containsKey(str2.charAt(j))) {
                    charCountMap2.put(str2.charAt(j), charCountMap2.get(str2.charAt(j)) + 1);
                } else {
                    charCountMap2.put(str2.charAt(j), 1);
                }
            }

            if (charCountMap1.keySet().equals(charCountMap2.keySet())) {

                Optional<Map.Entry<Character, Integer>> first = charCountMap1.entrySet().stream()
                        .filter(entry -> (Math.abs(charCountMap2.get(entry.getKey()) - entry.getValue()) > 3))
                        .findFirst();

                if (first.isPresent()) {
                    finalResult.add("NO");
                } else {
                    finalResult.add("YES");
                }

            } else {
                finalResult.add("NO");
            }

        }
        System.out.println(finalResult);
    }

    @Test
    public void collectionStream() throws CloneNotSupportedException {
        List<Employee1> stringList = new ArrayList<>();

        stringList.add(new Employee1("Suleman", 1, 25));
        stringList.add(new Employee1("Mohammed", 2, 35));
        stringList.add(new Employee1("Deepak", 3, 28));
        stringList.add(new Employee1("Deepak", 3, 28));

        List<Employee1> stringListClone = (List<Employee1>) ((ArrayList<Employee1>) stringList).clone();


        System.out.println("Before sorting: " + stringList);
        Collections.sort(stringList, (o1, o2) -> o1.getAge() - o1.getAge());

        List<Employee1> sortCollector = stringList.stream().sorted(Comparator.comparing(Employee1::getAge)).collect(Collectors.toList());

        System.out.println("After sorting: " + sortCollector);

        List<Employee1> collectDistinctString = sortCollector.stream().distinct().collect(Collectors.toList());
        System.out.println("Distinct elements: " + collectDistinctString);

        List<String> dep = collectDistinctString.stream().map(Employee1::getName).filter(s -> s.indexOf("Dee") != -1).collect(Collectors.toList());
        System.out.println("Object containing Dep: " + dep);


        List<Employee1> collect = stringListClone.stream().distinct().collect(Collectors.toList());
        System.out.println("Clonned list: " + collect + " size of new list: " + collect.size());

        Integer integer = stringListClone.stream()
                .mapToInt(employee1 -> employee1.getID())
                .reduce((i1, i2) -> i1 + i2)
                .orElse(0);

        System.out.println(integer);

    }

    @Test
    public void mathMethods() {

        Map<String, String> stringMap1 = new HashMap<>();
        Map<String, String> stringMap2 = new HashMap<>();

        stringMap1.put("Student", "Suleman");
        stringMap1.put("Student", "Mohammed");
        stringMap2.put("Student", "Suleman");
        stringMap2.put("Teacher", "Mohammed");

        boolean present = stringMap1.entrySet().stream().filter(val -> stringMap2.entrySet().stream().anyMatch(val1 -> (val1.getKey().equals(val.getKey())))).findFirst().isPresent();

        System.out.println(present);
        System.out.println(Math.round(1.5d));
        int x = 3 & 5;
        int y = 3 | 5;
        System.out.println(x + " - " + y);
    }

    @Test
    public void computeIfAbsetMapTest() {
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.put(1, "5");
        String s1 = stringMap.computeIfPresent(1, (integer, s) -> String.valueOf(Math.pow(Integer.parseInt(s), 2)));
        System.out.println(s1);
    }

    @Test
    public void comparator() {
        List<String> strings = new ArrayList<>();
        strings.add("12");
        strings.add("ENTER John 3.75 50");
        strings.add("ENTER Mark 3.8 24");
        strings.add("ENTER Shafaet 3.7 35");
        strings.add("SERVED");
        strings.add("SERVED");
        strings.add("ENTER Samiha 3.85 36");
        strings.add("SERVED");
        strings.add("ENTER Ashley 3.9 42");
        strings.add("ENTER Maria 3.6 46");
        strings.add("ENTER Anik 3.95 49");
        strings.add("ENTER Dan 3.95 50");
        strings.add("SERVED");
        ArrayList<Student> students = getStudents(strings);
        students.stream().map(Student::getName).forEach(System.out::println);
    }

    public ArrayList<Student> getStudents(List<String> events) {
        PriorityQueue<Student> pQueue = new PriorityQueue(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID));
//        PriorityQueue<Student> pQueue1 = new PriorityQueue<>(Comparator.comparing(Student::getCGPA).reversed().thenComparing(Student::getName).thenComparing(Student::getID)) ;

        for (int i = 0; i < events.size(); i++) {

            if (events.get(i).contains("ENTER")) {
                String student = events.get(i);
                String[] studentAttr = student.split(" ");
                pQueue.add(new Student(studentAttr[1], Double.valueOf(studentAttr[2]), Integer.valueOf(studentAttr[3])));
            } else if (events.get(i).contains("SERVED")) {
                pQueue.poll();
                System.out.print("");
            }
        }

        return new ArrayList(pQueue);
    }

    @Test
    public void anagram() {
        String a = "Listen";
        String b = "silent";


        char[] StringA = a.toLowerCase().toCharArray();
        char[] StringB = b.toLowerCase().toCharArray();

        isCharFrequencyEqual(StringA, StringB);

    }


    @Test
    public void programTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> System.out.println("Sounds good"));

        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executorService.submit(runnable);
        executorService.execute(runnable);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        CompletableFuture<String> future = new CompletableFuture<>();
    }

    @Test
    public void midArray() {
        int length = 0;
        int[] numbers = {1, 2, 3, 4, 5, 6};

        for (int num : numbers) {
            length++;
        }

//        System.out.println("Length: "+length);

        if (length % 2 == 0) {
            System.out.println("mid elements : " + numbers[length / 2] + ", " + numbers[(length - 1) / 2]);

        } else
            System.out.println("mid element : " + numbers[(length + 1) / 2]);
    }


    @Test
    public void subStringNonDuplicateCount() {
        String str = "starwars";
        Set<String> subStrings = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            String tempString = new String(str.substring(0, i));

            char[] chars = tempString.toCharArray();
            Set<Character> characters = new HashSet<>();
            for (int j = 0; i < chars.length; i++) {
                if (characters.contains(chars[j])) {
                    int subStringNonRep = j - 1;
                    break;
                } else
                    characters.add(chars[j]);

            }
            subStrings.add(tempString);
        }

        System.out.println("Total non rep. char strings" + subStrings.size());
    }


    @Test
    public void test() {
        int[] numbers = {1, -2, 4, -5, 1};

        int n = numbers.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    int[] copyOfRange = Arrays.copyOfRange(numbers, i, k);
//                    System.out.println(Arrays.toString(copyOfRange));
                    System.out.print(numbers[k] + " ");
                }
                System.out.println();
            }
        }
    }


    @Test
    public void comparatorTest() {
        List<String> strings = new ArrayList<>();

        strings.add("Abdul");
        strings.add("Basith");
        strings.add("Chandan");
        strings.add("Dawood");
        strings.add("Elf");
        strings.add("Zebra");

        strings.sort(Comparator.comparingInt(String::length));
    }

    @Test
    public void loops() {
        int[] numbers = {1, 2, 3, 4, 5};

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i; j <= numbers.length; j++) {

                int[] copyOfRange = Arrays.copyOfRange(numbers, i, j);
                if (copyOfRange.length != 0) {
                    System.out.println(Arrays.toString(copyOfRange) + " :: " + Arrays.stream(copyOfRange).sum());
                }
            }
        }
    }

    @Test
    public void panagramCheckTest() {
        String data = "The quick brown fox jumps over the lazy dog";
        String dataWithOnlyChar = data.replaceAll("[^a-zA-Z]", "");
        char[] splitData = dataWithOnlyChar.toLowerCase().toCharArray();
        Set<Character> splitDataSet = new HashSet<>();
        System.out.println(splitDataSet.size() + ": Size: " + splitDataSet);
        for (char ch : splitData) {
            splitDataSet.add(Character.valueOf(ch));
        }
        System.out.println(splitDataSet.size() + ": Size: " + splitDataSet);
        System.out.println(String.format("Size of set: [%d] ", splitDataSet.size()));
    }

    @Test
    public void boxingTest() {
        char a = 'a';
        Character.valueOf(a);
    }

    @Test
    public void panagramCheckTest3() {
        String data = "The quick brown fox jumps over the !lazy dog";
        String replace = data.replaceAll("[^a-zA-Z]", "").toUpperCase();
        System.out.println(replace);
        char[] charArray = new char[26];
        for (int i = 0; i < replace.length(); i++) {
            int ch = (int) replace.charAt(i);
            charArray[ch - 65] = replace.charAt(i);
        }

    }

    @Test
    public void string1() {
        String str = "Suleman";
        int n = 2;

        String front = "";
        if (str.length() >= 3) {
            front = str.substring(0, 3);
        } else {
            front = str;
        }

        String returnString = "";

        for (int i = 0; i < n; i++) {
            returnString += front;
        }

        int[] nums = new int[4];
        System.out.println(nums.length);

    }

    @Test
    public void linkedListTest() {
        LinkedList<String> linkedStrings = new LinkedList<>();
        System.out.println("Size of linked list: " + linkedStrings.size());
        linkedStrings.add("Mohammed");
        System.out.println("Size of linked list: " + linkedStrings.size());
        final boolean suleman = linkedStrings.add("Abdul");
        System.out.println("Trying to add the String 'Suleman' again. Status added: " + suleman);
        System.out.println("Size of linked list: " + linkedStrings.size());

        linkedStrings.add("Rasheed");
        linkedStrings.add("Suleman");

        Iterator iterator = linkedStrings.iterator();

        int counter = 0;
        while (iterator.hasNext()) {
            System.out.println("Printing node: " + counter++);
            final String next = (String) iterator.next();
            System.out.println(next);
        }

    }

    @ParameterizedTest
    @MethodSource("inputPrimeNumbers")
    public void primeNumberCheck(int inputNumber, boolean expectedResult) {
        boolean isPrimeNumber = true;

        if (inputNumber == 0 || inputNumber == 1) {
            isPrimeNumber = false;
        }

        if (inputNumber == 2) {
            isPrimeNumber = true;
        } else {

            for (int i = 2; i <= Math.sqrt(inputNumber); i++) {
                if (inputNumber % i == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }
        }

        System.out.println("Prime number check " + inputNumber + " is " + isPrimeNumber);
        Assertions.assertEquals(expectedResult, isPrimeNumber);
    }

    class Student {
        int id;
        String name;
        double cgpa;

        Student(String name, double cgpa, int id) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", cgpa=" + cgpa +
                    '}';
        }

        public double getCGPA() {
            return cgpa;
        }
    }

}
