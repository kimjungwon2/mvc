package org.example.customer;

import org.example.delivery.Cooking;
import org.example.delivery.Customer;
import org.example.delivery.Menu;
import org.example.delivery.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CustomerTest {

    @DisplayName("메뉴이름에 해당하는 요리를 주문을 한다.")
    @Test
    void orderTest(){
      //given
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000),new MenuItem("냉면", 7000)));
        Cooking cooking = new Cooking();

      //when
        assertThatCode(()->customer.order("돈까스", menu, cooking))
                .doesNotThrowAnyException();

      //then
    }

}
