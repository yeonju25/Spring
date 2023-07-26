package polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
	public void init() {
		System.out.println("초기화하고 싶은 문장 기입");
	}
	
	public void destroy() {
		System.out.println("객체 소멸 시 작동하는 문장 기입");
	}

	public SamsungTV() {
		System.out.println("===> SamsungTV 객체 생성");
	}
	
	public SamsungTV(Speaker sony) {
		speaker = sony;
		System.out.println("===> SamsungTV(SonySpeaker sony) 객체 생성");
	}

	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		speaker.volumeUp();
	}

	public void volumeDown() {
		speaker.volumeDown();
	}
}
