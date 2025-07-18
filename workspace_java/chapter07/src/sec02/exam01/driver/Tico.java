package sec02.exam01.driver;

public class Tico extends Car {
	
	@Override
	void run() {
		System.out.println("티코 주행 중");
	}
	
	void autoRun() {
		System.out.println("티코 자율 주행 중");
	}

}
