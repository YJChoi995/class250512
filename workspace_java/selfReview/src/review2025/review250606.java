package review2025;

import java.util.Scanner;

public class review250606 {
	public static void main(String[] args) {
		
	///////////////////////////////////////////////////////
	//  피라미드 만들기                                     //
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
	for (int i=1; i<=5; i++) {
		System.out.println(mark);
	}
	
	
	// 1단계
	/*
	+++++
	*/
	for (int i=1; i<=5; i++) {
		System.out.print(mark);
	}
	
	System.out.println();
	
	
	// 2단계
	/*
	+.+.+.+.+.
	*/
	for (int i=1; i<=5; i++) {
		System.out.print(mark);
		System.out.print(space);
		
	}
	
	System.out.println();
	
	
	// 3단계
	/*
	+++++
	+++++
	+++++
	*/ // 단 mark만 써서
	for (int i=1; i<=3; i++) {
		for(int j=1; j<=5; j++) {
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
	
	for (int i=1; i<=5; i++) {
		for(int j=1; j<=5; j++) {
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
	for (int i=1; i<=5; i++) {
		for(int j=1; j<=i; j++) {
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
	for (int i=1; i<=5; i++) {
		for(int j=1; j<=i; j++) {
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
	
	for (int i=1; i<=5; i++) {
		for(int j=i; j<=5; j++) {
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
	for (int i=1; i<=5; i++) {
		for(int j=1; j<=i; j++) {
			System.out.print(mark);
		}
		for(int j=i; j<=4; j++) {
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
	for (int i=1; i<=5; i++) {
		for(int j=i; j<=4; j++) {
			System.out.print(space);
		}
		for(int j=1; j<=i; j++) {
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
	for (int i=1; i<=5; i++) {
		for(int j=i; j<=4; j++) {
			System.out.print(space);
		}
		for(int j=1; j<=i; j++) {
			System.out.print(mark);
		}
		for(int j=1; j<=i-1; j++) {
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
	for (int i=1; i<=5; i++) {
		for(int j=i; j<=4; j++) {
			System.out.print(space);
		}
		for(int j=1; j<=i; j++) {
			System.out.print(mark);
		}
		for(int j=1; j<=i-1; j++) {
			System.out.print(mark);
		}
		for(int j=i; j<=4; j++) {
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

	System.out.println("원하는 피라미드 줄 수를 입력하세요: ");
	
	Scanner scan = new Scanner(System.in);
	int a = scan.nextInt();
	
	for (int i=1; i<=a; i++) {
		for(int j=i; j<=a-1; j++) {
			System.out.print(space);
		}
		for(int j=1; j<=i; j++) {
			System.out.print(mark);
		}
		for(int j=1; j<=i-1; j++) {
			System.out.print(mark);
		}
		for(int j=i; j<=a-1; j++) {
			System.out.print(space);
		}
		System.out.println();
	}
	
	

	}

}
