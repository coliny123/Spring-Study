package org.example;

import java.util.Objects;

public class Cook {
    private final String name;
    private final int price;


    // 기존에는 name과 price를 받는 생성자만 있었는데
    public Cook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // menuitem을 받는 생성자 필요
    public Cook(Menuitem menuitem) {
        this.name = menuitem.getName();
        this.price = menuitem.getPrice();
    }

    // 객체들끼리 비교할 때는 equals() and hashCode()있어야 함
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cook cook = (Cook) o;
        return price == cook.price && Objects.equals(name, cook.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
