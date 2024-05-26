package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @DisplayName("덧셈 연산을 수행한다.")
    @Test
    void addtionTest(){
        int result = Calculator.caluclate(1, "+", 2);

        assertThat(result).isEqualTo(3);

    }

}