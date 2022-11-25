package sample01;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//공통코드
//Aspect
public class LoggingAdvice {
	public void beforeTrace() {
		System.out.println("before trace");
	}
	public void afterTrace() {
		System.out.println("after trace");
	}
	public void trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//앞에 삽입될 코드
		String methodName =joinPoint.getSignature().toShortString();
		System.out.println("메소드 = " + methodName);
		
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		
		Object ob =joinPoint.proceed();//핵심코드 호출
		System.out.println("반환값 = " + ob);		
		
		//뒤에 삽입될 코드
		sw.stop();
		System.out.println("처리 시간 = "+ sw.getTotalTimeMillis()/1000 + "초");
	}
}
