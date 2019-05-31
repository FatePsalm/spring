package annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ap1")
//@Scope("prototype")多列
@Scope("singleton")
@Lazy(true)
public class Apple {
/*
 * 容器启动之后,会扫描指定的包及其子包下面所有的类,
 * 如果该类前面有一些特定的注解(比如@Component),则容器
 * 会将类纳入容器进行管理(相当于在配置文件里面有一个bean
 * )
 * 注意:
 * 该bean默认的id是首字母小写之后的类名
 */
	public Apple() {
		System.out.println("Apple()");
	}
	//初始方法
	@PostConstruct
	public void init(){
		System.out.println("init()");
	}
	//销毁方法
	@PreDestroy
	public void destroy(){
		System.out.println("destroy()");
	}
}



















