package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		// 1. Spring 컨테이너 구동
		
		//xml설정 기반
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		// applicationContext.xml불러와서 객체 생성하고 initmethod 작동
		
		
//		// 웹기반 스프링
//		AbstractApplicationContext factory2 = 
//				new XmlWebApplicationContext("applicationContext.xml");

		// 2. 스프링 컨테이너로부터 필요한 객체 요청
		TV tv1 = (TV)factory.getBean("tv");
		
//		TV tv2 = (TV)factory.getBean("tv");
//		TV tv3 = (TV)factory.getBean("tv");
		// 3번 불러왔지만 하나의 객체에 tv1, tv2, tv3이 다 접근함 
		// --> applicationContext.xml bean의 scope 기본이 싱글톤이기 때문에
		// scope를 prototype으로 바꾸고 실행하니 객체 각각 만들어서 총 3번 생성됨 
		// 여기까지 bean이 이 내용일 때 한 것 : <bean id="tv" class="polymorphism.SamsungTV" init-method="initMethod" destroy-method="destoryMethod" scope="prototype">
		
		tv1.powerOn();
		tv1.volumeUp();
		
		
		factory.close();
		
		
		
		
	}

}

