package quiz;

import java.util.Scanner;

public class createGame {
	/* updown 게임 */
	// 0-9까지 중에서 찍기
	
	
	/* 필드 */
//	int random;
//	int input;
//	int cnt;
	
	/* 생성자 */
	createGame(){
//		System.out.println("0~9 중 무작위 숫자를 제시합니다. 맞추어 보세요");
		System.out.println("** 입력한 두 수에서 무작위 숫자를 맞추어 보세요 **");
	}
	
	boolean isDebug = false;
	createGame(boolean isDebug){
		this.isDebug = isDebug;
	}
	
	
	/* 메소드 */
	

//	// 입력한 숫자를 받는 메소드
//	int input(int in) {
//		return input;
//	}
//	
//	// 입력한 숫자를 비교하는 메소드
//	void compare() {
//		while(input == random) {
//			random = (int)(Math.random()*10);
//			if (input > random) {
//				System.out.println("up - 시도: " + cnt);
//				System.out.println("숫자를 다시 입력하세요");
//			} else if(input < random) {
//				System.out.println("down - 시도: " + cnt);
//				System.out.println("숫자를 다시 입력하세요");
//			} else {
//				System.out.println("정답 - 시도: " + cnt);
//			}
//			break;
//		}
//	}
	
	
	
	
	// 랜덤 숫자를 생성해서 돌려주기
	int getNumber(int start, int end) {
		int result = Integer.MIN_VALUE;
		if(end >= start) {
			result = (int)(Math.random() * (end-start+1)) + start;
		} else {
			System.out.println("마지막 숫자는 시작 숫자보다 크거나 같아야 합니다");
		}
		return result;		
	}
	
	// 메소드명: start
	// 전달인자: int start, int end // 정답의 범위
	// 리턴타입: void
	void start (int start, int end) {
		Scanner scan = new Scanner(System.in);
		
		int menu = -1;
		
		do {
			System.out.println("1. 게임 시작 || 0. 종료");
			menu = scan.nextInt();
			
			if(menu != 1 && menu != 0) {
				System.out.println("메뉴를 다시 선택하세요");
				continue;
			} 
			
			switch(menu) {
				case 1:
					// 이번 판의 정답
					int answer = getNumber(start, end);
					
					// 정답 여부
					boolean correct = false;
					
					int count = 0; // 게임 시도 횟수
	
					while(!correct) {
						System.out.printf("%d ~ %d까지 입력하세요 : ", start, end);
						int number = scan.nextInt();
						count ++;
						
						if(answer == number) {
							System.out.println("정답입니다");
							correct = true;
						} else if(answer > number) {
							System.out.println("Up▲ 게임 시도 횟수 : " + count);
						} else {
							System.out.println("Down▼ 게임 시도 횟수 : " + count);
						}
					}
					break;
					
				case 0 : 
					System.out.println("게임을 종료합니다");
			}	
		} while(menu != 0);
	}	
}
	
	
	
	
	
	
	

