package com.example.test3java;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.test3java.NumbersClass.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    private CalculatorService cs;

    @BeforeEach
    public void sutUp() {
        cs = new CalculatorService();
    }

    @Test
    public void addTest1() {
        double actual = cs.plus(NUM1, NUM2);
        double expected = NUM1 + NUM2;
        assertEquals(actual, expected);
    }

    @Test
    public void addTest2() {
        double actual = cs.plus(NUM3, NUM4);
        double expected = NUM3 + NUM4;
        assertEquals(actual, expected);
    }

    @Test
    public void minusTest1() {
        double actual = cs.minus(NUM1, NUM2);
        double expected = NUM1 - NUM2;
        assertEquals(actual, expected);
    }

    @Test
    public void minusTest2() {
        double actual = cs.minus(NUM3, NUM4);
        double expected = NUM3 - NUM4;
        assertEquals(actual, expected);
    }

    @Test
    public void multiplyTest1() {
        double actual = cs.multiply(NUM1, NUM2);
        double expected = NUM1 * NUM2;
        assertEquals(actual, expected);
    }

    @Test
    public void multiplyTest2() {
        double actual = cs.multiply(NUM3, NUM4);
        double expected = NUM3 * NUM4;
        assertEquals(actual, expected);
    }

    @Test
    public void divideTest1() {
        double actual = cs.divide(NUM1, NUM2);
        double expected = NUM1 / NUM2;
        assertEquals(actual, expected);
    }

    @Test
    public void divideTest2() {
        double actual = cs.divide(NUM3, NUM4);
        double expected = NUM3 / NUM4;
        assertEquals(actual, expected);
    }

    @Test
    public void divideWithExceptionTest1() {
        assertThrows(IllegalArgumentException.class, () -> cs.divide(NUM1, NUM_ZERO));
    }

    @Test
    public void divideWithExceptionTest2() {
        assertThrows(IllegalArgumentException.class, () -> cs.divide(NUM3, NUM_ZERO));
    }
}