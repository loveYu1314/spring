package com.lixn.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @创建人 lixiangnan
 * @创建时间 2019/11/10
 * @描述
 */
@Component
public class AnnotationConfigTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(AnnotationConfigTest.class);
		context.refresh();
		AnnotationConfigTest test = (AnnotationConfigTest)context.getBean("test");
		System.out.println(test);
	}
}
