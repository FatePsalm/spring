package cn.tedu.ssh1.action;

import cn.tedu.ssh1.vo.UserVo;

public class UserAction {
	
	private UserVo user;
	
	public UserVo getUser() {
		return user;
	}
	
	public void setUser(UserVo user) {
		this.user = user;
	}

	// 控制器方法名可以是任何名
	public String add(){
		System.out.println(user);
		return "success";
	}
	
	
}





