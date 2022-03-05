package com.example.calculator;

public class CalculatorModel {
    public float calculation(float input1, float input2, String operators) {
        switch (operators) {
            case "+":
                return input1 + input2;
            case "-":
                return input1 - input2;
            case "/":
                return input1 / input2;
            case "*":
                return input1 * input2;
        }
        return 0;
    }
}
