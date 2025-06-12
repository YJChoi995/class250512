package sec01.exam01;

import java.util.Scanner;

public class breakExam {
	public static void main(String[] args) {
		// 주사위 6이 나올 때까지 돌림
		int cnt = 0;
		while (true) {
			int num = (int)(Math.random()*6) + 1;
			System.out.println(num);
			if(num == 6) {
				break;
			}
			cnt ++;
		}
		System.out.println("프로그램 종료. 총 :" + cnt + "회");
		
		
		// 방어하기
		for (int i=1; i<10; i++) {
			System.out.println(i);
			if (i>=5) {  			// nt문제로 i==5에서 ==를 못 만나는 경우 뚫릴 수 있음. 방어 코딩 
				break;
			}
		}
		
		
		// 총 5명이 순차적으로 게임 시작
		for (int i=1; i<=5; i++) {
			// 한 명 당 주사위 3번씩 던지기
			for (int j=1; j<=3; j++) {
				int num2 = (int)(Math.random()*6) + 1;
				System.out.println("주사위 : " + num2);
				
				//만약 6이 나오면 다음 사람으로 넘어감
				if (num2 >= 6) {
					break;
				}
			}
		}
		
		// 한 명이라도 6이 나오면 게임 종료
		boolean isStop = false;
		for (int i=1; i<=5; i++) {
			// 한 명 당 주사위 3번씩 던지기
			for (int j=1; j<=3; j++) {
				int num2 = (int)(Math.random()*6) + 1;
				System.out.println("주사위 : " + num2);
				
				//만약 6이 나오면 전체 게임 종료
				if (num2 >= 6) {
					isStop = true;
					break;
				}
			}
			if (isStop) {
				System.out.println("게임 종료");
				break;
			}
		}
		
		
		/* continue문 */
		for (int i=1; i<=10; i++) {
			if (i%2 == 0) {
				System.out.println(i); //짝수일 때 출력
			}
		}
		
		for (int i=1; i<=10; i++) {
			if (i%2 != 0) {
				continue; // 홀수일 경우 for문으로 돌아가라
			}
			System.out.println(i); //짝수일 때 출력
		}
		
		
		
		/* 문제 풀기 */
		// while문
		Scanner scan = new Scanner(System.in);
		
		//  1. 특정 수(0)가 올 때까지 반복(a~z)
		// 수를 입력하세요: -3 : 음수. 나머지는 양수
		System.out.println("Q1. 수를 입력하세요: ");
		int a = scan.nextInt();
		
		while (a != 0) {
			if (a > 0) {
				System.out.println(a + ": 양수");
			} else if (a < 0) {
				System.out.println(a + ": 음수");
			} 
			break;
		}
		if(a == 0) {
			System.out.println("입력한 수: 0");
		}
		
		System.out.println();
		
		// 2. 월을 입력하면 계절이 나오고 0을 입력하고 종료
		System.out.println("Q2. 월을 입력하세요: ");
		int b = scan.nextInt();
		
		while (b != 0) {
			if (b>=1 && b<4) {
				System.out.println(b + "월 : 봄");
			} else if (b>=4 && b<7) {
				System.out.println(b + "월 : 여름");
			} else if (b>=8 && b<12) {
				System.out.println(b + "월 : 가을");
			} else if(b>12 || b<0) {
				System.out.println("정확한 월을 입력하세요");
			} else {
				System.out.println(b + "월 : 겨울");
			} 
			break;
		}
		
		System.out.println();
		
		
		// 3. 가위바위보게임. 0이 입력될 때까지 반복(통계도 같이)
		System.out.println("Q3. 가위바위보 중 하나를 내세요: \n 1. 가위 2. 바위 3.보 (0: 종료)");
		int c = scan.nextInt(); // 1: 가위, 2: 바위, 3: 보
		int d = (int) (Math.random()*3)+1;
		cnt = 0;

		if (c > 3) {
			while(c > 3) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요 ");
				c = scan.nextInt();
				if (c<4) {
					break;
				}
			}
		}
		while(c != 0) {
			 if (c == d) {
				System.out.println("비겼습니다");
				if (c == 1) {
					System.out.println("가위 vs 가위");
				} else if (c == 2) {
					System.out.println("바위 vs 바위");
				} else if (c ==3) {
					System.out.println("보 vs 보");
				}
			} else if (c==1 && d==2) {
				System.out.println("졌습니다 \n 나: 가위 AI: 바위");
			} else if (c==1 && d==3) {
				System.out.println("이겼습니다 \n 나: 가위 AI: 보");
			} else if (c==2 && d==1) {
				System.out.println("이겼습니다 \n 나: 바위 AI: 가위");
			} else if (c==2 && d==3) {
				System.out.println("졌습니다 \n 나: 바위 AI: 보");
			} else if (c==3 && d==1) {
				System.out.println("졌습니다 \n 나: 보 AI: 가위");
			} else if (c==3 && d==2) {
				System.out.println("이겼습니다 \n 나: 보 AI: 바위");
			}
				}
		if (c == 0) {
			System.out.println("게임을 종료합니다");
		}
		
		
		System.out.println();
			
		// 4. 은행에서 
			// 1) 입금, 2) 출금 3) 잔고 확인 4) 종료
			// 조건: 입금할 때 음수 불가. 출금할 때 음수 불가, 잔고보다 큰 금액 불가
		System.out.println("Q4. 다음 중 고르시오: \n 1.입금 2.출금 3.잔고 확인 4.종료");
		int e = scan.nextInt();
		
		while (e != 4) {
			if (e == 1) {
				System.out.println("입금액을 입력하세요: ");
				int f = scan.nextInt();
				System.out.println(e + "원");
			}
		}
		if (e == 4) {
			System.out.println("종료합니다");
		}
		
		
	}
}
