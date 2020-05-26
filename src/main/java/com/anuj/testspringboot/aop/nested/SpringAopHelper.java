package com.anuj.testspringboot.aop.nested;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SpringAopHelper {

    @Before("execution(* com.anuj.testspringboot.aop.nested.*.*(..))")
    public void beforeAopCallAnyName(JoinPoint joinPoint){
        System.out.println("In beforeAopCallAnyName method from " + joinPoint);
    }
}
