package toDT.proxy;

import proxy.ProjectService;
import proxy.ProjectServiceImpl;

public class TestTeamService {
	public static void main(String[] args) {
		//目标对象
		TeamService tService=new TeamServiceImpl();
		Object object=new Object();
		tService.saveObject(object);
		tService.updateObject(object);
		//========================
		//创建代理对象
		ProxyHandler proxyHandler=new ProxyHandler();
		TeamService proxyObject=(TeamService) proxyHandler.newProxy(tService);
		proxyObject.saveObject(object);
		proxyHandler.equals(object);
		//创建代理对象(ProjectServiceImpl)
		ProjectService pService=new ProjectServiceImpl();
		ProjectService pserviceproxy=(ProjectService) proxyHandler.newProxy(pService);
		pserviceproxy.saveObject(proxyObject);
		pserviceproxy.updateObject(proxyObject);
	}
}
