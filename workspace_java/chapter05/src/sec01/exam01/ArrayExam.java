package sec01.exam01;

import java.util.Scanner;

public class ArrayExam {
	public static void main(String[] args) {
		int [] intArray = {1, 2, 3};
		double [] doubleArray;
		String [] StringArray;
		

		System.out.println("intArray[0] : " + intArray[0]);
		System.out.println("intArray[1] : " + intArray[1]);
		System.out.println("intArray[2] : " + intArray[2]);
		
		
		/* 다차원 배열 */
		int b0 = 5;
		int b1 = 15;
		int b2 = 55;
		
		int[] bs1 = new int[3];
		bs1[0] = b0;
		bs1[1] = b1;
		bs1[2] = b2;
		
		int[] bs2 = new int[3];
		bs2[0] = b0 + 1;
		bs2[1] = b1 + 1;
		bs2[2] = b2 + 1;
		
		
		int[][] bs = new int[2][3];
		bs[0] = bs1;
		bs[1] = bs2;
		
		System.out.println("bs.length : " + bs.length);
		System.out.println("bs[0].length : " + bs[0].length);
		
		
		/* 배열 복사 */
		int[] d1 = {1,2,3,4,5};
		int[] d2 = d1;
		int[] d3 = {1,2,3,4,5};
		System.out.println("d2 == d1 :" + (d2 == d1));
		System.out.println("d1 == d3 :" + (d1 == d3));
		
		d2[1] = 10;
		System.out.println("d1[1] : " + d1[1]);
		
		
		/* 문제 풀기 */
		// 반복문을 사용해서 1~10까지 저장, 다른 반복문에서 출력
		int[] e1 = new int[10];
		for(int i=0; i<10; i++) {
			e1[i] = i+1;
		}
		for(int i=0; i<10; i++){
			System.out.println("e1[" + i + "] : " + e1[i]);
		}
		
		// 무작위 숫자를 가지는 배열을 순서대로 출력하기
		int[] q = {4,5,7,8,2};
		for (int i=0; i<q.length; i++) {
			System.out.println("f[" + i + "] : " + q[i]);
		}
		// 무작위 숫자를 가지는 배열을 그대로 복사하여 순서대로 출력하기
		int[] q2 = new int[q.length];
		for(int i=0; i<q2.length; i++) {
			q2[i] = q[i];
			System.out.println("f2[" + i + "] : " + q2[i]);
		}
		
		
		/* 향상된 for문 */
		System.out.println("\n향상된 for문");
		
		for(int i=0; i<q.length; i++) {
			int data = q[i];
			System.out.println("data: " + data);
		}
		
		for(int data : q) {
			System.out.println("data: " + data);
		}
		
		System.out.println();
		
		
		/* 문제 풀기 */
		// Q1. 배열 뒤집기 : {1,2,3} -> {3,2,1}
		System.out.print("Q1. {1,2,3} 배열 뒤집기 : ");
		int[] a = {1,2,3};
		int[] b = new int[a.length];
		for (int i=0; i<a.length; i++) {
			b[i] = a[(a.length-1)-i];
			System.out.print(b[i] + " ");		
		}
		System.out.println();
					
		int[] c = {3,4,7,5,1,9,4};
		int cnt = 0;
				
		// Q2. {3,4,7,5,1,9,4} 배열에서 홀수의 개수 찾기
		System.out.print("Q2. {3,4,7,5,1,9,4} 배열에서 홀수의 개수 찾기 : ");
		for(int i=0; i<c.length; i++) {
			if (c[i]%2 == 1) {
				cnt++;
			}
		}
		System.out.print(cnt);
				
		System.out.println();
				
		// Q3. {3,4,7,5,1,9,4} 배열에서 4보다 큰 수의 개수 구하기
		System.out.print("Q3. {3,4,7,5,1,9,4} 배열에서 4보다 큰 수의 개수 구하기 : ");
		cnt = 0;
		for(int i=0; i<c.length; i++) {
			if (c[i] > 4) {
				cnt++;
			}
		}
		System.out.print(cnt);
				
		System.out.println();
						
		// Q4. {3,4,7,5,1,9,4} 배열에서 최대값 출력
		System.out.print("Q4. {3,4,7,5,1,9,4} 배열에서 최대값 출력 : ");
		int max = c[0];
		for(int i=0; i<c.length; i++) {
			if(max < c[i]) {
				max = c[i];
			}
		}
		System.out.print(max);
				
		System.out.println();
						
		// Q5. {3,4,7,5,1,9,4} 배열에서 두번째 큰 수 구하기
		System.out.print("Q5. {3,4,7,5,1,9,4} 배열에서 두번째 큰 수 구하기 : ");
		int second_max = c[0];
		for(int i=0; i<c.length; i++) {
			if(second_max < c[i] && c[i] < max) {
				second_max = c[i];
			}
		}
		System.out.print(second_max);
				
		System.out.println();
						
		// Q6. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 출력(왼쪽은 0으로 채우기)
		// {3,4,7,5,1,9,4} -> {0,3,4,7,5,1,9,4}
		System.out.print("Q6. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 출력(왼쪽은 0으로 채우기) : ");
		int[] d = new int[c.length+1];
		for(int i=0; i<c.length; i++) {
			d[i+1] = c[i];
		}
		for(int i=0; i<d.length; i++) {
			System.out.print(d[i] + " ");
		}
				
		System.out.println();
				
						
		// Q7. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 맨 끝값은 맨 처음으로 보내기
		// {3,4,7,5,1,9,4} -> {4,3,4,7,5,1,9}
		System.out.print("Q7. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 맨 끝값은 맨 처음으로 보내기 : ");
		int[] e = new int[c.length];
		for(int i=0; i<c.length; i++) {
			if(i<e.length-1) {
				e[i+1] = c[i];
			} else if(i == e.length-1) {
				e[0] = c[i];
			}	
		}
		for(int i=0; i<e.length; i++) {
			System.out.print(e[i] + " ");
		}
				
		System.out.println();
						
		// Q8. 임시비밀번호 8자리 생성
		// 8-1. 숫자만
		// 8-2. 소문자만
		// 8-3. 숫자 2개 이상, 대/소문자 각 1개 이상
				
		System.out.print("Q8-1. 숫자로만 된 임시비밀번호 8자리 생성 : ");
		int[] f = new int[8];
		for (int i=0; i<f.length; i++) {
			f[i] = (int)(Math.random()*9)+1;
			System.out.print(f[i] + " ");
		}
				
		System.out.println();
				
		System.out.print("Q8-2. 소문자만 된 임시비밀번호 8자리 생성 : ");
		char[] g = new char[8];
		for (int i=0; i<g.length; i++) {
			g[i] = (char)((int)(Math.random()*26) + 97); // 아스키 코드 : a~z(97-122)
			System.out.print(g[i] + " ");
		}
				
		System.out.println();
				
				
		System.out.print("Q8-3. 숫자 2개 이상, 대/소문자 각 1개 이상인 임시비밀번호 8자리 생성 : ");
		char[] pw = new char[8];
				
		// 숫자 2개 생성
		for (int i = 0; i < 2; i++) {
			pw[i] = (char)('0' + (int)(Math.random() * 10)); 
		}
				
		// 대문자 1개 랜덤 생성
		pw[2] = (char) ('A' + (int)(Math.random() * 26)); // A~Z
				
		// 소문자 1개 랜덤 생성
		pw[3] = (char) ('a' + (int)(Math.random() * 26)); // a~z
				
		// 나머지 4자리 랜덤으로 채우기(숫자만?)
		for(int i=4; i<8; i++) {
			pw[i] = (char)('0' + (int)(Math.random() * 10)); 
		}
		
		// 배열 랜덤으로 섞기
		for(int i=0; i<pw.length; i++) {
			int j = (int)(Math.random()*7)+1;
			char temp = pw[i];
			pw[i] = pw[j];
			pw[j] = temp;
		}
		
		// 출력하기
		for(int i=0; i<pw.length; i++) {
			System.out.print(pw[i] + " ");
		}
		
		System.out.println("\n");
				
				
		// Q9. 자리가 10개 있는 소극장의 예약 시스템
		// 자리 번호는 1~10번까지 번호의 자리가 있습니다
		// 메뉴 : "1.예약 2.모든 좌석 현황 3.잔여좌석 4.종료"
		// 만약1 : 예약이 가능하다면 "n번 자리 예약 했습니다"
		// 만약2 : 예약이 불가능하다면 "이미 예약 되어 있습니다"
		System.out.println("Q9. 자리가 10개 있는 소극장의 예약 시스템");
				
		Scanner scan = new Scanner(System.in);
		int[] seat = new int[10];
				
		while(true) {
			System.out.print("메뉴: 1.예약 2.모든 좌석 현황 3.잔여좌석 4.종료 \n 번호를 선택해주세요 : ");
			int menu = scan.nextInt();
					
			if(menu == 1) {
				System.out.print("예약할 번호(1~10)를 선택하세요 : ");
				int seatnum = scan.nextInt();
						
				if(seatnum>10 && seatnum<1) {
					System.out.print("잘못된 번호입니다");
				} else if(seat[seatnum-1] == 0) {
					seat[seatnum-1] = 1;
					System.out.println(seatnum + "번 자리 예약 했습니다");
				} else {
					System.out.println("이미 예약되어 있습니다");
				}	
			} else if(menu == 2) {
				for(int i=0; i<seat.length; i++) {
					if(seat[i] == 1) {
						System.out.println((i+1) + "번 : 예약된 자리입니다");
					} else {
						System.out.println((i+1) + "번 : 빈 자리입니다");
					}
				}
			} else if(menu == 3) {
				cnt=0;
						
				for(int i=0; i<seat.length; i++) {
					if(seat[i] == 0) {
						cnt++;
					}
				}
				System.out.println("잔여 좌석 수 : " + cnt + "석 \n");
			} else if(menu == 4) {
				System.out.println("종료합니다");
				break;
			} else {
				System.out.println("잘못된 번호입니다");
			}
		}
				
		System.out.println();
				
						
		// Q10. 로또 6개 생성, 단 중복 없이
		System.out.print("Q10. 로또 번호 6개 생성 : ");
		int[] lotto = new int[6];
				
		for (int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random() * 45)+1;
					
			// 중복 검사
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					i--; // 중복이면 뒤로가서 다시 출력
					break;
				}
			}
		}
		for (int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " "); // 출력하기
		}
		
		System.out.println();
		
		// 선생님 답
		System.out.print("Q10. 로또 번호 6개 생성(선생님 답) : ");
		
		boolean flag = false;
		
		for (int i=0; i<lotto.length; i++) {
			do {
				flag = false;
				lotto[i] = (int)(Math.random() * 45)+1;
				for(int j=0; j< i; j++) {
					if(lotto[j] == lotto[i]) {
						flag = true;
					}	
				}
			} while (flag);
		}
		for (int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + " "); // 출력하기
		}
	}
}
