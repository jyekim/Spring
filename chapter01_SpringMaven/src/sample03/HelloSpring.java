package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MessageBean messagebean = (MessageBean) context.getBean("messageBean"); //부모 = 자식
		messagebean.sayHello("Spring");
		
		MessageBean messagebean2 = context.getBean("messageBean", MessageBean.class); //부모 = 자식
		messagebean.sayHello("Spring");
		
		MessageBean messagebean3 = (MessageBean) context.getBean("messageBean"); //부모 = 자식
		messagebean.sayHello("Spring");
		
	}

}
