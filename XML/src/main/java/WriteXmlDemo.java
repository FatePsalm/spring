import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/*
 * ʹ��DOMд��XML�ĵ�
 */
public class WriteXmlDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * д��XML�ĵ��Ĵ��²���
		 * 1:����һ��Document����,��ʾһ���հ��ĵ�
		 * 2:��Dpcument��������Ӹ�Ԫ��
		 * 3:���Ԫ�����������Ԫ��,�ѴﵽҪ���ɵ�XML�ĵ��Ľṹ����
		 * 4:���м�XmlWruter
		 * 5:��Document����ͨ��XmLWriterд����XML�ĵ�
		 * 6:�ر�XmlWriter
		 */
		List<Emp> empList=new ArrayList<Emp>();
		empList.add(new Emp(1,"����",22,"��",4000));
		empList.add(new Emp(2,"��4",25,"��",5000));
		empList.add(new Emp(3,"��5",24,"��",6000));
		empList.add(new Emp(4,"��6",25,"��",7000));
		empList.add(new Emp(5,"��7",26,"��",8000));
		empList.add(new Emp(6,"��8",27,"��",9000));
		empList.add(new Emp(7,"��9",28,"��",11000));
		empList.add(new Emp(8,"��10",29,"��",12000));
		
		try {
			//1
			Document doc=DocumentHelper.createDocument();
			/*
			 * 2
			 * Document �ṩ����Ӹ�Ԫ�صķ���
			 * Element addElement(String name)
			 * ��ǰ�ĵ�����Ӹ������ֵĸ�Ԫ��,����
			 * ��Ԫ����һ��Element��ʵ������,�Ա��ڶԸø�Ԫ�ؼ���׷����Ԫ�صȲ���
			 * ��Ҫע��,�÷���ֻ�ܵ���һ��,��Ϊһ���ĵ���ֻ����һ����Ԫ��
			 */
			Element root=doc.addElement("list");//ֻ����һ����
			
			//3
			for(Emp e:empList){
				/*
				 * ��ÿ��empʵ����һ��<emp>��ǩ
				 * ��ӵ���Ԫ����
				 */
				
				
				/*
				 * Element�ṩ���뵱ǰ��ǩ�����
				 * ��Ϣ����ط���
				 * 
				 * Element addElement(String name)
				 * ��ǰ��ǩ�����ָ�����ֵ��ӱ�ǩ
				 * ����ֵ����
				 * 
				 * Element addText(String text)
				 * ��ǰ��ǩ������ı���Ϣ,����ֵ���ǵ�ǰ��ǩ,��������Ŀ��Ҳ�Ǳ��ڶԵ�ǰ��ǩ����
				 * 
				 * 
				 * Element addAttribute (String name ,String value)
				 * ��ǰ��ǩ���������,����ֵ���ǵ�ǰ��ǩ
				 */
				
				Element empEle=root.addElement("emp");
				//���Ա������
				Element nameEle=empEle.addElement("name");
				nameEle.addText(e.getName());
				//�������
				
				Element ageEle=empEle.addElement("age");
				ageEle.addText(e.getAge()+"");
				//����Ա�
				
				Element genderEle=empEle.addElement("gender");
				genderEle.addText(e.getGender());
				//��ӹ���
				
				Element salaryEle=empEle.addElement("salary");
				salaryEle.addText(e.getSalary()+"");
				
				//���ID
				empEle.addAttribute("id", e.getId()+"");
				
			}
			//4
			XMLWriter writer=new XMLWriter(new FileOutputStream("myemp.xml"),OutputFormat.createPrettyPrint());
			writer.write(doc);
			System.out.println("д�����");
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
