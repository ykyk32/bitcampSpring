package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample03.SungJukDTO;
import sample03.SungJukImpl;
import sample05.SungJukDTO2;

//applicationContext.xml역활을 하는 자바 파일임 즉, 빈을 (생성)만들어주는 자바 파일
//환경설정의미 (일반 자바 파일이 아님을 알려주는 @)
@Configuration 
public class SpringConfiguration {
	//sample01
	@Bean
	public MessageBeanImpl messageBeanImpl(){
		return new MessageBeanImpl("사과");
	}
	//sample02
	@Bean
	public CalcAdd calcAdd(){
		return new CalcAdd(30,50);
	}
	
	@Bean(name="calcMul") //자바 문법 충실 버젼.
	public CalcMul gtCalcMul() {
		return new CalcMul();
	}
	
	//sample 05
	@Bean 
	public List<SungJukDTO2> arrayList(){
		return new ArrayList<SungJukDTO2>();
	}

}
/*
 빈으로 생성하는 방법
1. @component

2.  @Bean - 메소드 위에 쓴다
- return 되는 클래스를 빈으로 생성한다.
- 메소드의 이름은 반드시 id명으로 잡아야 한다

@Bean
메소드(){
	return new MessageBeanImpl("사과");
} 
@Bean
퍼블릭 클랙스이름 id명(){
	return new MessageBeanImpl("사과");
} 
 
 
 
 */
 