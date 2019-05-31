package cn.tedu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
//���˶�������Ϊһ������(�����Ͼ���һ����)
@Order(1)
@Aspect
@Component//����������(������Spring����)
public class TimingAspect {
	
	//ʹ��@before����һ��ǰ��֪ͨ
	//bean(sysRoleServiceImpl)��֮Ϊһ�������
	@Before("bean(*ServiceImpl)")
	public void timeBefore(){
		long start=System.currentTimeMillis();
		System.out.println("start="+start);
	}
	@AfterReturning("bean(sysRoleServiceImpl)")
	public void returnMethod(){
		long t=System.currentTimeMillis();
		System.out.println("returnMethod��������="+t);
	}
	@AfterThrowing("bean(sysRoleServiceImpl)")
	public void throwMethod(){
		long t=System.currentTimeMillis();
		System.out.println("returnMethod�쳣����="+t);
	}
	@After("bean(sysRoleServiceImpl)")
	public void timeAfter(){
		long end=System.currentTimeMillis();
		System.out.println("end time="+end);
	}
}
