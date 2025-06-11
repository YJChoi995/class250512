package sec04.exam03_return;

public class CarExample {
	public static void main(String[] args) {
		
		Car myCar = new Car();

		// 같은 코드
		myCar.gas = 5; 
		myCar.setGas(5); // Car의 setGas() 메소드 호출
		
		boolean gasState = myCar.isLeftGas(); // Car의 isLeftGas() 메소드 호출
		if(gasState) {
			System.out.println("출발합니다");
			myCar.run();
		}
		
		if(myCar.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다");
		} else {
			System.out.println("gas를 주입하세요");
		}
		
		
		Car2 c2 = new Car2();
		c2.setGas(3);
		c2.run();
		
		
	}
}
