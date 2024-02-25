package com.test.community.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName AlphaAspect
 * @Description TODO
 * @Author lcx
 * @Date 2024/2/25 17:18
 * @Version 1.0
 */
//@Component
//@Aspect
public class AlphaAspect {

    // 定义切点
    @Pointcut("execution(* com.test.community.service.*.*(..))")
    public void pointcut() {

    }

    // 定义通知
    @Before("pointcut()")
    public void before() {
        System.out.println("before");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning("pointcut()")
    public void afterReturning() {
        System.out.println("afterReturning");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("afterThrowing");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around之前");
       Object obj = joinPoint.proceed();
        System.out.println("around之后");
       return obj;
    }

}
