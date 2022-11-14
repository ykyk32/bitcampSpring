package sample05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;
@Setter
public class SungJukModify implements SungJuk {
	
	
	private List<SungJukDTO2> list;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("수정할 이름 입력");
		String name = scan.next();
		int sw =0;
		for(SungJukDTO2 sungJukDTO2: list) {
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				System.out.println("이름 \t 국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2);
				
				
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
				
				sungJukDTO2.setTot(sungJukDTO2.getKor()+sungJukDTO2.getEng()+sungJukDTO2. getMath()); 
				sungJukDTO2.setAvg(sungJukDTO2.getTot()/3.0);
				 
				 System.out.println(name+"님 정보 수정");
			}
		}//for
		if(sw==0)System.out.println("찾고자 하는 이름이 없습니다.3");
	}
	

}
