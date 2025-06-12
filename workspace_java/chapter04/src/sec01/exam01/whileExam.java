package sec01.exam01;

import java.util.Scanner;

public class whileExam {

	public static void main(String[] args) {
		int i = 1;
		while (i<=10) {
			System.out.println(i);
			i++;
		}
		
		// 1~100까지 합을 출력
		int sum = 0;
		i = 1;
		while (i<=100) {
			sum += i;
			i++;
		}
		System.out.println("1~" + (i-1) + "의 합: " + sum);
		
		/* 키오스크: 메뉴를 고르세요 */
		// 1: 커피, 2: 차, 3: 종료
		Scanner scan = new Scanner(System.in);
	
		System.out.println("메뉴를 고르세요 \n1:커피, 2:차, 3:종료");
		int menu = 1;
		
//		if (menu == 1) {
//			System.out.println("커피 드릴게요");
//		} else if (menu == 2) {
//			System.out.println("차 드릴게요");
//		} else if (menu == 0) {
//			System.out.println("주문을 종료합니다. 다음에 뵈요");
//		} else {
//			System.out.println("주문을 확인하세요");
//		}
		
		
		while (menu != 0) {
			menu = scan.nextInt();
			if (menu == 1) {
				System.out.println("커피 드릴게요");
			} else if (menu == 2) {
				System.out.println("차 드릴게요");
			} else if (menu == 0) {
				System.out.println("주문을 종료합니다. 다음에 뵈요");
			} else {
				System.out.println("주문을 확인하세요");
			}
		}
		
	}
}
