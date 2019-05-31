package service;
/*
 * 模型
 * 封装业务逻辑的处理
 */
public class BMIService {
	public String bmi(double height,double weight){
		String status="正常";
		//计算bmi指数
		double bmi=weight/height/height;
		//依据bmi指数,判断身体状况
		if(bmi>25){
			status="过重";
			System.out.println(status);
			return status;
		}
		if(bmi<19){
			status="过轻";
			System.out.println(status);
			return status;
		}
		
		return status;
		
		
	}
}
