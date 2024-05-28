package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void addtionTest(){
        int result = Calculator.caluclate(1, "+", 2);

        assertThat(result).isEqualTo(3);

    }

    @DisplayName("뺄셈 연산을 수행한다.")
    @Test
    void subtractionTest(){
        int result = Calculator.caluclate(1, "-", 2);

        assertThat(result).isEqualTo(-1);

    }

    @DisplayName("덧셈 연산을 수행한다.")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculateTest(int operand1, String operator, int operand2, int result){
      //given
        int calculateResult = Calculator.caluclate(operand1,operator,operand2);

      //when
        assertThat(calculateResult).isEqualTo(result);

      //then
    }

    @DisplayName("나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다.")
    @Test
    void calculateExceptionTest(){
      //given
        assertThatCode(()-> Calculator.caluclate(10,"/",0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로는 나눌 수 없습니다.");
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }
}