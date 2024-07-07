package org.webapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class QueryStringsTest {
    @DisplayName("")
    @Test
    void test(){
      //given
        QueryStrings queryStrings = new QueryStrings("operand1=11&operator=*&operand2=55"); //List<QueryString>
        assertThat(queryStrings).isNotNull();
    }
}
