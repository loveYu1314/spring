package com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @创建人 lixiangnan
 * @创建时间 2020/1/6
 * @描述
 */
@Aspect
public class AspectJTest {

	@Pointcut("execution(* *.test(..))")
	public void test(){}

	@Before("test()")
	public void beforeTest(){
		System.out.println("beforeTest");
	}

	@After("test()")
	public void afterTest(){
		System.out.println("afterTest");
	}

	@Around("test()")
	public Object aroundTest(ProceedingJoinPoint point){
		System.out.println("before 1");
		Object obj = null;
		try {
			obj = point.proceed();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("after 1");
		return obj;
	}

}
