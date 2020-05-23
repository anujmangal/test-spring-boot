package com.anuj.testspringboot.sameinterfacedependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("qualifier")
public class TestQualifierDependency implements TestQualifierInterface {
}
