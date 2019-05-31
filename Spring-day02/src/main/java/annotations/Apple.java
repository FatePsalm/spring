package annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ap1")
//@Scope("prototype")����
@Scope("singleton")
@Lazy(true)
public class Apple {
/*
 * ��������֮��,��ɨ��ָ���İ������Ӱ��������е���,
 * �������ǰ����һЩ�ض���ע��(����@Component),������
 * �Ὣ�������������й���(�൱���������ļ�������һ��bean
 * )
 * ע��:
 * ��beanĬ�ϵ�id������ĸСд֮�������
 */
	public Apple() {
		System.out.println("Apple()");
	}
	//��ʼ����
	@PostConstruct
	public void init(){
		System.out.println("init()");
	}
	//���ٷ���
	@PreDestroy
	public void destroy(){
		System.out.println("destroy()");
	}
}



















