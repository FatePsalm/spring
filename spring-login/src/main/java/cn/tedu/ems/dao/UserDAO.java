package cn.tedu.ems.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import annotations.MyBatisRepository;
import cn.tedu.ems.entity.User;
@Repository("userDAO")
@MyBatisRepository
public interface UserDAO {
	/*
	 * �־û��ӿ�
	 */
	public User findByUsername(String username);
	public List<User> findAll();
}
