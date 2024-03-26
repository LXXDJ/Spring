package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Owner {

    /* init-method와 같은 설정 어노테이션 */
    @PostConstruct
    public void openShop(){
        System.out.println("가게 문을 열었습니다.");
    }

    /* destroy-method와 같은 설정 어노테이션 */
    @PreDestroy
    public void closeShop(){
        System.out.println("가게 문을 닫았습니다.");
    }
}
