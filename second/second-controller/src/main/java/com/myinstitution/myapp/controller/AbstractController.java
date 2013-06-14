package com.myinstitution.myapp.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myinstitution.myapp.logger.LoggerFactory;

public abstract class AbstractController {

    private static Logger logger = LoggerFactory
            .getLogger(AbstractController.class);

    public static BeanFactory getBeanFactory() {
        logger.info("Entering");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring-identity.xml" });

        // an ApplicationContext is also a BeanFactory (via inheritance)
        BeanFactory factory = context;
        logger.info("Exiting");
        return factory;
    }
}