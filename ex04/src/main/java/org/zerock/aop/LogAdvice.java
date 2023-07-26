package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAdvice {
	
//	@Before("execution(* org.zerock.service.SampleService*.*(..))")
//	public void logBefore() {
//		log.info("---------- before ----------");	
//	}
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();
		
		log.info("Target : {}", pjp.getTarget().getClass().getName());
		log.info("Param : {}", Arrays.toString(pjp.getArgs()));
		
		Object result = null;
		
		try {
			result = pjp.proceed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		log.info("Time : {}", (end-start));
		return result;
	}
	
	
//	@AfterThrowing(pointcut = "execution(* org.zerock.service.SampleService*.*(..))", throwing = "exception")
	public void logException(Exception exception) {
		log.info("Exception!!!!!!!!!!");
		log.info("Exception ===> : {}", exception);
	}
	
	
//	@After("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("---------- before1 ----------");	
	}
	
//	@Pointcut("execution(* org.zerock.service.SampleService*.*Mul*(..))")
	public void allPointcut() {}
	
//	@After("allPointcut()")
	public void logAfter() {
		log.info("---------- after ----------");
	}
	
}
