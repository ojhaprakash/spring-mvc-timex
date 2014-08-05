package ca.mountainpirate.timex.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyControllerLogger {

	@Pointcut("execution(* com.mountainpirate.timex.controller.*Controller.*(..)) ")
	public void allControllerOrServiceMethods() {
	}

	@After("allControllerOrServiceMethods()")
	public void logAfter(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());
		Signature signature = joinPoint.getSignature();
		logger.info("AFTER " + signature);
	}

	// @Around("execution(* com.mountainpirate.timex.controller.*Controller.*(..))")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());
		Signature signature = joinPoint.getSignature();

		logger.info("entering " + signature);

		Object object = joinPoint.proceed();

		logger.info("before returning " + signature);
		return object;
	}

	@Before("allControllerOrServiceMethods()")
	public void logBefore(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget()
				.getClass());
		Signature signature = joinPoint.getSignature();

		logger.info("BEFORE " + signature);
	}
}
