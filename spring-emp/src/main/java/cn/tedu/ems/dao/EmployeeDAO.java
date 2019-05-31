package cn.tedu.ems.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.Employee;

@Repository("empDAO")
public interface EmployeeDAO {
	public int save(Employee emp);
	public Employee findByUsername(Integer id);
	public int modify(Employee emp);
	public int delete(int id);
	public List<Employee> findAll();
}
