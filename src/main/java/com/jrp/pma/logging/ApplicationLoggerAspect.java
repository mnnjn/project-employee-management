package com.jrp.pma.logging;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApplicationLoggerAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(com.jrp.pma.controllers..*)")
	public void definePackagePointcuts() {
		//empty method just to name the locations for pointcut
	}
	
	@Around("definePackagePointcuts()")
	public Object logAround(ProceedingJoinPoint jp) {
		log.debug("\n \n");
		log.debug("**************** BEFORE METHOD EXECUTES *********** \n {}.{} () wih args: {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		log.debug("________________________________");
		
		Object o = null;
		try {
			o=jp.proceed();
		} catch (Throwable e) {
			//
			e.printStackTrace();
		}
		
		log.debug("**************** AFTER METHOD EXECUTES *********** \n {}.{} () wih args: {}",
				jp.getSignature().getDeclaringTypeName(),
				jp.getSignature().getName(),
				Arrays.toString(jp.getArgs()));
		log.debug("________________________________ \n \n \n \n");
		
		return o;
	}

}
