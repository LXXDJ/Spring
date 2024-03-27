package com.ohgiraffers.section02.subsection02;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        Product carpBread = context.getBean("carpBread", Bread.class);
        Product milk = context.getBean("milk", Beverage.class);

        ShoppingCart cart1 = context.getBean("cart", ShoppingCart.class);
        cart1.addItem(carpBread);
        System.out.println("cart1.getItem() = " + cart1.getItem());

        ShoppingCart cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(milk);
        System.out.println("cart2.getItem() = " + cart2.getItem());

        ((AnnotationConfigApplicationContext)context).close();
    }
}
