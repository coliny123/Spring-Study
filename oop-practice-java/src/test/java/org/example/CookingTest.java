package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {
    @DisplayName("메뉴에 해당하는 음식을 만든다")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();        // 요리사 생성
        Menuitem menuitem = new Menuitem("돈까스", 5000);  // 요리사에게 전달할 menuitem 생성
        Cook cook = cooking.makeCook(menuitem); // 요리사(cooking)에게 makeCook을 요청 어떤 요리인지는 menuitem으로 전달, menuitem에 맞는 요리(cook)생성됨

        assertThat(cook).isEqualTo(new Cook("돈까스", 5000));  // 그 요리와 menuitem과 일치하는지 확인
    }
}
