package cn.tedu.ems.dao;

import cn.tedu.ems.entity.User;

public interface UserDAO {
	/*
	 * �־û��ӿ�
	 */
	public User findByUsername(String username);
}
