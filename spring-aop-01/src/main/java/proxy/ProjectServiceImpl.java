package proxy;

public class ProjectServiceImpl implements ProjectService {
	public void saveObject(Object object){
		System.out.println("saveObject");
		//dao.insertObject
		//ģ�ⷽ������ִ��
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void updateObject(Object object){
		System.out.println("updateObject");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
