package sec03.exam01;

public abstract class Phone {
	
	// 필드
	String owner;
	
	// 생성자
	Phone(String owner){
		this.owner = owner;
	}

	// 메소드
	void turnOn() {
		System.out.println("전원을 켭니다");
	}
	
	void turnOff() {
		System.out.println("전원을 끕니다");
	}
	
}
