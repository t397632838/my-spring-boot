package com.example.log;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogAspect {

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 定义切入点
	 */
	@Pointcut("execution(public * com.example.demo.*.*())")
	public void webLog() {
	}

	/**
	 * 方法执行前切入点
	 * 
	 * @param joinPoint
	 */
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) {

		ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

		HttpServletRequest request = attribute.getRequest();

		logger.info("URL:" + request.getRequestURI().toString());
		logger.info("IP:" + request.getRemoteAddr());
	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterRetuning(Object ret) {
		logger.info("RESPONSE:" + ret);
	}

}
