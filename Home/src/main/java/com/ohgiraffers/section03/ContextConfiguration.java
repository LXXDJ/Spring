package com.ohgiraffers.section03;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
@PropertySource("section03/properties/product-info.properties")
public class ContextConfiguration {

    @Value("${bread.carpbread.name}")
    private String carpBreadName;

    @Value("${bread.carpbread.price}")
    private int carpBreadPrice;

    @Value("${bread.milk.name}")
    private String milkName;

    @Value("${bread.milk.price}")
    private int milkPrice;

    @Value("${bread.milk.capacity}")
    private int milkCapacity;

    @Bean
    public Product carpBread(){
        return new Bread(carpBreadName, carpBreadPrice, new Date());
    }

    @Bean
    public Product milk(){
        return new Beverage(milkName, milkPrice, milkCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart(){
        return new ShoppingCart();
    }
}
