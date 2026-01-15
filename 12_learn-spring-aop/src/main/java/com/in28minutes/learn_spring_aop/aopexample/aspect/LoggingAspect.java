package com.in28minutes.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration   //Configuration
@Aspect //AOP
public class LoggingAspect {

    private	Logger logger = LoggerFactory.getLogger(getClass());
	
	//Pointcut - when?
    //execution(* PACKAGE.*.*(..))   - syntax
    //execution of any method in any class within this package is the pointcut
    @Before("com.in28minutes.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
      //Login - what?		
		logger.info("Before Aspect - Method is called - {}", joinPoint);
	}
    
    
    @After("com.in28minutes.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
      //Login - what?		
		logger.info("After Aspect  - {} has executed", joinPoint);
	}
    
    
    @AfterThrowing(
   	pointcut = "com.in28minutes.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()",
    throwing = "exception"
    )
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
      //Login - what?		
  		logger.info("AfterThrowing Aspect  - {} has thrown an exception - {}", joinPoint , exception);
	}

    
    @AfterReturning(
    pointcut = "com.in28minutes.learn_spring_aop.aopexample.aspect.CommonPointcutConfig.businessAndDataPackageConfig()",
    returning = "resultValue"
    )
  	public void logMethodCallAfterSucessfulExecution(JoinPoint joinPoint, Object resultValue) {
        //Login - what?		
  		logger.info("AfterReturning Aspect  - {} has sucessfully executed and returned  {}", joinPoint , resultValue);
  	}
}
