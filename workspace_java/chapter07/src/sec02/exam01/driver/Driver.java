package sec02.exam01.driver;

public class Driver {
	
	void driveTico(Tico tico) {
		System.out.println("오직 티코만 운전 가능");
		tico.run();
		tico.autoRun();
	}
	
	void drive(Car car) {
		System.out.println("모든 자동차 운전 가능");
		car.start();
		car.run();
		
		if(car instanceof Tico) {
			Tico tico = (Tico) car;
			tico.autoRun();
			
			((Tico) car).autoRun();
		}
		car.stop();
	}

}
