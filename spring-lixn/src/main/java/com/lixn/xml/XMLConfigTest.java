package com.lixn.xml;

import com.lixn.xml.bean.XMLTestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @创建人 lixiangnan
 * @创建时间 2019/11/11
 * @描述
 */
public class XMLConfigTest {

	public static void main(String[] args) {
//		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
//		XMLTestBean bean = (XMLTestBean)beanFactory.getBean("testBean");
//		System.out.println(bean.getXmlStr());

		// 根据Xml配置文件创建Resource资源对象，该对象包含了BeanDefinition的信息
		ClassPathResource resource = new ClassPathResource("spring-config.xml");
		// 创建DefaultListableBeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		// 创建 XmlBeanDefinitionReader 读取器，用于载入BeanDefinition
		// BeanFactory作为参数，是为了将读取的信息回调配置给factory
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		// XmlBeanDefinitionReader执行载入BeanDefinition的方法，最后会完成Bean的载入和注册
		// 完成后Bean就成功的放置到IOC容器中了，
		reader.loadBeanDefinitions(resource);


		ApplicationContext context = new FileSystemXmlApplicationContext("spring-config.xml");

		ClassPathXmlApplicationContext xmlApplicationContext =
				new ClassPathXmlApplicationContext("spring-config.xml");

	}
}
