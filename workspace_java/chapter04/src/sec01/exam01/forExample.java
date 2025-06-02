package sec01.exam01;

import java.util.Scanner;

public class forExample {
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum = sum + i;
		}
		System.out.println("1~100의 합: " + sum);
        
		// 1씩 증가하는걸 하고 싶다
		sum = 0;
		
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		sum += 1;
		System.out.println("sum: " + sum);
		
		sum = 0;
		for(int i=1; i<=10; i++) {
			sum += 1 ;
		}
		System.out.println("sum: " + sum);
		
		// 구구단을 출력하시오
		for (int m=1; m<=9; m++) {
			System.out.println("*** " + m + "단 ***");
			for (int n=1; n<=9; n++) {
				System.out.println(m + " X " + n + " = " + (m*n));
			}
		}
		System.out.println();
		
		// 구구단 2단을 출력하시오
		System.out.println("*** 구구단 2단 ***");
		for(int n=1; n<=9; n++) {
			System.out.println("2 X " + n + " : " + (2*n));
		}
		System.out.println();
		
		
		
		/* 반복문 만드는 원리
		 * 
		 * 1. 반복되는 것 찾기
		 * 		ctrl + c, v 했을 때 바뀌지 않는 것
		 * 2. 반복 되지 않는 것에서
		 * 		규칙(패턴) 찾기
		 * 		변수를 활용해서 더 이상 바뀌지 않게 만들기
		 * 3. 시작 조건 파악
		 * 4. 종료 조건 파악
		 * 
		 * for: 반복 횟수를 아는 경우 
		 * while: 반복 횟수를 모르는 경우 
		 */
		
		// 2~10까지 짝수만 출력
		System.out.println("2~10까지 짝수만 출력");
		for (int qq=2; qq<=10; qq+=2) {
			System.out.println(qq);
		}
		System.out.println();
		
		// 10~1까지 거꾸로 출력
		System.out.println("10~1까지 거꾸로 출력");
		for (int i=10; i>=1; i--) {
			System.out.println(i);
		}
		System.out.println();
		
		// 1~10까지 다음과 같이 출력
	    //   1: 홀수
		//	 2: 짝수
		System.out.println("1~10까지 홀수/짝수 출력");
		for (int i=1; i<=10; i++) {
			if(i%2==0) {
				System.out.println(i + ": 짝수");
			} else {
				System.out.println(i + ": 홀수");
			}	
		}
		System.out.println();
		
		
		// 1~10까지 3개씩 옆으로 찍기
		System.out.println("1~10까지 3개씩 옆으로 찍기");
		int i;
		for (i=1; i<=3; i++) {
			System.out.printf(i + " ");
		} 
		System.out.println();
		for (i=4; i<=6; i++) {
			System.out.printf(i + " ");
		} 
		System.out.println();
		for (i=7; i<=9; i++) {
			System.out.printf(i + " ");
		}
		System.out.println();
		System.out.println(i);
		
		// 선생님 답 1
		System.out.println("// 선생님 답");
		for (int j=1; j<=10; j += 3) {
			if(j != 10){
				System.out.println(j +" "+ (j+1) +" "+ (j+2));
			} else {
				System.out.println(j);
			}
		}
		
		// 선생님 답 2
		System.out.println("// 선생님 답 2");
		for (int j=1; j<=10; j++) {
			System.out.print(j + " ");
			if (j % 3 == 0) {
				System.out.println();
			}
		}
		
		
		System.out.println();
		System.out.println();
		
		// 1부터 100까지의 홀수의 개수
		System.out.println("1부터 100까지의 홀수의 개수");
		int count = 0;
		for (int j=1; j<=100; j++) {
			if(j % 2 != 0) {
				count ++;
			}
		}
		System.out.println("count: " + count);
		
		System.out.println();
		
		// 구구단 두 단씩 옆으로 출력
		// 형식 : 2x1=2 3x1=3
		//        2x2=4 3x2=6
		for (int m=2; m<=9; m++) {
			for (int n=1; n<=9; n++) {
			    if(m % 2 == 0) {
			    	System.out.print(m + " X " + n + " = " + (m*n) + " ");
					System.out.println((m+1) + " X " + n + " = " + ((m+1)*n));
			    }
			}
		}
		
		System.out.println();
		
		// 선생님 답
		for (int k=2; k<=9; k+=2) {
			for (int j=1; j<=9; j++) {
				System.out.println();
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
	// 0단계
	/*
	 	+
	 	+
	 	+
	 	+
	 	+
	 */
		for(int j=1; j<=5; j++) {
			System.out.println("+");
		}
		
		System.out.println();
	// 1단계
	/*
	 	+++++
	 */
		String mark = "+";
		for(int j=1; j<=5; j++) {
			System.out.print(mark);
		}
		
		System.out.println();
		
	// 2단계
	/*
	 	+.+.+.+.+.
	 */
		String space = ".";
		
		for(int j=1; j<=5; j++) {
			System.out.print(mark);
			System.out.print(space);
		}
		
		System.out.println();
		System.out.println();
		
	// 3단계
	/*
	 	+++++
	 	+++++
	 	+++++
	 */ // 단 mark만 써서
		for (int y=1; y<=3; y++) {
			for(int j=1; j<=5; j++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
	// 4단계
	/*
	  11111
	  22222
	  33333
	  44444
	  55555
	*/
		for (int y=1; y<=5; y++) {
			for(int j=1; j<=5; j++) {
				System.out.print(y);
			}
			System.out.println();
		}
		
		System.out.println();	
		System.out.println();
		
	// 5단계
	/* 
	 	1
	 	22
	 	333
	 	4444
	 	55555
	*/  
//	
//		int i1 = 1; 
//		for (int j=1; j<=i1; j++) {
//			System.out.print(i1);
//		} 
//		System.out.println();
//
//		i1++;
//		
//		for (int j=1; j<=i1; j++) {
//			System.out.print(i1);
//		} 
//		System.out.println();
//		
//		i1++;
//		
//		for (int j=1; j<=i1; j++) {
//			System.out.print(i1);
//		} 
//		System.out.println();
//
//		System.out.println("-----------------------------------");
//		for (int y=1; y<=5; y++) {
//			for (int j=1; j<=y; j++) {
//				System.out.print(y);
//			} 
//			System.out.println();
//		}
		
		for (int y=1; y<=5; y++) {
			for (int j=1; j<=y; j++) {
				System.out.print(y);
			}
			System.out.println();
		}
		
		System.out.println();
			
	// 6단계
	/*
	 +
	 ++
	 +++
	 ++++
	 +++++
	*/
		
		for (int y=1; y<=5; y++) {
			for (int j=1; j<=y; j++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		System.out.println();
	
	// 7단계
	/*
	 11111
	 2222
	 333
	 44
	 5
	*/
		for (int y=1; y<=5; y++) {
			for(int j=y; j<=5; j++) {
				System.out.print(y);
			}
			 System.out.println();
		}
		
		System.out.println();
		
	// 8단계
	/*
	    +....
	    ++...
	    +++..
	    ++++.
	    +++++
	*/
	
		for (int y=1; y<=5; y++) {
			for (int j=1; j<=y; j++) {
				System.out.print(mark);
			}
			for (int t=1; t<=(5-y); t++) {
				System.out.print(space);
			}
			System.out.println();
		}
		
		System.out.println();
		
	// 9단계
    /*	
	    ....+
	    ...++
	    ..+++
	    .++++
	    +++++
	*/	
		for (int y=1; y<=5; y++) {
			for (int j=1; j<=(5-y); j++) {
				System.out.print(space);
			}
			for (int t=1; t<=y; t++) {
				System.out.print(mark);
			}
			System.out.println();
		}
		
		System.out.println();

		
	// 10단계
	/*	
	    ....+
	    ...+++
	    ..+++++
	    .+++++++
	    +++++++++
	*/
	
		for (int y=1; y<=5; y++) {
			for (int j=1; j<=(5-y); j++) {
				System.out.print(space);
			}
			for (int t=1; t<=y; t++) {
				System.out.print(mark);
			}
			for (int r=1; r<=(y-1); r++) {
				System.out.print(mark);
			}
			
			System.out.println();
		}
	
		System.out.println();
		
	// 11단계
	/*
	    ....+....
	    ...+++...
	    ..+++++..
	    .+++++++.
	    +++++++++
	 */
		for (int y=1; y<=5; y++) {
			for (int j=1; j<=(5-y); j++) {
				System.out.print(space);
			}
			for (int j=1; j<=y; j++) {
				System.out.print(mark);
			}
			for (int j=1; j<=(y-1); j++) {
				System.out.print(mark);
			}
			for (int j=1; j<=(5-y); j++) {
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
		
		for (int y=1; y<=z; y++) {
			for (int j=y; j<=z-1; j++) {
				System.out.print(space);
			}
			for (int j=1; j<=y; j++) {
				System.out.print(mark);
			}
			for (int j=2; j<=y; j++) {
				System.out.print(mark);
			}
			for (int j=y; j<=z-1; j++) {
				System.out.print(space);
			}
			System.out.println();
		}

	}
}
