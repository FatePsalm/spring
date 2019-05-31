import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��Dom4j����XML�ĵ�
 * @author tarena
 *
 */
public class parseXmlDemo {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ����Xml�ĵ���������
		 * 1:����SAXReader
		 * 2:ʹ��SAXReader��ȡXml�ĵ�������һ��Document����.
		 * ��һ��Ҳ��DOM������ʱ����Դ�ĵط�
		 * 3:ͨ��Document�����ȡ��Ԫ��
		 * 4:ͨ����Ԫ�ذ���XML�ĵ��ṹ�𼶻�ȡ
		 * ��Ԫ��,�Ѵﵽ����XML�ĵ����ݵ�Ŀ��
		 */
		
		/*
		 * ��emplist.xml�ĵ��е�ÿ��Ա����Ϣ��������һ��Empʵ��,�����뵽һ��������
		 */
		try {
			//1
			SAXReader reader=new SAXReader();
			//2
			Document doc=reader.read(new File("emplist.xml"));
			/*
			 * 3
			 * Element��ÿһ��ʵ�����ڱ�ʾһ��
			 * XML�ĵ��е�һ��Ԫ��(һ�Ա�ǩ)
			 * 
			 * String getName()
			 * ��ȡ��ǰԪ������(��ǩ��)
			 * 
			 * Element element(String name)
			 * ��ȡ��ǰԪ����ָ�����ֵ���Ԫ��
			 * 
			 * List elements()
			 * ��ȡ��ǰԪ���е�������Ԫ��
			 * 
			 * List elements(String name)
			 * ��ȡ��ǰԪ���е�����ͬ����Ԫ��
			 * 
			 * String getText()
			 * ��ȡ��ǰԪ���м���ı�
			 * String elenmenText(String name)
			 * ��ȡ��ǰ��ǩ��ָ�����ֵ��ӱ�ǩ�м��
			 * 
			 * Sttribute attribute(String name)
			 * ��ȡ��ǰ��ǩ��ָ�����ֵ�����
			 */
			
			Element root=doc.getRootElement();
			//���ڱ���XML�ĵ��н�������������Ա����Ϣ
			List<Emp> emplist=new ArrayList<Emp>();
			/*
			 * ��ȡ<list>��ǩ�е������ӱ�ǩ<Emp>,������Щ<emp>��ǩ�е�Ա����Ϣ������empʵ��
			 * ��ʾ������empList����
			 */
			List<Element> list=root.elements();
			for(Element empEleL:list ){
				//��ȡԱ��ID
				/*
				 * ��ȡID����
				 * attribute��ÿһ��ʵ�����ڱ�ʾһ��Ԫ��
				 * �е�һ������
				 * ���÷���:
				 * String getNmae()
				 * ��ȡ���Ե�����
				 * 
				 * String getValue
				 * ��ȡ���Ե�ֵ
				 */
				int id =Integer.parseInt(empEleL.attribute("id").getValue());
//				System.out.println("ID="+id);
				//��ȡԱ������
				Element nameEle=empEleL.element("name");
				System.out.println(nameEle);
				String name =nameEle.getText();
				System.out.println(name);
				//��ȡԱ������
				int age =Integer.parseInt(empEleL.elementText("age"));
				System.out.println(age);
				//��ȡԱ���Ա�
				
				Element genderEle=empEleL.element("gender");
				String gender =genderEle.getText();
				System.out.println(gender);
				//��ȡԱ������
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











