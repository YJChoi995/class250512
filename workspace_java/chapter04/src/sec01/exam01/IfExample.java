package sec01.exam01;

public class IfExample {
	public static void main(String[] args) {
		int score = 59;
		
		if (score >= 90) {
			System.out.println("점수가 90보다 큽니다");
			System.out.println("등급: A");
		} else if(score >= 80) {
			System.out.println("점수: " + score + "점");
			System.out.println("등급: B");
		} else if(score >= 70){
			System.out.println("점수: " + score + "점");
			System.out.println("등급: C");
		} else {
			System.out.println("점수: " + score + "점");
			System.out.println("등급 D 이하");
		}
		
		
		
		score = 97;
		if(score >= 95) {
			System.out.println("95점 이상");
		} else if(score >= 90){
			System.out.println("90점 이상");
		}
		
		
		if(score >= 90) {
			System.out.println("90점 이상");
			
			if(score >= 95) {
				System.out.println("95점 이상");
			}
		}
		
		
		/* if - else와 if를 두 번 쓰는 방법의 차이 */
		score = 99;
		if(score >= 95) {
			System.out.println("95점 이상");
		} else if(score >= 90){
			System.out.println("90점 이상");
		}
		
		if(score >= 95) {
			System.out.println("95점 이상");
		} 
		if(score >= 90) {
			System.out.println("90점 이상");
		}
		// if 두 개가 모두 참이기 때문에 둘 다 실행됨.
		// 연관이 있는 조건식은 묶어 준다
		
		
		/* 짝수 홀수 가리기 */
		int x = 3;
		if (x%2 == 0) {
			System.out.println("x = 짝수");
		} else {
			System.out.println("x = 홀수");
		}
		
		if (x%2 == 0) {
			System.out.println("x = 짝수");
		} else if (x%2 == 1) {
			System.out.println("x = 홀수");
		}
		// 같은 실행문
		
		
		/////////////////////////////////////////////////////////////
		// random                                                  //
		/////////////////////////////////////////////////////////////
		
		double random1 = Math.random();
		System.out.println(random1);
		// random의 범위 0.0 <= Math.random < 1.0
		
		// 주사위 : 1~6. 대충 나머지로 구하는 법
		double random2 = Math.random() * 10000;
		int dice = ((int) random2) % 6 + 1;
		System.out.println("주사위 값: " + dice);
		
		System.out.println();
		
		
		for (int i = 1; i<=6; i++) {
			int rotto = (int)( Math.random() * 45 ) + 1;
			System.out.println("로또 번호: " + rotto);
		}
		
    }
}