package com.anuj.testspringboot.aop.nested;

import org.springframework.stereotype.Service;

@Service
public class SpringAopService {

    public void callMethod(){
        System.out.println("Inside callMethod for SpringAopService");
    }
}
