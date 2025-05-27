package sec02.exam01;

public class Test {
	public static void main(String[] args) {
		/* 복습 문제 */
		// 1. 내 나이를 저장하시오
		int age = 27;
		System.out.println("나이: " + age);
		
		// 2. 내 소유 차가 있다
		boolean car = false;
		
		// 3. 우리 집에 있는 스마트폰의 개수
		int phone = 1;
		System.out.println("스마트폰 개수: " + phone + "개");
		
		// 4. 내 이름
		String name = "최연지";
		System.out.println("이름: " + name);
		
		// 5. 1평은 3.3제곱미터이다. 5평은 얼마인가?
	    double area = 3.3;
	    System.out.println("5평: " + area*5 + "제곱미터");
	    
	    
	    /* 퀴즈 */
	    // 1. 두 변수 a, b에 각각 3, 4를 넣고 출력 : "3과 4". 단, 변수를 사용해서.
	    int a = 3;
	    int b = 4;
	    System.out.println(a + "과 " + b);
	    
	    /* 1-1. 두 변수(a, b)에 각각 3, 4를 넣고
	     * 출력 결과 : "3 > 4의 결과는 false 입니다
	     * 
	     * 1-2. 두 변수의 값을 6, 5로 변경
	     * 출력 결과 : "6 > 5의 결과는 true 입니다 
	     */
	    System.out.println(a + " > " + b + "의 결과는 " + (a > b) + "입니다");
	    
	    a = 6;
	    b = 5;
	    System.out.println(a + " > " + b + "의 결과는 " + (a > b) + "입니다");
	    
	    /* 퀴즈 2
	     * 숫자 632를
	     * 출력 결과 
	     * "백의 자리: 6"
	     * "십의 자리: 3:
	     * "일의 자리: 2"
	     */
	    int c = 632;
	    int c1 = c/100; //6
	    int c2 = c/10; //63
	    
	    System.out.println("백의 자리: " + c1); // 6
	    System.out.println("십의 자리: " + (c2 - c1*10)); // 63-60
	    System.out.println("일의 자리: " + (c- c2*10)); // 632-630 
	    
	    System.out.println("백의 자리: " + c/100); // 6
	    System.out.println("십의 자리: " + (c/10 - (c/100)*10));  // 63 - (6*10)  
	    System.out.println("일의 자리: " + (c - (c/10)*10)); // 632 - (63)*10
	}
}
