package cn.tedu.aop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SysResourceServiceTest {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-aop.xml");
	}
	@Test
	public void testSaveObject(){
		SysRoleService rService=(SysRoleService) ctx.getBean("sysRoleServiceImpl");
		Object object=new Object();
		rService.saveObject(object);
	}
	@After
	public void destory(){
		ctx.close();
	}
}
