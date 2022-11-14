package sample05;


import java.util.List;
import java.util.Scanner;

public class SungJukInput implements SungJuk {
	private SungJukDTO2 sungJukDTO2 = null;
	private List<SungJukDTO2> list;
public void setList(List<SungJukDTO2> list) {
		this.list = list;
	}

	//setter를 통해서   property사용 
	public void setSungJukDTO2(SungJukDTO2 sungJukDTO2) {
		this.sungJukDTO2 = sungJukDTO2;
	}

	

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
