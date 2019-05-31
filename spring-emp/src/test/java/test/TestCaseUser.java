package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;



public class TestCaseUser {
	private UserDAO dao;
	@Before
	public void init(){
		String config="springmvc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("userDAO",UserDAO.class);
	}
	@Test
	public void test1() throws SQLException{
		User user=dao.findByUsername("test");
		System.out.println(user);
	}
	@Test
	public void test2() throws SQLException{
		User user=new User();
		user.setUsername("king");
		user.setPassword("1234");
		user.setName("布兰特");
		user.setGender("f");
		int i=dao.save(user);
		System.out.println("插入:"+i);
	}
	@Test
	public void test3(){
		User user=dao.findByUsername("king");
		user.setPassword("123456");
		int i=dao.modify(user);
		System.out.println("更新数据:"+i);
	}
	@Test
	public void test4(){
		List<User> user=dao.findAll();
		for(User e:user){
			System.out.println(e);
		}
	}
	
}






















