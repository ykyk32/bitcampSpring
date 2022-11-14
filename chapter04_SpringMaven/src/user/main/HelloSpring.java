package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import user.service.UserService;

public class HelloSpring {

	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		UserService userService= null;
		int num;
		 while(true) {
			System.out.println();
			System.out.println("**********");
			System.out.println(" 1. 입력");
			System.out.println(" 2. 출력");
			System.out.println(" 3. 수정");
			System.out.println(" 4. 삭제");
			System.out.println(" 5. 끝");
			System.out.println("**********");
			System.out.print("번호 선택 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			
			if(num == 1) userService = (UserService) context.getBean("userInsertService");
			else if(num == 2) userService = (UserService) context.getBean("userSelectService");	
			else if(num == 3) userService = (UserService) context.getBean("userUpdateService");	
			else if(num == 4) userService = (UserService) context.getBean("userDeleteService");
			userService.execute();
		 }//while
	}
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		HelloSpring helloSpring= (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
	}

}
