package test;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import annotations.Apple;
import annotations.Car;
import annotations.Examplebean;
import annotations.Leader;
import annotations.Manager;
import annotations.Student;
import value.ExampleBean;
import value.SomeBean;

public class TestCase2 {
	@Test
	//≤‚ ‘ ◊Èº˛…®√Ë
	public void test1(){
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Apple apple=ac.getBean("ap1",Apple.class);
	}
	@Test
	//≤‚ ‘ ◊Èº˛…®√Ë
	public void test2(){
		String config="annotations.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Apple apple=ac.getBean("ap1",Apple.class);
		ac.close();
		
	}
	@Test
	//≤‚ ‘ ◊Èº˛…®√Ë ◊˜”√”Ú
	public void test3(){
		String config="annotations.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Apple apple=ac.getBean("ap1",Apple.class);
		Apple apple1=ac.getBean("ap1",Apple.class);
		System.out.println(apple==apple1);
		ac.close();
		
	}
	@Test
	//≤‚ ‘ ◊Èº˛…®√Ë —”≥Ÿº”‘ÿ
	public void test4(){
		String config="annotations.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Apple apple=ac.getBean("ap1",Apple.class);
		Apple apple1=ac.getBean("ap1",Apple.class);
		System.out.println(apple==apple1);
		ac.close();
		
	}
	@Test
	//≤‚ ‘ @Autowired @Qualifier
	public void test5(){
		String config="annotations.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Manager mg=ac.getBean("mg",Manager.class);
		Leader ld=ac.getBean("ld",Leader.class);
		System.out.println(ld);
		
	}
	@Test
	//≤‚ ‘ @Autowired @Qualifier
	public void test6(){
		String config="annotations.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Examplebean ex=ac.getBean("ex",Examplebean.class);
		ac.close();
		System.out.println(ex);
		
	}
	@Test
	//≤‚ ‘ @Resource
	public void test7(){
		String config="annotations.xml";
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Student stu=ac.getBean("stu",Student.class);
		System.out.println(stu);
		
	}
	@Test
	//≤‚ ‘ @Value
	public void test8(){
		String[] config={"annotations.xml","value.xml"};
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext(config);
		Car car=ac.getBean("car",Car.class);
		System.out.println(car);
		
	}
	
}
























