package com.example.application.services;

import org.springframework.stereotype.Service;
@Service
public class Calculator {
    private Double first;
    private Double second;
    private String result;


    public String calculate(String firstStr, String secondStr, String sing) {
        this.first = setValue(firstStr);
        this.second = setValue(secondStr);
        switch (sing) {
            case "+" -> sum();
            case "-" -> differences();
            case "*" -> multiplication();
            case "/" -> division();
            case "%" -> percent();
        }
        return result;
    }

    private void percent() {
        if (notErr()) {
            result = String.valueOf(first / 100 * second);
        }
    }

    private void sum() {
        if (notErr())
            result = String.valueOf(first + second);
    }

    private void differences() {
        if (notErr())
            result = (String.valueOf(first - second));
    }

    private void division() {
        if (notErr()) {
            if (second != 0) {
                result = (String.valueOf(first / second));
            } else {
                result = ("На ноль делить нельзя.");
            }
        }
    }

    public void multiplication() {
        if (notErr()) {
            result = String.valueOf(first * second);
        }
    }

    private Double setValue(String value) {
        try {
            return Double.parseDouble(value);
        } catch (Exception e) {
            return null;
        }
    }

    private boolean notErr() {
        if (first == null || second == null) {
            result = "Неверный ввод!!!";
            return false;
        } else {
            return true;
        }
    }
}
