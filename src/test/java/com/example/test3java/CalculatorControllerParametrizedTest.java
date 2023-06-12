package com.example.test3java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static com.example.test3java.NumbersClass.*;
import static com.example.test3java.NumbersClass.NUM_ZERO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorControllerParametrizedTest {
    private CalculatorController cc;
    private CalculatorService cs;

    @BeforeEach
    public void setUp() {
        cs = new CalculatorService();
        cc = new CalculatorController(cs);
    }

    @Test
    public void helloTest() {
        String actual = cc.hello();
        String expected = "<h1>Приветствую в калькуляторе</h1>";
        assertEquals(actual, expected);
    }

    public static Stream<Arguments> provideParamsForTheTests() {
        return Stream.of(
                Arguments.of(NUM1, NUM2),
                Arguments.of(NUM3, NUM4)
        );
    }

    public static Stream<Arguments> provideParamsForTheDivideNullTests() {
        return Stream.of(
                Arguments.of(NUM1, NUM_ZERO),
                Arguments.of(NUM3, NUM_ZERO)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void isPlusWorkParametrizedTest(double num1, double num2) {
        String actual = cc.plus(num1, num2);
        String expected = "<h1>" + num1 + " + " + num2 + " = " + (num1 + num2) + "</h1>";
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void isMinusWorkParametrizedTest(double num1, double num2) {
        String actual = cc.minus(num1, num2);
        String expected = "<h1>" + num1 + " - " + num2 + " = " + (num1 - num2) + "</h1>";
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void isMultiplyWorkParametrizedTest(double num1, double num2) {
        String actual = cc.multiply(num1, num2);
        String expected = "<h1>" + num1 + " x " + num2 + " = " + (num1 * num2) + "</h1>";
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void isDivideWorkParametrizedTest(double num1, double num2) {
        String actual = cc.divide(num1, num2);
        String expected = "<h1>" + num1 + " : " + num2 + " = " + (num1 / num2) + "</h1>";
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheDivideNullTests")
    public void divideWithExceptionParametrizedTest(double num1, double numZero) {
        assertThrows(RuntimeException.class, () -> cc.divide(num1, numZero));
    }
}
