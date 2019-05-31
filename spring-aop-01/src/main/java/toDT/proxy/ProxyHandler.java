package toDT.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �������Ĵ������,���಻�Ǵ������
 * */
public class ProxyHandler implements InvocationHandler{
	/**
	 * Ŀ�����(ҪΪ�˶�������������)
	 * */
	private Object target;
	/**
	 * ����Ŀ�����Ĵ������
	 * */
	public Object newProxy(Object target){
		 this.target=target;
		 //ΪĿ����󴴽��������(�����Ƕ�̬)
		 //�ײ㴴��������������Ҳ���뱻�������ʵ����ͬ�Ľӿ�
		 return Proxy.newProxyInstance(target.getClass().getClassLoader(),//��ļ�����
				 target.getClass().getInterfaces(),//Ŀ����ʵ�ֵĽӿ�
				 this);//InvocationHandler
		
	}
	/**
	 * ��ִ��Ŀ����󷽷�ʱ,��Ĭ�ϵ��ô˷���
	 * @param proxy�������
	 * @param method����������(ͨ���˶���ִ��Ŀ�귽��)
	 * @param args Ŀ�귽���е�ʵ�ʲ�����ֵ
	 * */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long t1=System.currentTimeMillis();
		//��仰�ĺ�����Ҫִ��Ŀ�����(target)��Method
		Object result=method.invoke(target, args);
		long t2=System.currentTimeMillis();
		System.out.println(method.getName()+"����ִ��ʱ��"+(t2-t1));
		return result;
	}

}
















