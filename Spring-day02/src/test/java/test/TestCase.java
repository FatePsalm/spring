package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.Manager;
import value.ExampleBean;
import value.SomeBean;

public class TestCase {
	@Test
	public void test1(){
		String config="ioc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg=ac.getBean("mg",Manager.class);
		System.out.println("mg="+mg);
	}
	@Test
	public void test2(){
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		ExampleBean eb1=ac.getBean("eb2",ExampleBean.class);
		System.out.println(eb1);
	}
	@Test
	public void test3(){
		//读取.properties文件
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Properties props=ac.getBean("config",Properties.class);
		System.out.println(props);
	}
	@Test
	public void test4(){
		//测试Spring表达式
		String config="value.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		SomeBean sb1=ac.getBean("sb1",SomeBean.class);
		System.out.println(sb1);
	}
}
























