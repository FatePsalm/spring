package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import cn.tedu.ems.dao.EmployeeDAO;
import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.Employee;
import cn.tedu.ems.entity.User;



public class TestCaseEmployee {
	private EmployeeDAO dao;
	@Before
	public void init(){
		String config="springmvc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("empDAO",EmployeeDAO.class);
	}
	@Test
	public void test1(){
		Employee emp=dao.findByUsername(122);
		System.out.println(emp);
	}
	@Test
	public void test2(){
		Employee emp=dao.findByUsername(1);
		System.out.println(emp);
	}
	@Test
	public void test3(){
		Employee emp=new Employee();
		emp.setName("思密达");
		emp.setSalary(2000);
		emp.setAge(22);
		int i=dao.save(emp);
		System.out.println("插入:"+i);
	}
	@Test
	public void test4(){
		Employee emp=dao.findByUsername(122);
		emp.setAge(500);
		int i=dao.modify(emp);
		System.out.println("更新了:"+i);
	}
	@Test
	public void test5(){
		int i=dao.delete(101);
		System.out.println("更新了:"+i);
	}
	@Test
	public void test6(){
		List<Employee> emp=dao.findAll();
		for(Employee e:emp){
			System.out.println(e);
		}
	}
	
}






















