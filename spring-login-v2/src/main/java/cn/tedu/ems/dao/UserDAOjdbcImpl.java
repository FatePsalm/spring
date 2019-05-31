package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;
//@Repository("userDAO")
public  class UserDAOjdbcImpl implements UserDAO{
	/*
	 * �־û�ʵ�ֲ�
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
			//����־
			e.printStackTrace();
			//�����ϵͳ�쳣,Ӧ����ʾ�û��Ժ�����(���ֱ�ӽ�ϵͳ�쳣ֱ���׳�����)
			/*
			 * ע��
			 * ��ʾ�����ͳһ����ϵͳ�쳣,���û���Ӧ��ʾ,�����Ժ�����
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

}

































