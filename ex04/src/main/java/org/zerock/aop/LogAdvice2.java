package org.zerock.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAdvice2 {

	@Pointcut("execution(* org.zerock.service.*.*(..))")
	public void allPointCut() {}
	
	@Around("allPointCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		
		System.out.println("Start --------------------------");
		stopWatch.start();
		Object obj = pjp.proceed();
		
		System.out.println("End ----------------------------");
		stopWatch.stop();
		
		System.out.println("메소드 : " + method + " 걸린 시간 : " 
				+ stopWatch.getTotalTimeNanos() + "(no)초");
		
		return obj;
	}
	
//	@Before("allPointCut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		
		Object[] args = jp.getArgs();
		
		System.out.println("[사전 처리]" + method +
				"() 메소드 정보" + args[0].toString() + " " + args[1].toString());
	}
	
//	@AfterReturning(pointcut = "allPointCut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		String method = jp.getSignature().getName();
		System.out.println("[사후처리]" + method + "메소드 리턴값 : " + returnObj.toString());
	}
}
