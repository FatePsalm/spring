package cn.tedu.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;


@Repository("userDAO")
public class UserDAOSpringJdbcImpl implements UserDAO{
	//@Autowired
	//@Qualifier("jt")
	@Resource(name="jt")
	private JdbcTemplate jt;
	public User findByUsername(String username) {
		// TODO Auto-generated method stub 
		String sql="select * from t_user where username=?";
		Object[] args={username};
		User user=null;
		try{
			user=jt.queryForObject(sql,args, new EmpRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		return user;
	}
	class EmpRowMapper implements RowMapper<User>{
		//����jdbcTemplate��δ�������Resultset
		/*
		 * index:���ڱ�����ļ�¼���±�
		 * �ڸ÷�������,����jdbcTemplate��ν���¼ת����һ��ʵ�����
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			User e=new User();
			e.setId(rs.getInt("id"));
			e.setUsername(rs.getString("username"));
			e.setPwd(rs.getString("password"));
			e.setName(rs.getString("name"));
			e.setGender(rs.getString("gender"));
			System.out.println(e);
			return e;
		}
		
	}
}












