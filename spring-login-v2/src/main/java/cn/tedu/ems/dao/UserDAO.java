package cn.tedu.ems.dao;

import cn.tedu.ems.entity.User;

public interface UserDAO {
	/*
	 * 持久化接口
	 */
	public User findByUsername(String username);
}
