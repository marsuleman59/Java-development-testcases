package com.example.demo;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class JavaCoding2Test {

    public static Stream<Arguments> testGenerateExcelInput() {

        return Stream.of(
                Arguments.of(26, "Z"),
                Arguments.of(27, "AA"),
                Arguments.of(52, "AZ"),
                Arguments.of(0, ""),
                Arguments.of(1, "A"),
                Arguments.of(104, "CZ"),
                Arguments.of(27, "AA"),
                Arguments.of(28, "AB"),
                Arguments.of(52, "AZ"),
                Arguments.of(53, "BA"),
                Arguments.of(78, "BZ"),
                Arguments.of(79, "CA"),
                Arguments.of(104, "CZ"),
                Arguments.of(677, "ZA"));
    }

    @ParameterizedTest
    @MethodSource("testGenerateExcelInput")
    public void testGenerateExcelString(int number, String expected) {
        StringBuilder column = new StringBuilder();


        while (number > 0){

            number--;
            int remainder = number % 26;

            column.insert(0, (char) (65 + remainder));

            number = number / 26;
        }

    Assertions.assertEquals(expected, column.toString());
    }


}
