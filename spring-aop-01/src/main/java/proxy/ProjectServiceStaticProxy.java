package proxy;
//扩展类(可以实现projectService接口的所有类添加功能)
//此类通常称为代理类
/**
 * 1)与被代理类实现相同的接口
 * 2)代理与被代理对象实现功能的扩展
 * 静态代理:(自己写类.它可以代理对象实现了共同的接口)
 * 1)优势:可以很方便的为代理对象实现功能的扩展
 * 2)劣势:假如有很多接口的实现类都需要这样的功能扩展,
 * 那就需要创建很多个这样的代理类,此时就会比较麻烦
 * */
public class ProjectServiceStaticProxy implements ProjectService{
	private ProjectService projectService;
	public ProjectServiceStaticProxy(ProjectService projectService){
		this.projectService=projectService;
		
	}
	public void saveObject(Object object) {
		// TODO Auto-generated method stub
		long t1=System.currentTimeMillis();
		projectService.saveObject(object);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("saveObject方法执行时间="+t);
	}

	public void updateObject(Object object) {
		// TODO Auto-generated method stub
		long t1=System.currentTimeMillis();
		projectService.updateObject(object);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("updateObject方法执行时间="+t);
	}

}
