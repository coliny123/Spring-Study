package org.example;

public class Customer {

        public void order(String name, Menu menu, Cooking cooking){
            Menuitem menuitem = menu.choose(name);
            Cook cook = cooking.makeCook(menuitem);

    }
}
