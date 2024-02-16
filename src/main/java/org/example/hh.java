package org.example;

public class hh {
    public static void main(String[] args) {
        float a = 3;
        char op = '/';
        float b = 0;

        float result = 0;
        if (op == '+'){
            result = a + b;
        } else if (op == '-'){
            result = a - b;
        } else if (op == '*'){
            result = a * b;
        } else {
            result = a / b;
        }

        System.out.println(result);
    }
}
