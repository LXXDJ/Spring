package com.ohgiraffers;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.ohgiraffers.*Service.*(..))")
    public void LoggingAspect(){}

    @Before("LoggingAspect.LogPointcut()")
    public void logBefore(Joinpoint joinpoint){
        System.out.println("Before joinpoint.getTarget() : " + joinpoint.getTarget());
        System.out.println("Before joinpoint.getSignature() : " + joinpoint.getSignature());
    }
}
