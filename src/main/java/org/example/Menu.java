package org.example;

import java.util.List;

public class Menu {
    private final List<Menuitem> menuitem;

    public Menu(List<Menuitem> menuitems) { // 메뉴판은 여러개의 메뉴를 갖음 리스트로 구현
        this.menuitem = menuitems;
    }

    public Menuitem choose(String name) {
        return this.menuitem.stream()
                .filter(menuitem -> menuitem.matches(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 메뉴 이름입니다."));
    }
}
