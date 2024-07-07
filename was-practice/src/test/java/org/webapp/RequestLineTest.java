package org.webapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RequestLineTest {
    @DisplayName("")
    @Test
    void create(){
        RequestLine requestLine = new RequestLine("GET /calculate?operand1=11&operator=*&operand2=55");
        RequestLine makedRequestLine = new RequestLine("GET","/calculate","operand1=11&operator=*&operand2=55");

        System.out.println(requestLine.equals(makedRequestLine));
    }
}
