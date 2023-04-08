package sample05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample04.Calc;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//접근은 부모로 접근하면 됨
	
		SungJuk sungJuk = (SungJuk) context.getBean("sungJukImpl");
		sungJuk.calc();
		sungJuk.display();
		
	}

}
