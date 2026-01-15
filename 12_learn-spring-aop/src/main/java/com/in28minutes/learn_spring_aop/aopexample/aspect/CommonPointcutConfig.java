package com.in28minutes.learn_spring_aop.aopexample.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	
	@Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.*.*.*(..))")
	public void  businessAndDataPackageConfig() {}
	
	
	//For business class only
	@Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.business.*.*(..))")
	public void  businessPackageConfig() {}
	
	//For data class only
	@Pointcut("execution(* com.in28minutes.learn_spring_aop.aopexample.data.*.*(..))")
	public void  dataPackageConfig() {}
	
	//Using bean
	@Pointcut("bean(*Service*)")
	public void allPackageConfigUsingBean() {}
	
	@Pointcut("@annotation(com.in28minutes.learn_spring_aop.aopexample.annotations.TrackTime)")
	public void trackTimeAnnotation() {}

}
