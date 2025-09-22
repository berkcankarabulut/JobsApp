package com.Project.App.JobsApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    //return type, class-name.method-name(args)
    @Before("execution(* com.Project.App.JobsApp.controller.JobRestController.getJobByID(..))") // Method çağrılmadan önce tetiklenir
    // * Joker olarak kullanılır herşey anlamına gelir. @Before("execution *.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        LOGGER.info("Method Called:" + joinPoint.getSignature().getName());
    }

    @After("execution(* com.Project.App.JobsApp.controller.JobRestController.getJobByID(..))") // Method execute edildikten sonra tetiklenir
    // * Joker olarak kullanılır herşey anlamına gelir. @Before("execution *.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint) {
        LOGGER.info("Method Called:" + joinPoint.getSignature().getName());
    }
    @AfterThrowing("execution(* com.Project.App.JobsApp.controller.JobRestController.getJobByID(..))") // Hata oldugunda
    // * Joker olarak kullanılır herşey anlamına gelir. @Before("execution *.*(..))")
    public void logMethodError(JoinPoint joinPoint) {
        LOGGER.info("Method Called:" + joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* com.Project.App.JobsApp.controller.JobRestController.getJobByID(..))") // Method başarılı olduktan sonra tetiklenir.
    // * Joker olarak kullanılır herşey anlamına gelir. @Before("execution *.*(..))")
    public void logMethodExecutedSuccess(JoinPoint joinPoint) {
        LOGGER.info("Method Called:" + joinPoint.getSignature().getName());
    }
}
