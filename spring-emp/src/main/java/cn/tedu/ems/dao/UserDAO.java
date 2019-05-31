package cn.tedu.ems.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;
@Repository("userDAO")
public interface UserDAO {
	public User findByUsername(String username);
	public int save(User user);
	public int modify(User user);
	public List<User> findAll();
}
