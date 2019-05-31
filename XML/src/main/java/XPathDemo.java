import java.io.FileInputStream;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * ʹ��xpath����XML��Ϣ
 * @author tarena
 *
 */
public class XPathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SAXReader reader=new SAXReader();
			Document doc=reader.read(new FileInputStream("myemp.xml"));
			String xpath="/list/emp[gender='��' and salary>1000]/name";
			List<Element> list=doc.selectNodes(xpath);
			for(Element e:list){
				System.out.println(e.getText());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

