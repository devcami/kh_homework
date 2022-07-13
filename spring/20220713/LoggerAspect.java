package com.kh.spring.common.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.spring.todo.model.dto.Todo;

import lombok.extern.slf4j.Slf4j;
/**
 * #11.1 Aspect 작성 (pointcut + advice)
 */
@Component //bean
@Aspect //aop
@Slf4j
public class LoggerAspect {
	
	/**
	 * com.kh.spring.todo 패키지 하위의 모든 클래스, 모든 메소드
	 * - 매개변수 상관없음
	 * - 리턴타입 상관없음
	 */
//	@Pointcut("execution(* com.kh.spring.todo.controller.TodoController.todoList(String)")
	@Pointcut("execution(* com.kh.spring.todo..*(..))") // 매개변수(..) : n개
	public void pointcut() {}
	
	@Pointcut("execution(* com.kh.spring.todo.controller.TodoController.insertTodo(..))")
	public void pc() {}
	/**
	 * joinPoint 앞, 뒤에서 실행되는 Around Advice
	 */
	@Around("pointcut()")
	public Object logger(ProceedingJoinPoint joinPoint) throws Throwable {
		Signature signature = joinPoint.getSignature();
		String type = signature.getDeclaringTypeName(); // 클래스명
		String method = signature.getName(); // 메소드명
		
		// before 
		log.debug("[Before] {}.{}", type, method);
		
		Object returnObj = joinPoint.proceed();

		// after
		log.debug("[After] {}.{}", type, method);
	
		return returnObj;
	}
	
	@Around("pc()")
	public Object stopwatch(ProceedingJoinPoint joinPoint) throws Throwable{
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		log.debug("걸린시간 : {}초", stopWatch.getTotalTimeSeconds());
		return returnObj;
	}
}
