package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Employee;

public class TestCase {
	@Test
	//测试连接池
	public void test1() throws SQLException{
		String config="springjdbc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	private ApplicationContext ac;
	private EmployeeDAO dao;
	
	@Before
	//添加@before修饰的方法,会在其他测试方法之前运行
	public void init(){
		String config="springjdbc.xml";
		ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("empDAO",EmployeeDAO.class);
	}
	@Test
	//测试save
	public void test2() {
		Employee e=new Employee();
		e.setName("宇文画戟");
		e.setSalary(2000);
		e.setAge(22);
		dao.save(e);
		
		
	}
	@Test
	//测试save
	public void test3() {
		List<Employee> employee=dao.findAll();
		System.out.println(employee);
	}
	@Test
	//测试
	public void test4() {
		Employee e=dao.findById(130);
		System.out.println(e);
	}
	@Test
	//测试
	public void test5() {
		Employee e=dao.findById(130);
		e.setAge(e.getAge()*2);
		dao.update(e);
		System.out.println(e);
	}
	@Test
	//测试
	public void test6() {
		dao.delete(130);
		
	}
}

























