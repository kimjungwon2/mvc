package org.example;

public class Calculator {
    public static int caluclate(int operand1, String operator, int operand2) {
        if(operator.equals("+"))
            return operand1 + operand2;
        if(operator.equals("-"))
            return operand1 - operand2;
        if(operator.equals("*"))
            return operand1 * operand2;
        if(operator.equals("/"))
            if(operand2 !=0)
                return operand1 / operand2;
            else
                return 0;
        return 0;
    }
}
