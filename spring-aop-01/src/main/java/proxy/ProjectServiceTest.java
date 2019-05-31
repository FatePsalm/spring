package proxy;

public class ProjectServiceTest {
	public static void main(String[] args) {
		ProjectService projectService;
		ProjectServiceImpl projectServiceImpl=new ProjectServiceImpl();
		Object object=new Object();
//		projectServiceImpl.saveObject(object);
//		projectServiceImpl.updateObject(object);
		projectService =new ProjectServiceStaticProxy(projectServiceImpl);
		projectService.saveObject(object);
		projectService.updateObject(object);
	}
}
