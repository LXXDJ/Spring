package com.ohgiraffers.section02.subsection02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {
    @PostConstruct
    public void openShop(){
        System.out.println("가게 문을 열었습니다.");
    }

    @PreDestroy
    public void closeShop(){
        System.out.println("가게 문을 닫았습니다.");
    }
}
