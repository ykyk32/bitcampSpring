package sample03;

import java.nio.file.FileSystemAlreadyExistsException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	      
		MessageBean messageBean = (MessageBean)context.getBean("messageBean");//자식=부모
		messageBean.sayHello("Spring");
		System.out.println();

		MessageBean messageBean2 = context.getBean("messageBean",MessageBean.class);//자식=부모
		messageBean2.sayHello("Spring");
		System.out.println();
		
		/* 싱글톤이라는 의미
		 MessageBeanKo 기본 생성자
		num = 1
		안녕하세요 Spring

		num = 2
		안녕하세요 Spring
 
		 */
		
		
	}

}
