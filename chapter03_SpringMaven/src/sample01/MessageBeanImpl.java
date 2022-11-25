package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Setter;

//Target

@Component
public class MessageBeanImpl implements MessageBean {
	
	private String str;
	
	@Autowired
	public void setStr(@Value("Have a nice day!!")String str) {
		this.str=str;		
	}
	

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore 메시지 = " + str);//핵심 코드
		
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000);//1초 딜레이해라- 기본단위가 1/1000초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("viewPrintBefore 메시지 = " + str);//핵심 코드
		
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter 메시지 = " + str);//핵심 코드
		
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000);//1초 딜레이해라- 기본단위가 1/1000초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("viewPrintAfter 메시지 = " + str);//핵심 코드
		
	}
	
	@Override
	public String showPrint() {
		System.out.println("showPrint 메시지 = " + str);//핵심 코드
		return "Hello Spring";
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000);//1초 딜레이해라- 기본단위가 1/1000초
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println("viewPrint 메시지 = " + str);//핵심 코드
		
	}
	
	
	@Override
	public void display() {
		System.out.println("display 메시지 = " + str);//핵심 코드
		
	}
	
}	
