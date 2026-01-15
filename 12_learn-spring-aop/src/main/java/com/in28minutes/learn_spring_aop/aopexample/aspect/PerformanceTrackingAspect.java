package com.in28minutes.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
	
	
    private	Logger logger = LoggerFactory.getLogger(getClass());

	
//	@Around("com.in28minutes.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
	@Around("com.in28minutes.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.trackTimeAnnotation()")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
		//start a timer
		long startTimeMillis = System.currentTimeMillis();
		//execute the me
		
		Object returnValue =  proceedingJoinPoint.proceed();
		
		//stop the timer
		long stopTimeMillis = System.currentTimeMillis();
		
		long executionDuration = stopTimeMillis - startTimeMillis;

		logger.info("Around Aspect - {} method executed in {}",proceedingJoinPoint , executionDuration);

		return returnValue;
	}

}
