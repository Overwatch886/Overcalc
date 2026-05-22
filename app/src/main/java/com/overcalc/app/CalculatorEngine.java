package com.overcalc.app;


public class CalculatorEngine {
    public double add(double num1, double num2){
        return num1 + num2;
    }
    public double subtract(double num1, double num2){
        return num1 - num2;
    }
    public double multiply(double num1, double num2){
        return num1 * num2;
    }
    public double divide(double num1, double num2){
        if (num2 == 0.0){
            return Double.NaN;
        }
        else{
            return num1/num2;
        }
    }
    public long factorial(int n){
        if (n<0) {
            throw new IllegalArgumentException("Factorial of a negative number is infinity");
        }
        else if (n == 1 || n == 0) {
            return 1;
        }
        else {
            return n * factorial(n - 1);
        }
    }
}
