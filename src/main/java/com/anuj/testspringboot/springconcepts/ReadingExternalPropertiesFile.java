package com.anuj.testspringboot.springconcepts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReadingExternalPropertiesFile {

    @Value("${test.variable}")
    private String text;

    public String readDataFromExternalProperties(){
        return text;
    }
}
