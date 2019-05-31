package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.ExampleBean;
import basic.MessageBean;
import basic.ScopeBen;
import ioc.A;
import ioc.Bar;
import ioc.LoginService;
import ioc.Restaurant;
public class RestCase {
@Test
public void test1(){
	String config="basic.xml";
	/*
	 * 因为ApplicationContext接口没有提供close方法,所以需要使用其
	 * 接口ApplicationContext
	 */
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	ExampleBean eb1=ac.getBean("eb1",ExampleBean.class);
	eb1.service();
	ac.close();
}
@Test
public void test2(){
	String config="basic.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	ScopeBen sb=ac.getBean("sb1",ScopeBen.class);
	ScopeBen sb1=ac.getBean("sb1",ScopeBen.class);
	System.out.println(sb==sb1);
	
}
@Test
//延迟加载
public void test3(){
	String config="basic.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	
}
@Test
public void test4(){
	String config="basic.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	MessageBean sb=ac.getBean("mb1",MessageBean.class); 
	MessageBean sb1=ac.getBean("mb1",MessageBean.class); 
	System.out.print("sb==sb1=");
	System.out.println(sb==sb1);
	ac.close();
	
}
@Test
//Set方法注入
public void test5(){
	String config="ioc.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	A a1=ac.getBean("a1",A.class);
	a1.service();
}
@Test
//Set方法注入
public void test6(){
	String config="ioc.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	Restaurant r1=ac.getBean("r1",Restaurant.class);
	
	
}

@Test
//构造器注入
public void test7(){
	String config="ioc.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	Bar bar1=ac.getBean("bar1",Bar.class);
	System.out.println(bar1);
	
}
@Test
//构造器注入
public void test8(){
	String config="ioc.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	Restaurant bar1=ac.getBean("r1",Restaurant.class);
	System.out.println(bar1);
	
}

@Test
//构造器注入
public void test9(){
	String config="ioc.xml";
	AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
	LoginService bar1=ac.getBean("login",LoginService.class);
	bar1.service();
	System.out.println(bar1);
	
}
}

























