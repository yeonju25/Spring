package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. 스프링 컨테이너를 구동함.
		// applicationContext.xml 이 파일을 스프링 컨테이너가 읽어오면서 bean 모두 생성해서 컨테이너 메모리 공간에 올림
		AbstractApplicationContext factory = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean("tv");
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		// 이제 쓸 일 없으면 컨테이너 닫아줘야 함
		factory.close();
	}
}