package com.anuj.testspringboot.dependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestSingletonClass {

    @Autowired
    private DefaultPrototypeService defaultPrototypeService;

    @Autowired
    private ActualPrototypeService actualPrototypeService;


    public DefaultPrototypeService getDefaultPrototypeService() {
        return defaultPrototypeService;
    }

    public void setDefaultPrototypeService(DefaultPrototypeService defaultPrototypeService) {
        this.defaultPrototypeService = defaultPrototypeService;
    }

    public ActualPrototypeService getActualPrototypeService() {
        return actualPrototypeService;
    }

    public void setActualPrototypeService(ActualPrototypeService actualPrototypeService) {
        this.actualPrototypeService = actualPrototypeService;
    }

}
