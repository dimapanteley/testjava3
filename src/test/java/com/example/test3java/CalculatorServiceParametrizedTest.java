package com.example.test3java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.example.test3java.NumbersClass.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceParametrizedTest {
    private CalculatorService cs;

    @BeforeEach
    public void sutUp() {
        cs = new CalculatorService();
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
    public void plusParametrizedTest(double num1, double num2) {
        double actual = cs.plus(num1, num2);
        double expected = num1 + num2;
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void minusParametrizedTest(double num1, double num2) {
        double actual = cs.minus(num1, num2);
        double expected = num1 - num2;
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void multiplyParametrizedTest(double num1, double num2) {
        double actual = cs.multiply(num1, num2);
        double expected = num1 * num2;
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheTests")
    public void divideParametrizedTest(double num1, double num2) {
        double actual = cs.divide(num1, num2);
        double expected = num1 / num2;
        assertEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTheDivideNullTests")
    public void divideNullParametrizedTest(double num1, double numZero){
        assertThrows(IllegalArgumentException.class, () -> cs.divide(num1, numZero));
    }
}