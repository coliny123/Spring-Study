package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

/*
음식점에서 음식 주문하는 과정 구현
요구사항
1. 도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
    ㄴ 고객, 메뉴판, 음식들, 요리사
2. 격체들 간의 관계를 고민
    ㄴ 손님 --- 메뉴판
    ㄴ 손님 --- 요리사
    ㄴ 요리사 -- 음식
3. 동적인 객체를 정적인 타인으로 추상화해서 도매인 모델링 하기
    ㄴ 손님 --- 손님 타입
    ㄴ 음식들 --- 음식 타입
    ㄴ 메뉴판 --- 메뉴판 타입
    ㄴ 메뉴 --- 메뉴 타입
4. 협력을 설계
5. 객체들을 포괄하는 타입에 적절한 책임을 할당
6. 구현하기
 */
public class CustomerTest {
    @DisplayName("메뉴이름에 해당하는 요리를 주문을 한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new Menuitem("돈까스", 5000),
                        new Menuitem("냉면", 7000)));
        Cooking cooking = new Cooking();

        // 고객이 주문함(order) menu와 cooking은 name에 해당하는 menuitem을 판별, 그리고 Cook을 만드려면 Cooking정보도 필요하기 때문에 같이 넘겨줌
        assertThatCode(() -> customer.order("돈까스", menu, cooking))
                .doesNotThrowAnyException();
    }
}
