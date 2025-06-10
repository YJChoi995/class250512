package sec04.exam01.method;

public class CalcExample {

	public static void main(String[] args) {
		Calc calc = new Calc();
		calc.powerOn();
		
		int result = calc.plus(5, 6);
		System.out.println("result : " + result);
		
		byte x = 10;
		byte y = 4;
		double result1 = calc.divide(x, y);
		System.out.println("result1 : " + result1);
		
		
		int result2 = calc.plus1(7,9);
		System.out.println("result2 : " + result2);
		
		double result3 = calc.divide2(10, 0);
		System.out.println("result3 : " + result3);
		
		int[] c = {1,2,3,4,5};
//		int[] c = null;
		int sum = calc.sum(c);
		System.out.println("sum: " + sum);
		System.out.println("c[0]: " + c[0]);
		
		calc.powerOff();

	}

}
