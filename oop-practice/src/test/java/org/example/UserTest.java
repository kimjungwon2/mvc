package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @DisplayName("패스워드 초기화한다.")
    @Test
    void passwordTest(){
        User user = new User();
        user.initPassword();

        assertThat(user.getPassword()).isNotNull();
    }
}