package com.example.test3java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello(){
        return "<h1>Приветствую в калькуляторе</h1>";
    }
    @GetMapping("/plus")
    public String plus (@RequestParam("num1") double num1,
                        @RequestParam("num2") double num2){
        return "<h1>" + num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2) + "</h1>";
    }
    @GetMapping("/minus")
    public String minus (@RequestParam("num1") double num1,
                         @RequestParam("num2") double num2){
        return "<h1>" + num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2) + "</h1>";
    }
    @GetMapping("/multiply")
    public String multiply (@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2){
        return "<h1>" + num1 + " x " + num2 + " = " + calculatorService.multiply(num1, num2) + "</h1>";
    }
    @GetMapping("/divide")
    public String divide (@RequestParam("num1") double num1,
                          @RequestParam("num2") double num2){
        try {
            return "<h1>" + num1 + " : " + num2 + " = " + calculatorService.divide(num1, num2) + "</h1>";
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Деление на 0 невозможно");
        }
    }
}