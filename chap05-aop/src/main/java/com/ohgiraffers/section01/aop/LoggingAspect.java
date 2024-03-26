package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    /* @Pointcut : 여러 조인 포인트를 매치하기 위해 지정한 표현식 */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void LogPointcut(){}

    /* JoinPoint : 포인트컷으로 패치한 실행 시점
    *  advice : 이렇게 매치된 조인포인트에서 해야할일이 어드바이스
    *  매개변수로 전달한 JoinPoint 객체는 현재 조인 포인트의 메소드명, 인수값 등의 자세한 정보에 액세스 가능 */
    @Before("LoggingAspect.LogPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    /* 포인트컷을 동일한 클래스 내에서 사용하면, 클래스명 생략 가능
    *  (단, 패키지가 다르면 패키지를 포함한 클래스명 기술) */
    @After("LogPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("After joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @AfterReturning(pointcut = "LogPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("After Returning result " + result);
        if(result != null && result instanceof Map){
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }

    /* throwing 속성의 이름과 매개변수의 이름이 동일해야 한다. */
    @AfterThrowing(pointcut = "LogPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("After Throwing exception : " + exception);
    }

    /* Around 사용은 권장하지 않음, 사용시 주의필요 */
    @Around("LogPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Around Before : " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();    // 원본 조인포인트 실행구문
        System.out.println("Around After : " + joinPoint.getSignature().getName());

        return result;  // 원본 조인포인트를 호출한 쪽 혹은 다른 어드바이스가 다시 실행할 수 있도록 반환
    }
}
