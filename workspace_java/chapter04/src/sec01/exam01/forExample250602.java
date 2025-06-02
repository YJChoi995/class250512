package sec01.exam01;

public class forExample250602 {

	public static void main(String[] args) {
		/* 250602(월) */
		// 문제 1
		// 주사위 2개를 굴려서 나올 수 있는 모든 조합을 출력
		// 예 : [1,1], [1,2]
		System.out.println("1. 주사위 2개를 굴려서 나올 수 있는 모든 조합을 출력");
		for (int i=1; i<=6; i++) {
			for (int j=1; j<=6; j++) {
				System.out.print("[" + i + "," + j + "] ");
			}
			System.out.println();
		}
		
		
		// 문제 2
		// 주사위 2개의 합 별로 나올 수 있는 조합
		// 합 2 : [1,1]
		// 합 3 : [1,2], [2,1]
		System.out.println("\n2. 주사위 2개의 합 별로 나올 수 있는 조합");
		for (int i=2; i<=12; i++) {
			System.out.print("합 "+ i + ":");
			for (int j=1; j<=6; j++) {
				for (int k=1; k<=6; k++) {
					if (j+k== i) {
						System.out.print("[" + j + "," + k + "] ");
					}
				}
			}
			System.out.println();
		}
	
		
		// 문제 3
		// 합 별 조합의 수를 출력
		System.out.println("\n3. 주사위 2개의 합 별로 나올 수 있는 조합");
		for (int i=2; i<=12; i++) {
			System.out.print("합 "+ i + ":");
			int cnt = 0;
			for (int j=1; j<=6; j++) {
				for (int k=1; k<=6; k++) {
					if (j+k == i) {
						System.out.print("[" + j + "," + k + "] ");
						cnt++;
					}
				}
			}
			System.out.println("총 개수: " + cnt);
		}
	
		
		
		
		// 문제 4
		// 순서에 관계 없이 중복 제거
		// 합 2 : [1,1]
		// 합 3 : [1,2] 와 [2,1]는 같음
		
		
		// 문제 5
		// 입력받은 정수에 따라 다음과 같이 출력
		/* 3
		 * 00 01 02
		 * 10 11 12
		 * 20 21 22
		 * 
		 * 4
		 * 00 01 02 03
		 * 10 11 12 13
		 * 20 21 22 23
		 * 30 31 33 34		 
		*/
		
		
		// 문제 6
		// 입력받은 정수에 따라 다음과 같이 출력
		/* 3
		 * +++
		 * +.+
		 * +++
		 * 
		 * 5
		 * +++++
		 * +...+
		 * +...+
		 * +...+
		 * +++++
		 */
		

	}

}
