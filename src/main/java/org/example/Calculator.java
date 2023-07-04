package org.example;

import org.example.calculate.*;

import java.util.List;

public class Calculator {
    private static final List<NewArithmeticOperator> arithmeticOperator = List.of(new AdditionOperator(),
            new SubtractionOperator(),
            new MultiplicOperator(),
            new DivisionOperator());
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return arithmeticOperator.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))    // Calculator가 arithmetic에게 메세지 전달
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))    // 위와 같음, 객체간 메세지 전달 -> 객체지향!
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
