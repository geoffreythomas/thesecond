package com.myinstitution.myapp.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class AbstractController {

    public static BeanFactory getBeanFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring-identity.xml" });

        // an ApplicationContext is also a BeanFactory (via inheritance)
        BeanFactory factory = context;
        return factory;
    }
}