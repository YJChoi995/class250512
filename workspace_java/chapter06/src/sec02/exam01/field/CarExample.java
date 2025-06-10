package sec02.exam01.field;

public class CarExample {
	
	static int a = 1;

	public static void main(String[] args) {
		
		// 객체(클래스) 생성
		Car myCar = new Car();
		
		// 필드값 읽기
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		System.out.println("색깔: " + myCar.color);
		System.out.println("최고속도: " + myCar.maxSpeed);
		System.out.println("현재속도: " + myCar.speed);
		
		// 필드값 변경
		myCar.speed = 60;
		System.out.println("현재속도: " + myCar.speed);
		
		myCar.company = "기아자동차";
		myCar.model = "모닝";
		System.out.println("제작회사: " + myCar.company);
		System.out.println("모델명: " + myCar.model);
		
		Car myCar2 = new Car();
		System.out.println("제작회사: " + myCar2.company);
		
		System.out.println("a: " + a);
		
	}
}
