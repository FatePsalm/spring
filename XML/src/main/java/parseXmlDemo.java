import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用Dom4j解析XML文档
 * @author tarena
 *
 */
public class parseXmlDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 解析Xml文档大致流程
		 * 1:创建SAXReader
		 * 2:使用SAXReader读取Xml文档并返回一个Document对象.
		 * 这一步也是DOM解析耗时耗资源的地方
		 * 3:通过Document对象获取根元素
		 * 4:通过根元素按照XML文档结构逐级获取
		 * 子元素,已达到遍历XML文档数据的目的
		 */
		
		/*
		 * 将emplist.xml文档中的每个员工信息都解析成一个Emp实例,并存入到一个集合中
		 */
		try {
			//1
			SAXReader reader=new SAXReader();
			//2
			Document doc=reader.read(new File("emplist.xml"));
			/*
			 * 3
			 * Element的每一个实例用于表示一个
			 * XML文档中的一个元素(一对标签)
			 * 
			 * String getName()
			 * 获取当前元素名字(标签名)
			 * 
			 * Element element(String name)
			 * 获取当前元素中指定名字的子元素
			 * 
			 * List elements()
			 * 获取当前元素中的所有子元素
			 * 
			 * List elements(String name)
			 * 获取当前元素中的所有同名字元素
			 * 
			 * String getText()
			 * 获取当前元素中间的文本
			 * String elenmenText(String name)
			 * 获取当前标签下指定名字的子标签中间的
			 * 
			 * Sttribute attribute(String name)
			 * 获取当前标签中指定名字的属性
			 */
			
			Element root=doc.getRootElement();
			//用于保存XML文档中解析出来的所有员工信息
			List<Emp> emplist=new ArrayList<Emp>();
			/*
			 * 获取<list>标签中的所有子标签<Emp>,并将这些<emp>标签中的员工信息以若干emp实例
			 * 表示并存入empList集合
			 */
			List<Element> list=root.elements();
			for(Element empEleL:list ){
				//获取员工ID
				/*
				 * 获取ID属性
				 * attribute的每一个实例用于表示一个元素
				 * 中的一个属性
				 * 常用方法:
				 * String getNmae()
				 * 获取属性的名字
				 * 
				 * String getValue
				 * 获取属性的值
				 */
				int id =Integer.parseInt(empEleL.attribute("id").getValue());
//				System.out.println("ID="+id);
				//获取员工名字
				Element nameEle=empEleL.element("name");
				System.out.println(nameEle);
				String name =nameEle.getText();
				System.out.println(name);
				//获取员工年龄
				int age =Integer.parseInt(empEleL.elementText("age"));
				System.out.println(age);
				//获取员工性别
				
				Element genderEle=empEleL.element("gender");
				String gender =genderEle.getText();
				System.out.println(gender);
				//获取员工工资
				int salary =Integer.parseInt(empEleL.elementText("salary"));
				System.out.println(salary);
				Emp emp=new Emp(id,name,age,gender,salary);
				emplist.add(emp);
			}
			System.out.println(emplist);
			for(Emp e:emplist){
				System.out.println(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}











