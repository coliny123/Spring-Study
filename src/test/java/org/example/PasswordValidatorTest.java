package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

/*
요구사항
• 비밀번호는 최소 8자 이상 12자 이하여야 한다.
• 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
• 경계조건에 대해 테스트 코드를 작성해야 한다 (7자, 13자에 대한)
 */
public class PasswordValidatorTest {
    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest(){
        assertThatCode(() -> PasswordValidator.validate("server-sample"))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"aabbcce", "aabbccddeeffg"})

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과면 IllegalArgumentException 예외가 발생한다.")
    @Test
    void validatePasswordTest2(String password){
        assertThatCode(()-> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("비밀번호는 최소 8자 이상 12자 이하여야 한다.");
    }
}
