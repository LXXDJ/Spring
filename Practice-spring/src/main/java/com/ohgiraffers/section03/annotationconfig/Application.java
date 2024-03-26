package com.ohgiraffers.section03.annotationconfig;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        String[] beanNames = context.getBeanDefinitionNames();
        for(String name : beanNames) System.out.println(name);

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.selectMember(3));
        System.out.println(memberDAO.selectMember(4));
        System.out.println(memberDAO.insertMember(new MemberDTO(5, "user05", "pass05", "코알라")));
        System.out.println(memberDAO.selectMember(5));
    }
}
