package cn.tedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//将此对象声明为一个切面(本质上就是一个类)
@Order(1)
@Aspect
@Component//声明这个组件(可以由Spring管理)
public class TimingAspect {
	
	//使用@before声明一个前置通知
	//bean(sysRoleServiceImpl)称之为一个切入点
	@Before("bean(*ServiceImpl)")
	public void timeBefore(){
		long start=System.currentTimeMillis();
		System.out.println("start="+start);
	}
	@AfterReturning("bean(sysRoleServiceImpl)")
	public void returnMethod(){
		long t=System.currentTimeMillis();
		System.out.println("returnMethod正常返回="+t);
	}
	@AfterThrowing("bean(sysRoleServiceImpl)")
	public void throwMethod(){
		long t=System.currentTimeMillis();
		System.out.println("returnMethod异常返回="+t);
	}
	@After("bean(sysRoleServiceImpl)")
	public void timeAfter(){
		long end=System.currentTimeMillis();
		System.out.println("end time="+end);
	}
}
