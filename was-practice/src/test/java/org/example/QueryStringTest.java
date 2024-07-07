package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringTest {

    @DisplayName("")
    @Test
    void createTest(){
      QueryString queryString = new QueryString("operand1","11");
      assertThat(queryString).isNotNull();
    }
}
