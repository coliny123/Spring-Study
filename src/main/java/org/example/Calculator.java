package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperator = List.of(new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicOperator(),
            new DivisionOperator());
    public static int calculate(int operand1, String operator, int operand2) {
        return arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
