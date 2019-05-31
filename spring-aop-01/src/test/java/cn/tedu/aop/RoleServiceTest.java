package cn.tedu.aop;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RoleServiceTest {
	ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx=new ClassPathXmlApplicationContext("spring-aop.xml");
	}
	@Test
	public void testSaveObject(){
		SysRoleService rService=(SysRoleService) ctx.getBean("sysRoleServiceImpl");
		Object object=new Object();
		int rows=rService.saveObject(object);
		Assert.assertEquals(1, rows);
	}
	@After
	public void destory(){
		ctx.close();
	}
}
