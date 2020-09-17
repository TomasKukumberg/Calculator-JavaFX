package com.calculator.app;

public class Model {

    public long calculate(long firstNumber, long secondNumber, String operator) {
        switch(operator) {
            case "+":
                return firstNumber + secondNumber;
            case "-":
                return firstNumber - secondNumber;
            case "*":
                return firstNumber * secondNumber;
            case "/":
                if(secondNumber == 0) {
                    return 0;
                }
                return firstNumber / secondNumber;
        }
        System.out.println("Undefined operator" + operator);
        return 0;
    }
}
