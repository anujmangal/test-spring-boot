package com.anuj.testspringboot.sameinterfacedependency;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TestInterfacePrimaryDependency implements TestInterface{
}
