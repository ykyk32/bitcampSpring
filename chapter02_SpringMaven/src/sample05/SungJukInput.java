package sample05;


import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Autowired
	private SungJukDTO2 sungJukDTO2 = null;
	@Autowired
	@Qualifier("arrayList")//이 타입만 들어 올거라고 정확하게 찝어 줘야 한다. list는 인터페이스로 어느 타입이 올지 모르기에 꼭 찝어줘야 에러가 안남
	private List<SungJukDTO2> list;
	//private ArrayList<SungJukDTO2> list;//@qualifier를 안쓰려면 이렇게 ArrayList로 딱 집어서 써야함
	/*
	 * 스프링 컨테이너가 빈으로(@Bean @Component) 생성된것들 중에서 SungJukDTO2 타입을 찾아서 자동으로 주입해라 ->세터 게터 없이 @Autowired사용해서
	 */
	
	
	
	

	

	Scanner scan = new Scanner(System.in);
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		System.out.println("이름 입력");
		String name = scan.next();
		System.out.println("국어");
		int kor = scan.nextInt();
		System.out.println("영어");
		int eng=scan.nextInt();
		System.out.println("수학");
		int math=scan.nextInt();
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
				
		 sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2.
		 getMath()); sungJukDTO2.setAvg(sungJukDTO2.getTot()/3.0);
		 
		
		list.add(sungJukDTO2);
		//이러면 싱글톤으로 같은 값을 list생긴것만큼 반복하기에 prototype으......

		//db
		
		//응답
		System.out.println(name +"입력 되었습니다.");
		 System.out.println(list);
		/*
		 * for (SungJukDTO2 sungJukDTO2 : list) { System.out.println(sungJukDTO2); }
		 */

	}

}
