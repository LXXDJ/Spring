package com.ohgiraffers.section02.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
/* @Primary 어노테이션을 설정하면 @Autowired로 동일한 타입의 여러 빈(bean)을 찾게 되는 경우 자동으로 우선 연결할 타입으로 설정
*  동일한 타입의 클래스 중 한개만 @Primary 어노테이션 사용 가능 */
public class Charmander implements Poketmon {
    @Override
    public void attack() {
        System.out.println("파이리");
    }
}
