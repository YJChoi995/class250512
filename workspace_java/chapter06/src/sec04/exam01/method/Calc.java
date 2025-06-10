package sec04.exam01.method;

public class Calc {
	
	/* 메소드 만들기 */
	
	// 전원 키는 메소드
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
	
	// 덧셈 메소드
	int plus(int x, int y) {
		int result = x+ y;
		return result;
	}
	
	// 나누기 메소드
	double divide(int x, int y) {
		double result = (double)x / (double)y;
		return result;
	}
	
	// 전원 끄는 메소드
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	/**
	 * 더하기 기능
	 * 두 수를 입력받아서 더한 결과를 돌려준다
	 * 
	 * 메소드명 : plus
	 * 전달인자 : int x, int y
	 * 리턴타입 : int (두 수의 합)
	 * 
	 */
	
	int plus1(int x, int y) {
		System.out.println("x :" + x + ", y :" + y);
		int result = x + y;
		return result;
	}
	
	/**
	 * 두 정수를 입력 받아서
	 * 나누기한 결과를
	 * double로 돌려준다
	 * 단, y가 0일 때는 "안된다"고 출력하고 0을 돌려 줌
	 * 
	 * 메소드명 : divide
	 * 전달인자 : int x, int y
	 * 리턴타입 : double
	 *
	 */
	
	double divide2(int x, int y) {
		System.out.println("x :" + x + ", y :" + y);
		if (y == 0) {
			System.out.println("0은 나누기가 불가능 합니다");
			return 0;
		} else {
			double result = (double)x / (double)y;
			return result;
		}
		
	}
	
	// int 배열의 모든 값을 더하는 메소드
	int sum(int[] array) {
		int sum = 0;
		if(array != null) { // 방어 코딩
			for (int i=0; i<array.length; i++) {
				sum += array[i];	
			}
		}
		return sum;
	}
	
	// 가변인자, 전개연산자, spread op
	// 보내는 곳에서는 sum2(1,2,3,4)
	// 내부에서는 배열로 취급
//	int sum2(int ... values){
	
	
	/**
	 * 별* 2개 짜리 주석: JAVADOC 주석
	 * 
	 *@param int x, int y
	 *@return int
	 *@author 회사 메일
	 */
	
}
