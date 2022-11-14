package sample05;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Scope("prototype")
@Getter @Setter//이거 없애면 안에다 다시 getter setter만들어야 해서 둬야 함 
//list는 annotaion으로(component)잡을 수 없기에 SpringConf에서 해야함
public class SungJukDTO2 {
	
		private int kor,eng,math,tot;
		private String name;
		private double avg;
		@Override
		public String toString() {
			return name +"\t"
					+kor +"\t"
					+eng +"\t"
					+math +"\t"
					+tot +"\t"
					+String.format("%.2f", avg);
		}
		
		


}
