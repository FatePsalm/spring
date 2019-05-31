package cn.tedu.aop;

import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	public int saveObject(Object object) {
		System.out.println("saveObject");
		return 1;
	}

	public int updateObject(Object object) {
		System.out.println("updateObject");
		return 1;
	}
	
}
