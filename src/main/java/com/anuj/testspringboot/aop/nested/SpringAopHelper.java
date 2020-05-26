package com.anuj.testspringboot.aop.nested;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpringAopHelper {

    @Before("execution(* com.anuj.testspringboot.aop.nested.*.*(..))")
    public void beforeAopCallAnyName(JoinPoint joinPoint){
        System.out.println("In beforeAopCallAnyName method from " + joinPoint);
    }

    @Around("execution(* com.anuj.testspringboot.aop.nested.*.*(..))")
    public void aroundAdviceAnyName(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        System.out.println(" Time taken by " + joinPoint + " method to execute is " + timeTaken + " ms");

    }
}
