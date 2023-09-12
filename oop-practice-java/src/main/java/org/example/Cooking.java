package org.example;

public class Cooking {
    public Cook makeCook(Menuitem menuitem) {
        Cook cook = new Cook(menuitem);
        return cook;
    }
}
