package sec01.exam01;

import java.util.Scanner;

public class IfExam {
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
		
		System.out.println();
		
		
		// switch문
		int n1 = (int)(Math.random() * 6) +1;
		
		switch(n1) {
		case 1 :
			System.out.println("1번");
			break;
		case 2 :
			System.out.println("2번");
			break;
		case 3 :
			System.out.println("3번");
			break;
		case 4 :
			System.out.println("4번");
			break;
		case 5 :
			System.out.println("5번");
			break;
		default :
			System.out.println("6번");
			break;
		}
		
		int n2 = (int)(Math.random() * 6) +1;
		if(n2 == 1) {
			System.out.println("num은 1입니다.");
		} else if(n2 == 2 ) {
			System.out.println("num은 2입니다.");
		} else {
			System.out.println("num은 1, 2가 아닙니다.");
		}
		
		switch(n2) {
		case 1:
			System.out.println("num은 1입니다.");
			break;
		case 2:
			System.out.println("num은 2입니다.");	
			break;
		default:
			System.out.println("num은 1, 2가 아닙니다.");
			break;
		}
		
		// 문제
		int month = (int)(Math.random() * 12) +1;
		if (month >= 3 && month <= 5) {
			System.out.println(month + "월 " + "계절: 봄");
		} else if(month >= 6 && month <= 8){
			System.out.println(month + "월 " + "계절: 여름");
		} else if(month >= 9 && month <= 11){
			System.out.println(month + "월 " + "계절: 가을");
		} else {
			System.out.println(month + "월 " + "계절: 겨울");
		}
		
		switch (month) {
		case 3: 
		case 4: 
		case 5: 
			System.out.println(month + "월 " + "계절: 봄");
			break;
		case 6: 
		case 7: 
		case 8: 
			System.out.println(month + "월 " + "계절: 여름");
			break;
		case 9: 
		case 10: 
		case 11: 
			System.out.println(month + "월 " + "계절: 가을");
			break;
		default:
			System.out.println(month + "월 " + "계절: 겨울");
			break;
		}
		
		
		// 문제 풀기
		// Q1. int 변수에 임의의 수를 넣고 그 수가 "양수", "0", "음수" 구분하여 출력
		System.out.println("Q1. 숫자를 입력하시오: ");
		Scanner scanner = new Scanner(System.in);
		
		int abc = scanner.nextInt();
	
		if (abc == 0) { 
			System.out.println("숫자: " + abc);
		} else if (abc < 0) {
			System.out.println("숫자는: " + abc+ ", 음수");
		} else {
			System.out.println("숫자는: " + abc+ ", 양수");
		}
		
		// Q2. a와 b 두 수 중에서 큰 값을 출력
		System.out.println("Q2. 숫자 두 개를 입력하시오: ");
		
		int kc1 = scanner.nextInt();
		int kc2 = scanner.nextInt();
		
		if (kc1 > kc2) { 
			System.out.println(kc1 + "과 " + kc2 + " 중 큰 수는 :" + kc1);
		} else if (kc1 < kc2) { 
			System.out.println(kc1 + "과 " + kc2 + " 중 큰 수는 :" + kc2);
		} else if( kc1 == kc2) {
			System.out.println(kc1 + "과 " + kc2 + "는 같은 수입니다");
		}
		
		
		// Q3. 시간과 분이 있을 때 35분이 지난 시간을 출력
		System.out.println("Q3. 몇 시:  몇 분: 입니까(24시간제)");
		
		int h1 = scanner.nextInt();
		int m1 = scanner.nextInt();
		
		if (h1 <= 24 && m1 <= 60) {
			System.out.println("지금은 " + h1 + "시 " + m1 + "분 입니다");
			int h2 = h1 + 1;
			int m2 = m1 + 35;
			if(m2 > 60) {
				m2 = m2-60;
				System.out.println("35분 후는 " + h2 + "시 " + m2 + "분 입니다");
			} else if(m2 <= 60) {
				System.out.println("35분 후는 " + h1 + "시 " + m2 + "분 입니다");
			}
			
		} else if (h1 > 24 || m1 > 60) {
			System.out.println("유용하지 않은 시간 값입니다");
		}
		
		
		// Q4. 어떤 수가 15와 20 사이(포함)에 있는가?
		System.out.println("Q4. 숫자를 입력하시오: ");
		
		int q4 = scanner.nextInt();
		if(q4 >= 15 && q4 <= 20) {
			System.out.println("15와 20 사이입니다");
		} else if(q4 < 15 || q4 > 20) {
			System.out.println("15와 20 사이에 포함되지 않습니다");
		}
		
		
		// Q5. 통장 잔액이 15000원 있을 때 출금액에 따라 
		// "잔액이 부족합니다.", "얼마 출금했고 얼마 남았습니다.", "정확히 입력해주세요."
		System.out.println("Q5. 출금액을 입력하시오: ");
		
		int q5 = 15000;
		int q51 = scanner.nextInt();
		int q52 = q5 - q51;
		
		if (q52 >= 0) {
			System.out.println(q51 + "원을 출금했고 " + q52 + "원 남았습니다.");
		} else if (q52 < 0) {
			System.out.println("출금액: " + q51);
			System.out.println("잔액이 부족합니다. 잔액: " + q5);
		} 
		
		
		// Q6. 입력한 값에 따라 
		// (ex. 125) "100보다 큰 수이며, 양수이고, 홀수입니다"
		// (ex. -6) "100보다 작은 수이며, 음수이고, 짝수입니다."
		System.out.println("Q6. 숫자를 입력하시오: ");
		
		int q6 = scanner.nextInt();
		
		if(q6 > 100) {
			if (q6%2  == 1) {
				System.out.println("100보다 큰 수이며, 양수이고, 홀수입니다");
			} else if(q6%2 == 0) {
				System.out.println("100보다 큰 수이며, 양수이고, 짝수입니다");
			}
		} else if(q6 < 100 && q6 > 0) {
			if (q6%2 == 1) {
				System.out.println("100보다 작은 수이며, 양수이고, 홀수입니다");
			} else if(q6%2 == 0) {
				System.out.println("100보다 작은 수이며, 양수이고, 짝수입니다");
			}  
		} else if(q6 < 0) {
			if (q6%2 == -1) {
				System.out.println("100보다 작은 수이며, 음수이고, 홀수입니다");
		    } else if(q6%2 == 0) {
		    	System.out.println("100보다 작은 수이며, 음수이고, 짝수입니다");
		    }
		} else if(q6 == 100) {
				System.out.println("100과 같습니다");
		} else if(q6 == 0) {
			System.out.println("0은 100보다 작은 수 이며, 양수도 음수도 아니고, 짝수도 홀수도 아닙니다.");
		}
		
		
		// Q7. 어제 온도(2), 오늘 온도(영하 3도) 변수 두 개
		// "오늘 온도는 영하 3도 입니다. 어제보다 5도 낮습니다." 출력
		
		// Q8. 변수에 두자리 숫자(10~99)가 있을 때
		// 10의 자리와 1의 자리가 같은 수인지 판단
		
		// Q9. 사각형의 한쪽 모서리 x1:10, y1:20
		// 대각선 모서리            x2:60, y2:100
		// 이럴 때 새로운 점 x3, y3는 사각형에 포함되는가?
		
    }
}