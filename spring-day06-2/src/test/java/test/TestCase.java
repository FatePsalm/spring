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
	//�������ӳ�
	public void test1() throws SQLException{
		String config="springjdbc.xml";
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		DataSource ds=ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	private ApplicationContext ac;
	private EmployeeDAO dao;
	
	@Before
	//���@before���εķ���,�����������Է���֮ǰ����
	public void init(){
		String config="springjdbc.xml";
		ac=new ClassPathXmlApplicationContext(config);
		dao=ac.getBean("empDAO",EmployeeDAO.class);
	}
	@Test
	//����save
	public void test2() {
		Employee e=new Employee();
		e.setName("���Ļ��");
		e.setSalary(2000);
		e.setAge(22);
		dao.save(e);
		
		
	}
	@Test
	//����save
	public void test3() {
		List<Employee> employee=dao.findAll();
		System.out.println(employee);
	}
	@Test
	//����
	public void test4() {
		Employee e=dao.findById(130);
		System.out.println(e);
	}
	@Test
	//����
	public void test5() {
		Employee e=dao.findById(130);
		e.setAge(e.getAge()*2);
		dao.update(e);
		System.out.println(e);
	}
	@Test
	//����
	public void test6() {
		dao.delete(130);
		
	}
}

























