package sec03.exam01;

public class TypeCastingExample {
	public static void main(String[] args) {
		/* 강제 타입 변환 */
		double doubleValue = 3.14;
		int intValue = (int) doubleValue;
		
		System.out.println("doubleValue: " + doubleValue);
		System.out.println("intValue: " + intValue);
		
		intValue = 200;
		byte byteValue = (byte) intValue;
		System.out.println("byteValue: " + byteValue);
		// 127을 넘어가니 출력을 예상하기 힘들다
		// 비트를 2의 보수로 계산한 결과가 나온다
		
		
		/* 자동 타입 변환 */
		int i1 = 100;
		long l1 = (long) i1;
		long l2 = i1; // int < long 이기 때문에 변환시 생략 가능함

		
		/* 정수 연산에서의 자동 타입 변환 */
		// 작은 타입이 피연산자로 사용되면 자동으로 타입 변환 된다
		/*
		byte x = 10;
		byte y = 20;
		byte result = x+y; // (byte)x, y는 피연산자로 사용되어 int로 자동변환되었기 때문에
		int result = x+y; // 출력 결과 : 30 
		*/
		
		// 서로 다른 타입을 피연산자로 사용하면 자동으로 큰 타입으로 변환된다
		int i2 = 100;
	    long l3 = 300;
	    long l4 = i2 + l3;
	    System.out.println("l4 = " + l4 );
		
	    
		/* 실수 연산에서 자동 타입 변환 */
	    // 피연산자에 하나라도 실수 타입이 있으면 자동으로 실수 타입으로 변환됨
	    int i3 = 10;
	    double d1 = 5.5;
	    double result = i3 + d1; // 출력결과 : 15.5, i3은 (double)i3으로 자동변환 된거임
	    
	    double d2 = 10.0 / 4;
//	    double d2 = (double)10.0 / (double) 4;
//      double d2 = (double)10.0 / 4;
	    System.out.println("d2 : " + d2); // 출력결과(d2 : 2.5)
	    
	    
	    /* 문자열을 기본 타입으로 강제 타입 변환 */
	    String str1 = "10";
	    byte value1 = Byte.parseByte(str1);
	    /* 기본 타입을 문자열로 강제 타입 변환
	       String str2 = String.valueOf(기본타입값); */
	    
	    
	    /* 퀴즈
	     * 회식비 4.3만원
	     * 참석인원 4명
	     * 이 때 인당 얼마를 내야 하는가?
	     * 1. 디테일하게 원단위 까지
	     * 2. 참석인원은 만원단위로만 회식비를 낸다
	     * 3. 2번처럼 받으면 주최자는 얼마를 내야 하나?
	     */
	    
	    double total = 4.3;
	    int count = 4;
	    double result1 = total / count;
	    System.out.println("1번: " + (result1*10000) + "원");
	    
	    int result2 = (int) result1;
	    System.out.println("2번: " + result2 + "만원");
	    
	    double result3 = total - ((count-1) * result2);
	    System.out.println("3번: " + result3*10000 + "원");
	}
}
