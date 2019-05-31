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
	 * ҵ��ʵ����
	 * @see cn.tedu.ems.service.LoginService#checkLogin(java.lang.String, java.lang.String)
	 */
	//Setע��
	@Resource(name="userDAO")
	private UserDAO dao;
	
	public User checkLogin(String username, String pwd) {
		// TODO Auto-generated method stub
		
		User user=dao.findByUsername(username);
		System.out.println("ִ��findByUsername()"+user);
		if(user==null){
			System.out.println("�û���������");
			/*
			 * �û���������
			 * �����׳�һ��Ӧ���쳣
			 * ע
			 * ��ʾ���ڲ���Ӧ���쳣֮��,
			 * ��Ҫ��ȷ��ʾ�û���ȡ�����Ĳ���
			 */
			throw new ApplicationException("�û���������");
		}
		if(!user.getPwd().equals(pwd)){
			throw new ApplicationException("���벻��ȷ");
		}
		//��¼��֤ͨ��
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















