package sample05;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import lombok.Setter;
@Setter
public class SungJukDelete implements SungJuk {
	private List<SungJukDTO2> list;
	
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("삭제할 이름 입력");
		String name = scan.next();
		int sw=0;
		Iterator<SungJukDTO2> it = list.iterator();
		//it.hasNext() 값이 있다 - true  없다 -false
		while(it.hasNext()) {
			SungJukDTO2 sungJukDTO2 = it.next();
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				it.remove();
				System.out.println(name + "님의 정보 삭제");
			}
		}//while
		
		if(sw==0) System.out.println("찾는 이름이 없음");
		/*
		 * for(SungJukDTO2 sungJukDTO2: list) { if(sungJukDTO2.getName().equals(name)) {
		 * list.remove(sungJukDTO2); } }
		  list로 하면 오류남 iterator써줘야함 */

	}

}
