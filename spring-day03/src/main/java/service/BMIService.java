package service;
/*
 * ģ��
 * ��װҵ���߼��Ĵ���
 */
public class BMIService {
	public String bmi(double height,double weight){
		String status="����";
		//����bmiָ��
		double bmi=weight/height/height;
		//����bmiָ��,�ж�����״��
		if(bmi>25){
			status="����";
			System.out.println(status);
			return status;
		}
		if(bmi<19){
			status="����";
			System.out.println(status);
			return status;
		}
		
		return status;
		
		
	}
}
