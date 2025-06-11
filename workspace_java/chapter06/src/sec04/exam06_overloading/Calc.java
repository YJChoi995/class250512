package sec04.exam06_overloading;

public class Calc {

	int plus(int x, int y){
		System.out.println("int int 실행");
		System.out.println(x + " + " + y + " = " + (x+y));
		return x + y;
	}
	// 전달인자가 int, int로 같기 때문에 오버로딩 적용 안됨
//	int plus(int x, int y){
//		return x + y;
//	}
	
	double plus(double x, double y){
		System.out.println("double double 실행");
		System.out.println(x + " + " + y + " = " + (x+y));
		return x + y;
	}
	
	double plus(int x, double y){
		System.out.println("int double 실행");
		System.out.println(x + " + " + y + " = " + (x+y));
		return x + y;
	}
	
	
	
}
