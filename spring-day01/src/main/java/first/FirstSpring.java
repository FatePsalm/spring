package first;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	public static void main(String[] args) {
		
		String config="applicationContext.xml";
		/*
		 * ApplicationContext��һ���ӿ�,
		 * ClassPathXmlApplicationContext��һ��������,ʵ���������ӿ�
		 * ע��:����������·�������������ļ�,������������
		 */
		ApplicationContext ac=new ClassPathXmlApplicationContext(config);
		
		//System.out.println(ac);
		//ͨ��������ö���
		/*
		 * Apple.class:�������е�Apple���Ӧ��class����
		 */
		
		//Apple apple=ac.getBean("apple",Apple.class);
		Date date1=ac.getBean("date",Date.class);
		System.out.println(date1);
		
		date1.setTime(new Date().getTime()+500000);;
		Date date2=ac.getBean("date",Date.class);
		//System.out.println(apple);
		System.out.println(date1);
		System.out.println(date2);
		Calendar cal1=ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
		Date time1=ac.getBean("time1",Date.class);
		System.out.println("time1="+time1);
	}
}




















