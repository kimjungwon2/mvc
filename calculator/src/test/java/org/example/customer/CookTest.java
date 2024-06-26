package org.example.customer;

import org.example.delivery.Cook;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CookTest {
    @DisplayName("요리를 생성한다.")
    @Test
    void createTest(){
      //given

      //when

      //then
        assertThatCode(()->new Cook("만두", 5000))
                .doesNotThrowAnyException();
    }
}
