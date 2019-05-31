package cn.tedu.ems.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;
@Service("checkUsername")
public class CheckUsernameTeml implements CheckUsername {
	@Resource(name="userDAO")
	private UserDAO dao;
	public String check(String username){
		User result=dao.findByUsername(username);
		if(result!=null){
			
		}else{
			return "用户名未占用";
		}
		return "用户名被占用";
	}
	public boolean checkPassword(String username,String password){
		User resultUser=dao.findByUsername(username);
		if(resultUser==null){
			throw new ApplicationException("用户名错误");
		}
		if(!resultUser.getPassword().equals(password)){
			throw new ApplicationException("密码不正确");
		}
		return true;
	}
}
