package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuitemTest {
    @DisplayName("메뉴항목을 생성한다.")
    @Test
    void createTest() {
        assertThatCode(()-> new Menuitem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
