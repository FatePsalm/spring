package cn.tedu.ems.service;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	/*
	 * 业务实现类
	 * @see cn.tedu.ems.service.LoginService#checkLogin(java.lang.String, java.lang.String)
	 */
	//Set注入
	@Resource(name="userDAO")
	private UserDAO dao;
	
	public User checkLogin(String username, String pwd) {
		// TODO Auto-generated method stub
		
		User user=dao.findByUsername(username);
		System.out.println("执行findByUsername()"+user);
		if(user==null){
			System.out.println("用户名不存在");
			/*
			 * 用户名不存在
			 * 可以抛出一个应用异常
			 * 注
			 * 表示层在捕获到应用异常之后,
			 * 需要明确提示用户采取正常的操作
			 */
			throw new ApplicationException("用户名不存在");
		}
		if(!user.getPwd().equals(pwd)){
			throw new ApplicationException("密码不正确");
		}
		//登录验证通过
		return user;
	}
	public boolean checkNumber(String number,String action){
		if(number.equals(action)){
			
		}else{
			
			return false;
		}
		return true;
		
	}

}















