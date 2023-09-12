package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


public class MenuTest {
    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new Menuitem("돈까스", 5000),
                new Menuitem("냉면", 7000)));

        Menuitem menuitem = menu.choose("돈까스"); //메뉴판(menu)에서 메뉴이름(name)에 맞는 메뉴(menuitem)을 반환

        assertThat(menuitem).isEqualTo(new Menuitem("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴르 선택할시 예외 반환")
    @Test
    void chooseTestFail() {
        Menu menu = new Menu(List.of(new Menuitem("돈까스", 5000),
                new Menuitem("냉면", 7000)));
        assertThatCode(()-> menu.choose("통닭"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴 이름입니다.");
    }
}
