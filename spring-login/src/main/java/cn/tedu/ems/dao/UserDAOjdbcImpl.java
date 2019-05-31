package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;
//@Repository("userDAO")
public  class UserDAOjdbcImpl implements UserDAO{
	/*
	 * 持久化实现层
	 */
	@Resource(name="ds")
	public DataSource ds;
	public User findByUsername(String username){
		User user=null;
		Connection conn=null;
		try {
			conn=ds.getConnection();
			String sql="select * from t_user where username=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPwd(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setGender(rs.getString("gender"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//记日志
			e.printStackTrace();
			//如果是系统异常,应该提示用户稍后重试(这儿直接将系统异常直接抛出即可)
			/*
			 * 注释
			 * 表示层可以统一处理系统异常,给用户相应提示,比如稍后重试
			 */
				
			throw new RuntimeException();
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
		return user;
	}
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}

































