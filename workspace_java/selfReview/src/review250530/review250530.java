package review250530;

public class review250530 {
	public static void main(String[] args) {
		// 1. 구구단을 출력하시오
		System.out.println("1. 구구단을 출력하시오");
		for(int i=2; i<=9; i++) {
			System.out.println("*** " + i + "단 ***");
			for(int j=1; j<=9; j++) {
				System.out.println(i + " x " + j + " = " + (i*j));
			}
		}

		// 2. 구구단 2단을 출력하시오
		System.out.println("2. 구구단 2단을 출력하시오");
		for(int i=1; i<=9; i++) {
			System.out.println("2 x " + i + " = " + (i*2));
		}
		
		// 3. 2~10까지 짝수만 출력
		System.out.println("3. 2~10까지 짝수만 출력");
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				System.out.println(i + " : 짝수" );
			}
		}
		
		// 4. 10~1까지 거꾸로 출력
		System.out.println("4. 10~1까지 거꾸로 출력");
		for (int i=10; i>=1; i--) {
			System.out.println(i);
		}
		
		// 5. 1~10까지 다음과 같이 출력
	    //   1: 홀수
		//	 2: 짝수
		System.out.println("5. 1~10까지 홀짝 출력");
		for(int i=1; i<=10; i++) {
			if(i%2 == 0) {
				System.out.println(i + " : 짝수" );
			} else if(i%2 == 1) {
				System.out.println(i + " : 홀수" );
			}
		}
		
		// 6. 1~10까지 3개씩 옆으로 찍기
		System.out.println("6. 1~10까지 3개씩 옆으로 찍기");
		for(int i=1; i<=10; i++) {
			if(i%3 == 0) {
				System.out.print((i-2) + " " + (i-1) + " " + i);
				System.out.println();
			} else if(i==10)
				System.out.print(i);
		}
		System.out.println();
		
		// 7. 1부터 100까지의 홀수의 개수
		System.out.print("7. 1부터 100까지의 홀수의 개수: ");
		int cnt = 0;
		for(int i=1; i<=100; i++) {
			if(i%2 == 1) {
				cnt++;
			} 
		}
		System.out.print(cnt);
		
		System.out.println();

		// 8. 구구단 두 단씩 옆으로 출력
		// 형식 : 2x1=2 3x1=3
		//       2x2=4 3x2=6
		
		System.out.println("8. 구구단 두 단씩 옆으로 출력");
		for(int i=2; i<=9; i++) {
			if(i%2 == 0) {
				for(int j=1; j<=9; j++) {
					System.out.print(i + " x " + j + " = " + (i*j) + " ");
					System.out.println((i+1) + " x " + j + " = " + ((i+1)*j));
				}
			}
		}
		
	}
}
