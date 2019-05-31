package proxy;
//��չ��(����ʵ��projectService�ӿڵ���������ӹ���)
//����ͨ����Ϊ������
/**
 * 1)�뱻������ʵ����ͬ�Ľӿ�
 * 2)�����뱻�������ʵ�ֹ��ܵ���չ
 * ��̬����:(�Լ�д��.�����Դ������ʵ���˹�ͬ�Ľӿ�)
 * 1)����:���Ժܷ����Ϊ�������ʵ�ֹ��ܵ���չ
 * 2)����:�����кܶ�ӿڵ�ʵ���඼��Ҫ�����Ĺ�����չ,
 * �Ǿ���Ҫ�����ܶ�������Ĵ�����,��ʱ�ͻ�Ƚ��鷳
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
		System.out.println("saveObject����ִ��ʱ��="+t);
	}

	public void updateObject(Object object) {
		// TODO Auto-generated method stub
		long t1=System.currentTimeMillis();
		projectService.updateObject(object);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("updateObject����ִ��ʱ��="+t);
	}

}
