package org.example;

public class Calculator {
    public static int caluclate(int operand1, String operator, int operand2) {
        if(operator.equals("+"))
            return operand1 + operand2;
        return 0;
    }
}
