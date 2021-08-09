package com.example.demoofaoplog.isProxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MypRroxy {

	private Logger logger = LoggerFactory.getLogger(MypRroxy.class);
	//切点
	@Pointcut(value = "execution( * com.example.demoofaoplog.controller.*.*(..))")
	public void myPointCut(){
	}

	//监听
	@Around("myPointCut()")
	public Object myLogMsg(ProceedingJoinPoint pdj) throws Throwable {
		String methodName = pdj.getSignature().getName();
		String className = pdj.getTarget().getClass().toString();
		Object[] args = pdj.getArgs();

		ObjectMapper mapper = new ObjectMapper();
		logger.info("调用前：类："+className+"方法："+methodName+"参数："
				+mapper.writeValueAsString(args));
		//代理调用目标方法
		Object object = pdj.proceed();
		logger.info("调用后：类："+className+"方法："+methodName+"返回："
				+mapper.writeValueAsString(object));

		return object;
	}
}
