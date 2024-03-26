package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // 이름 생략 시
        // MemberDTO member = context.getBean("getMember", MemberDTO.class);

        // 이름 지정 시
        MemberDTO member = context.getBean("mem", MemberDTO.class);

        System.out.println(member);
    }
}
