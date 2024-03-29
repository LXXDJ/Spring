package com.ohgiraffers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.ohgiraffers.*Service.*(..))")
    public void LogPointcut(){}

    @Before("LoggingAspect.LogPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before joinPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() = " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) System.out.println("Before joinPoint.getArgs()[0] = " + joinPoint.getArgs()[0]);
    }

    @After("LogPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getTarget() = " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() = " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0) System.out.println("After joinPoint.getArgs()[0] = " + joinPoint.getArgs()[0]);
    }

    @AfterReturning(pointcut = "LogPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result = " + result);
        if(result!=null && result instanceof Map) ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환값 가공"));
    }

    @AfterThrowing(pointcut = "LogPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("After Throwing exception = " + exception);
    }

    @Around("LogPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around Before : " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Around After : " + joinPoint.getSignature().getName());
        return result;
    }
}
