package com.luv2code.springdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

		
	@Pointcut("execution(* com.luv2code.springdemo.rest.DemoRestController.*(..))")
	public void timetaken() {}
	
	@Around("timetaken()")
    public Object profile(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Going to call the method " + pjp.getSignature().getName());
        Object output = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println("Method " + pjp.getSignature().getName() +" execution time: " + elapsedTime + " milliseconds.");
        return output;
}
	
}