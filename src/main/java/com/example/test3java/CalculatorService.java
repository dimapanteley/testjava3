package com.example.test3java;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double plus(Double num1, Double num2) {
        return num1 + num2;
    }

    public double minus(double num1, double num2) {
        return num1 - num2;
    }

    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    public double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return num1 / num2;
    }
}