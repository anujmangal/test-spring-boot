package com.anuj.testspringboot.aop.nested.sub;

import org.springframework.stereotype.Service;

@Service
public class SpringAopService2 {

    public void callMethod(){
        System.out.println("Inside callMethod for SpringAopService2");
    }
}
