import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/*
 * 使用DOM写出XML文档
 */
public class WriteXmlDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 写出XML文档的大致步骤
		 * 1:创建一个Document对象,表示一个空白文档
		 * 2:向Dpcument对象中添加根元素
		 * 3:向根元素中逐级添加子元素,已达到要生成的XML文档的结构内容
		 * 4:粗行间XmlWruter
		 * 5:将Document对象通过XmLWriter写出成XML文档
		 * 6:关闭XmlWriter
		 */
		List<Emp> empList=new ArrayList<Emp>();
		empList.add(new Emp(1,"张三",22,"男",4000));
		empList.add(new Emp(2,"张4",25,"男",5000));
		empList.add(new Emp(3,"张5",24,"男",6000));
		empList.add(new Emp(4,"张6",25,"男",7000));
		empList.add(new Emp(5,"张7",26,"男",8000));
		empList.add(new Emp(6,"张8",27,"男",9000));
		empList.add(new Emp(7,"张9",28,"男",11000));
		empList.add(new Emp(8,"张10",29,"男",12000));
		
		try {
			//1
			Document doc=DocumentHelper.createDocument();
			/*
			 * 2
			 * Document 提供了添加根元素的方法
			 * Element addElement(String name)
			 * 向当前文档中添加给定名字的根元素,并将
			 * 该元素以一个Element的实例返回,以便于对该根元素继续追加子元素等操作
			 * 需要注意,该方法只能调用一次,因为一个文档中只能有一个根元素
			 */
			Element root=doc.addElement("list");//只能有一个根
			
			//3
			for(Emp e:empList){
				/*
				 * 将每个emp实例以一个<emp>标签
				 * 添加到根元素中
				 */
				
				
				/*
				 * Element提供可想当前标签中添加
				 * 信息的相关方法
				 * 
				 * Element addElement(String name)
				 * 向当前标签中添加指定名字的子标签
				 * 并将值返回
				 * 
				 * Element addText(String text)
				 * 向当前标签中添加文本信息,返回值还是当前标签,这样做的目的也是便于对当前标签操作
				 * 
				 * 
				 * Element addAttribute (String name ,String value)
				 * 向当前标签中添加属性,返回值还是当前标签
				 */
				
				Element empEle=root.addElement("emp");
				//添加员工名字
				Element nameEle=empEle.addElement("name");
				nameEle.addText(e.getName());
				//添加年龄
				
				Element ageEle=empEle.addElement("age");
				ageEle.addText(e.getAge()+"");
				//添加性别
				
				Element genderEle=empEle.addElement("gender");
				genderEle.addText(e.getGender());
				//添加工资
				
				Element salaryEle=empEle.addElement("salary");
				salaryEle.addText(e.getSalary()+"");
				
				//添加ID
				empEle.addAttribute("id", e.getId()+"");
				
			}
			//4
			XMLWriter writer=new XMLWriter(new FileOutputStream("myemp.xml"),OutputFormat.createPrettyPrint());
			writer.write(doc);
			System.out.println("写出完毕");
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
