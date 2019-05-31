package cn.tedu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)//���ֿ�ǰ����ִ��
@Aspect
@Component
public class TransactionAspect {
	//���������(���Ʒ�����һ������,����������������ʽ��ִ�����֪ͨ)
		/**
		 * ���е�֪ͨ�������Ϊ�ǿ�����չ��ҵ��*/
	@Pointcut("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void AspectJMethod(){
		
	}
	@Before("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void beforeMethod(JoinPoint point){
		String methodName=
		point.getSignature().getName();
		System.out.println(methodName+"������,��������");
	}
	@AfterReturning("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void returnMethod(){
		System.out.println("�ύ����");
	}
	@AfterThrowing("AspectJMethod()")
	public void throwMethod(){
		System.out.println("�ع�����");
		
	}
	@After("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void afterMethod(){
		System.out.println("�ر�����");
	}
}
