package sec03.exam01_constructor;

public class Car {
//	// 생성자(constructor)
//	Car(){ // 리턴 타입이 없음. 클래스명과 동일한 메소드	
//		System.out.println("Car 생성자 실행");
//	}	 
	
	// 생성자를 생략한 경우
	// 기본 생성자가 자동 완성 된다
	// 생성자가 하나라도 선언되어 있으면
	// 기본 생성자는 만들어지지 않는다
	
	// 기본 생성자 //
	String model;
	String color;
	int maxSpeed;
	
	Car(){
	// 보통 생성자는 필드 값 초기화 하는데 많이 사용된다
		color = "빨강";
	}
	
	// 생성자 오버로딩
//	Car(String c){
//		color = c;
//	}
	
	//  다른 생성자 호출 : this()
	Car(String c){
//		color = c;
//		model = "아반떼";
//		maxSpeed = 240;
		
		this("아반떼", c, 240); // this는 무조건 첫번째 줄에 있어야함
	}
	
	Car(String m, String c, int ms){
		model = m;
		color = c;
		maxSpeed = ms;
	}
	
//	void setColor() {
//		String color;
//		color = "빨강";
//	}

	void setColor(String color) {
//		this.color = "빨강";
		this.color = color;
	}	
	
	
}
