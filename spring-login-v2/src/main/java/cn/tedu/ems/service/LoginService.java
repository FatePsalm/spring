package cn.tedu.ems.service;


import cn.tedu.ems.entity.User;

/*
 * ҵ���ӿ�
 */
public interface LoginService {
	public User checkLogin(String username,String pwd);
	public boolean checkNumber(String number, String action);
}
