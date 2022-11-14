package sample05;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpring {
	
	public void menu(ApplicationContext context) {
		int i;
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk =null;
		while(true) {
		
		System.out.println("****메뉴******");
		System.out.println("1번 입력");
		System.out.println("2번 출력");
		System.out.println("3번 수정");
		System.out.println("4번 삭제");
		System.out.println("5번 종료1");
		System.out.println("번호 선택");
		i = scan.nextInt();
		
		if(i==5) break;
		else if(i==1) 
			sungJuk= (SungJuk) context.getBean("sungJukInput");
			
		else if(i==2) 
			sungJuk=(SungJuk)context.getBean("sungJukOutput");	
			
		else if(i==3) 
			sungJuk=(SungJuk)context.getBean("sungJukModify");
			
		else if(i==4)
			sungJuk=(SungJuk)context.getBean("sungJukDelete");	
		
		sungJuk.execute();
		}

	}

	public static void main(String[] args) {
		//HelloSpring helloSpring = new HelloSpring();
		//helloSpring.menu();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring)context.getBean("helloSpring");
		helloSpring.menu(context);
		
		
		System.out.println("프로그램을 종료합니다.");
		
	
	
		
	

	}
	
}
