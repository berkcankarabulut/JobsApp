package com.Project.App.JobsApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitorAspect.class);

    @Around("execution(* com.Project.App.JobsApp.controller.JobRestController.*(..))") // Before ve After in birlikte çalışması oluyor.
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object obj = jp.proceed();
        long endTime = System.currentTimeMillis();
        LOGGER.info("Time taken:" + (endTime - startTime) + " ms");
        return obj;
    }
}
