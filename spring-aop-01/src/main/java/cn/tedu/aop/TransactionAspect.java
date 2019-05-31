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
@Order(1)//数字靠前的先执行
@Aspect
@Component
public class TransactionAspect {
	//定义切入点(类似方法的一个集合,在满足这个切入点表达式上执行相关通知)
		/**
		 * 所有的通知可以理解为是可以扩展的业务*/
	@Pointcut("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void AspectJMethod(){
		
	}
	@Before("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void beforeMethod(JoinPoint point){
		String methodName=
		point.getSignature().getName();
		System.out.println(methodName+"打开连接,开启事物");
	}
	@AfterReturning("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void returnMethod(){
		System.out.println("提交事务");
	}
	@AfterThrowing("AspectJMethod()")
	public void throwMethod(){
		System.out.println("回滚事物");
		
	}
	@After("execution(* cn.tedu.aop.SysRoleServiceImpl.*(..))")
	public void afterMethod(){
		System.out.println("关闭连接");
	}
}
