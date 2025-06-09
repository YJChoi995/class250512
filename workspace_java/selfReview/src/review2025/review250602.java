package review2025;

import java.util.Scanner;

public class review250602 {

	public static void main(String[] args) {
		// 1. 구구단을 출력하시오
		System.out.println("1. 구구단을 출력하시오");
		for (int i=2; i<=9; i++) {
			System.out.println("*** "+ i + "단 ***");
			for (int j=1; j<=9; j++) {
				System.out.println(i+" x "+j+" : "+(i*j));
			}
		}
		
		// 2. 구구단 2단을 출력하시오
		System.out.println("\n2. 구구단 2단을 출력하시오");
		for (int i=1; i<=9; i++) {
			System.out.println("2 x "+i+" : "+(i*2));
		}
		
		// 3. 2~10까지 짝수만 출력
		System.out.println("\n3. 2~10까지 짝수만 출력");
		for (int i=1; i<=10; i++) {
			if(i%2 == 0) {
				System.out.println(i + ": 짝수");
			}
		}
		
		// 4. 10~1까지 거꾸로 출력
		System.out.println("\n4. 10~1까지 거꾸로 출력");
		for (int i=10; i>=1; i--) {
			System.out.println(i);
		}
		
		
		// 5. 1~10까지 다음과 같이 출력
	    //   1: 홀수
		//	 2: 짝수
		System.out.println("\n5. 1~10까지 홀짝 출력");
		for (int i=1; i<=10; i++) {
			if(i%2 == 0) {
				System.out.println(i + ": 짝수");
			} else {
				System.out.println(i + ": 홀수");
			}
		}
		
		System.out.println();
		
		// 6. 1~10까지 3개씩 옆으로 찍기
		
		
		
		
		// 7. 1부터 100까지의 홀수의 개수
		int count = 0;
		for (int i=1; i<=100; i++) {
			if (i%2 ==1) {
				count += 1;
			}
		}
		System.out.println("7. 1~100까지의 홀수의 개수: " + count);
		
		
		// 8. 구구단 두 단씩 옆으로 출력
		// 형식 : 2x1=2 3x1=3
		//        2x2=4 3x2=6
		System.out.println("\n8. 구구단 두 단씩 옆으로 출력");
		for (int i=2; i<=9; i++) {
			for (int j=1; j<=9; j++) {
				if(i%2 == 0) {
					System.out.print(i+" x "+j+" :" + (i*j) + "  ");
					System.out.println((i+1)+" x "+j+" :" + (i+1)*j);
				}
			}
		}

		
///////////////////////////////////////////////////////
//  피라미드 만들기                                  //
//////////////////////////////////////////////////////
	/*
	....+....
	...+++...
	..+++++..
	.+++++++.
	+++++++++
	*/
		String mark = "+";
		String space = ".";
		
		// 0단계
		/*
		 	+
		 	+
		 	+
		 	+
		 	+
		 */
		System.out.println("\n0단계");
		for (int i=1; i<=5; i++) {
			System.out.println(mark);
		}
		
		
		// 1단계
		/*
		 	+++++
		 */
		System.out.println("\n1단계");
		for (int i=1; i<=5; i++) {
			System.out.print(mark);
		}
		
		
		System.out.println();
		// 2단계
		/*
	 		+.+.+.+.+.
		 */
		System.out.println("\n2단계");
		for (int i=1; i<=5; i++) {
			System.out.print(mark + space);
		}
		
		System.out.println();
		
		
		// 3단계
		/*
		 	+++++
		 	+++++
		 	+++++
		 */ // 단 mark만 써서
		System.out.println("\n3단계");
		for (int i=1; i<=3; i++) {
			for (int j=1; j<=5; j++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		
		// 4단계
		/*
		  11111
		  22222
		  33333
		  44444
		  55555
		*/
		System.out.println("\n4단계");
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		// 5단계
		/* 
		 	1
		 	22
		 	333
		 	4444
		 	55555
		*/  
		System.out.println("\n5단계");
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		// 6단계
		/*
		 +
		 ++
		 +++
		 ++++
		 +++++
		*/
		System.out.println("\n6단계");
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		
		// 7단계
		/*
		 11111
		 2222
		 333
		 44
		 5
		*/
		System.out.println("\n7단계");
		for (int i=1; i<=5; i++) {
			for (int j=i; j<=5; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
		// 8단계
		/*
		    +....
		    ++...
		    +++..
		    ++++.
		    +++++
		*/
		System.out.println("\n8단계");
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=i; j++) {
				System.out.print(mark);
			}
			for (int j=i; j<=4; j++) {
				System.out.print(space);
			}
			System.out.println();
		}
			
		
		// 9단계
	    /*	
		    ....+
		    ...++
		    ..+++
		    .++++
		    +++++
		*/	
		System.out.println("\n9단계");
		for (int i=1; i<=5; i++) {
			for (int j=i; j<=4; j++) {
				System.out.print(space);
			}
			for (int j=1; j<=i; j++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		
		// 10단계
		/*	
		    ....+
		    ...+++
		    ..+++++
		    .+++++++
		    +++++++++
		*/
		System.out.println("\n10단계");
		for (int i=1; i<=5; i++) {
			for (int j=i; j<=4; j++) {
				System.out.print(space);
			}
			for (int j=1; j<=i; j++) {
				System.out.print(mark);
			}
			for (int j=2; j<=i; j++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		
		// 11단계
		/*
		    ....+....
		    ...+++...
		    ..+++++..
		    .+++++++.
		    +++++++++
		 */
		System.out.println("\n11단계");
		for (int i=1; i<=5; i++) {
			for (int j=i; j<=4; j++) {
				System.out.print(space);
			}
			for (int j=1; j<=i; j++) {
				System.out.print(mark);
			}
			for (int j=2; j<=i; j++) {
				System.out.print(mark);
			}
			for (int j=i; j<=4; j++) {
				System.out.print(space);
			}
			System.out.println();
		}
		
		
		
		// 12단계
		// 입력 받은 줄 수대로 출력
		// 예를 들어 3이면
		/*	
		    ..+..
		    .+++.
		    +++++ 
		*/
		System.out.print("\n12단계\n숫자를 입력하시오: ");
		Scanner scanner = new Scanner(System.in);
		int z = scanner.nextInt();
		
		for (int i=1; i<=z; i++) {
			for (int j=i; j<=z-1; j++) {
				System.out.print(space);
			}
			for (int j=1; j<=i; j++) {
				System.out.print(mark);
			}
			for (int j=2; j<=i; j++) {
				System.out.print(mark);
			}
			for (int j=i; j<=z-1; j++) {
				System.out.print(space);
			}
			System.out.println();
		}
		
		
	}
}
