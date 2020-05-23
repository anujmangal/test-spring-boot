package com.anuj.testspringboot.sameinterfacedependency;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TestNoQualifierDependency implements TestQualifierInterface{
}
