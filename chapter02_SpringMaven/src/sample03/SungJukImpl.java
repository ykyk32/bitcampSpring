package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	@Autowired
	private SungJukDTO sungJukDTO = null;
	
	
	@Override
	public void calcTot() {
		sungJukDTO .setTot(sungJukDTO .getKor() + sungJukDTO .getEng() + sungJukDTO .getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO .setAvg(sungJukDTO.getTot()/(3.0));
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");	
		System.out.println(sungJukDTO);
		
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요 : ");
		sungJukDTO .setName(scan.next());
		System.out.print("국어 점수를 입력하세요 : ");
		sungJukDTO .setKor(scan.nextInt());
		System.out.print("영어 점수를 입력하세요 : ");
		sungJukDTO .setEng(scan.nextInt());
		System.out.print("수학 점수를 입력하세요 : ");
		sungJukDTO .setMath(scan.nextInt());
		
		calcTot();
		calcAvg();
		display();
	}

}
