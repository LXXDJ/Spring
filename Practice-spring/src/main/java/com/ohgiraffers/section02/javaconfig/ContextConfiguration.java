package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    // @Bean        // 이름 생략 시
    @Bean("mem")    // 이름 지정 시
    public MemberDTO getMember(){
        return new MemberDTO(2, "user02", "pass02", "다람쥐");
    }
}
