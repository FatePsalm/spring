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
			return "�û���δռ��";
		}
		return "�û�����ռ��";
	}
	public boolean checkPassword(String username,String password){
		User resultUser=dao.findByUsername(username);
		if(resultUser==null){
			throw new ApplicationException("�û�������");
		}
		if(!resultUser.getPassword().equals(password)){
			throw new ApplicationException("���벻��ȷ");
		}
		return true;
	}
}
