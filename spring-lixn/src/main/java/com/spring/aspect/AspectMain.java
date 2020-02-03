package com.spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @创建人 lixiangnan
 * @创建时间 2020/1/6
 * @描述
 */
public class AspectMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aspectTest.xml");
		AspectTestBean testBean = (AspectTestBean)context.getBean("test");
		testBean.test();
	}
}
