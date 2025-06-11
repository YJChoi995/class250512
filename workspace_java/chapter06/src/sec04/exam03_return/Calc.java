package sec04.exam03_return;

public class Calc {
	/* 메소드 안에서 메소드 호출 */
	
	// 두 수를 입력받아 더한 결과를 돌려주는 메소드 plus
	int plus(int x, int y) {
		return x+y;
	}
	
	// 평균을 낸 결과를 돌려주는 avg
	double avg(int a, int b) {
		int sum = plus(a, b);
		double result = (double)sum/2;
		return result;
	}
	
	// 출력하는 execute
	void execute(int c, int d) {
		double result = avg(c, d);
		System.out.println(c + "과(와) " + d + "의 평균은 " + result);
	}
	
	
}
