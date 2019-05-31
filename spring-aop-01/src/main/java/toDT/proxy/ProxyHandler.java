package toDT.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象的处理对象,此类不是代理对象
 * */
public class ProxyHandler implements InvocationHandler{
	/**
	 * 目标对象(要为此对象产生代理对象)
	 * */
	private Object target;
	/**
	 * 返回目标对象的代理对象
	 * */
	public Object newProxy(Object target){
		 this.target=target;
		 //为目标对象创建代理对象(这样是动态)
		 //底层创建的这个代理对象也会与被代理对象实现相同的接口
		 return Proxy.newProxyInstance(target.getClass().getClassLoader(),//类的加载器
				 target.getClass().getInterfaces(),//目标类实现的接口
				 this);//InvocationHandler
		
	}
	/**
	 * 在执行目标对象方法时,会默认调用此方法
	 * @param proxy代理对象
	 * @param method代理方法对象(通过此对象执行目标方法)
	 * @param args 目标方法中的实际参数的值
	 * */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long t1=System.currentTimeMillis();
		//这句话的含义是要执行目标对象(target)的Method
		Object result=method.invoke(target, args);
		long t2=System.currentTimeMillis();
		System.out.println(method.getName()+"方法执行时间"+(t2-t1));
		return result;
	}

}
















