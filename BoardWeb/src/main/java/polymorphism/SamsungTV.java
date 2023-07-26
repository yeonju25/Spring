package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	
	// 하나면 @Autowired만 쓰면 됨, 두개 이상이면 @Qualifier로 하나를 지정
	@Autowired	
	@Qualifier("apple")
	private Speaker speaker;
	private int price;
	
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public SamsungTV(Speaker speaker) {	
		this.speaker = speaker;
		System.out.println("SamsungTV(Speaker speaker) 객체 생성");
	}
	
	public SamsungTV(Speaker speaker, int price) {	
		this.speaker = speaker;
		this.price = price;
		System.out.println("SamsungTV(Speaker speaker, int price) 객체 생성");
	}
	
	// 기본 생성자
	public SamsungTV() {	// 객체 생성될 때마다 작동
		System.out.println("SamsungTV 객체 생성");
	}
	
	public void initMethod() {	// 초기설정, 객체가 처음 생길 때 한번만 작동
		System.out.println("initMethod()");
	}
	
	public void destoryMethod() {	// 객체가 소멸될 때 작동
		System.out.println("destoryMethod()");
	}
	
	
	
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원 Off");
	}
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("price : " + this.price);
//		System.out.println("SamsungTV 볼륨 Up");
	}
	public void volumeDown() {
		speaker.volumeDown();
//		System.out.println("SamsungTV 볼륨 Down");
	}
}
