package sec02.exam01;

public class OpExample {
	public static void main(String[] args) {
		int x = 10;
		
		x++;
		System.out.println("x: " + x);
		++x;
		System.out.println("x: " + x);
		
		x = 10;
		x = x + 1;
		x += 1;   // 위와 같은 코드
		x++;      // 위와 같은 코드. 단, 1을 증가할 때만
		
		int y = 10;
		
		y--;
		--y;
		System.out.println("y: " + y);
		
		x = 10;
		int z = ++x;
		System.out.println("z: " + z);
		
		x = 10;
		z = x++;
		System.out.println("z: " + z);
		System.out.println("x: " + x);
		
		System.out.println();
		
		x = 1;
		z = x++ + ++x;
		System.out.println("z: " + z);
		System.out.println("x: " + x);
		
		System.out.println();
		
		/* 문제 */
		x = 1;
		z = x++ - --x * x++ - x--; 
		System.out.printf("x: %d, z: %d", x ,z); // x: 1, z: -2
		System.out.println();
		
		
		
		/* 이항 연산자 */
		// 산술 연산자
		// 비교 연산자
		boolean a = 3 < 4;
		boolean b = 3 > 4;
		System.out.println("a: " + a + ", b: " + b);
		
		String s1 = "s1";
		String s2 = "s1";
		System.out.println(s1.equals(s2));
		
		// 논리 연산자
		
		// 대입 연산자
		/* 퀴즈 
		 * 돈 : 10,000원, 커피값 : 4,500원
		 * 1. 커피 몇 잔을 살 수 있나?
		 * 2. 남는 돈은?
		 */
		int cost = 10000;
		int c1 = 4500;
		System.out.println("살 수 있는 커피 수: " + cost/c1 + "잔");
		System.out.println("잔돈: " + cost%c1 + "원");
		
		/* 퀴즈 2
		 * 꿀홍차 8000원이 15% 세일이면 얼마인가
		 */
		int honey = 8000;
		System.out.println("가격: " + honey*0.85 + "원");
		double cost1 = honey - honey*0.15;
		System.out.println("가격: " + cost1 + "원");
        
		/* 복습 */
		int score = 87;
		System.out.println("내 점수는 80과 90점 사이인가 참? 거짓?");
		System.out.println(score <= 90 && score >= 80);
		
		//957을 900으로 바꾸는 법
		int aa = 957;
		int ab = aa%100;
		System.out.println(aa - ab);
		// 어떤 숫자를 10의 자리 이하 버림
		// a - (a%100)
		int ac = 1937;
		ac = ac - (ac % 100);
		System.out.println(ac);
		
		// v1/v2를 소수점 3자리까지 출력하시오
		double v1 = 1000.0;
		double v2 = 794.0;
		
		double v3 = v1 / v2;
		System.out.printf("v3: %.3f",  v3);
		System.out.println();
		v3 = ( (int) (v3 * 1000) ) / 1000.0;
		System.out.printf("v3: " + v3);
		
		double v4 = (v1 / v2) * 1000;
		int v5 = (int) v4;
		double v6 = (double) v5 /1000;
		System.out.println();
		
		
		/* 삼항 연산자 */
		int score1 = 95;
		String grade = (score1 > 90) ? "A" : "B";
		System.out.println("grade: " + grade);
		
	    
	}
}
