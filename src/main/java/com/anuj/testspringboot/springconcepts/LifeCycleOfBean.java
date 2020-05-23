package com.anuj.testspringboot.springconcepts;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleOfBean {

    public LifeCycleOfBean(){
        System.out.println("LifeCycleOfBean -> Constructor Called");
    }

    @PreDestroy
    public void preDestroyMethodAnyName(){
        System.out.println("LifeCycleOfBean -> Pre Destroy Called");
    }

    @PostConstruct
    public void postConstructMethodAnyName(){
        System.out.println("LifeCycleOfBean -> Post Construct Called");
    }

}
