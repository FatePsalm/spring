package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import entity.Employee;
@Repository("empDAO")
public class EmployeeDAO {
	@Autowired
	@Qualifier("jt")
	private JdbcTemplate jt;
	/*
	 * jdbcTemplate会将底层的异常统一转化为一些运行时异常(runtimeException)然后抛出
	 */
	public void save(Employee e){
		String sql="insert into t_emp values(t_emp_seq.nextval,?,?,?)";
		Object[] args={e.getName(),e.getSalary(),e.getAge()};
		jt.update(sql,args);
	}
	public List<Employee> findAll(){
		String sql="select * from t_emp"; 
		return jt.query(sql, new EmpRowMapper());
	}
	public Employee findById(int id){
		String sql="select * from t_emp where id=?";
		Object[] args={id};
		
		return jt.queryForObject(sql,args, new EmpRowMapper());
		
	}
	public void update(Employee e){
		String sql="update t_emp set name=?,salary=?,age=? where id=?";
		Object[] args={e.getName(),e.getSalary(),e.getAge(),e.getId()};
		jt.update(sql,args);
	}
	public void delete(int id){
		String sql="delete from t_emp where id=?";
		Object[] args={id};
		jt.update(sql,args);
	}
	class EmpRowMapper implements RowMapper<Employee>{
		//告诉jdbcTemplate如何处理结果集Resultset
		/*
		 * index:正在被处理的记录的下标
		 * 在该方法里面,告诉jdbcTemplate如何将记录转化成一个实体对象
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Employee e=new Employee();
			e.setId(rs.getInt("id"));
			e.setName(rs.getString("name"));
			e.setSalary(rs.getDouble("salary"));
			e.setAge(rs.getInt("age"));
			return e;
		}
		
	}
}















