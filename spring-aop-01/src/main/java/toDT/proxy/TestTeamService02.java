package toDT.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


import proxy.ProjectService;
import proxy.ProjectServiceImpl;

public class TestTeamService02 {
	public static void main(String[] args) {
		Object object = new Object();
		final TeamServiceImpl tService=new TeamServiceImpl();
		//目标对象1创建代理对象
		TeamService tServiceProxy=
		(TeamService) Proxy.newProxyInstance(tService.getClass().getClassLoader(),
				tService.getClass().getInterfaces(),
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						Object result=method.invoke(tService, args);
						return result;
					}
				});
		tServiceProxy.saveObject(object);
		//创建目标对象2
		final ProjectServiceImpl pServiceImpl=new ProjectServiceImpl();
		//为目标对象2创建代理对象
		ProjectService pServiceProxy=
		(ProjectService) Proxy.newProxyInstance(pServiceImpl.getClass().getClassLoader(),
				pServiceImpl.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						// TODO Auto-generated method stub
						long t1=System.currentTimeMillis();
						Object result= method.invoke(pServiceImpl, args);
						long t2=System.currentTimeMillis();
						System.out.println("消耗时间="+(t2-t1));
						return result;
					}
				});
		pServiceProxy.updateObject(object);
	}
	
}
