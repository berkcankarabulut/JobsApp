package com.Project.App.JobsApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.Project.App.JobsApp.controller.JobRestController.getJobByID(..))")
    // Before ve After in birlikte çalışması oluyor.
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postID) throws Throwable {
        if (postID < 0) {
            LOGGER.info("PostId is negative, updating it");
            postID = -postID;
            LOGGER.info("new value:" + postID);
        }
        Object obj = jp.proceed(new Object[]{postID});

        return obj;
    }
}
