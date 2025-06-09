package review2025;

public class review250605 {
	public static void main(String[] args) {
		
		/* 배열 문제 풀기 */
		// Q1. 배열 뒤집기 : {1,2,3} -> {3,2,1}
		System.out.print("Q1. {1,2,3} 배열 뒤집기 : ");
		int[] a = {1,2,3};
		int[] b = new int[a.length];
		for(int i=0; i<a.length; i++) {
			b[i] = a[(a.length-1)-i];
			System.out.print(b[i] + " ");
		}
		
		System.out.println("\n");

		int[] array = {3,4,7,5,1,9,4}; 
		int cnt = 0;
		
		// Q2. {3,4,7,5,1,9,4} 배열에서 홀수의 개수 찾기
		System.out.print("Q2. {3,4,7,5,1,9,4} 배열에서 홀수의 개수 찾기 : ");
		for(int i=0; i<array.length; i++) {
			if(array[i]%2 == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);

		System.out.println();
		
		
		// Q3. {3,4,7,5,1,9,4} 배열에서 4보다 큰 수의 개수 구하기
		System.out.print("Q3. {3,4,7,5,1,9,4} 배열에서 4보다 큰 수의 개수 구하기 : ");
		cnt = 0;
		for(int i=0; i<array.length; i++) {
			if(array[i] > 4) {
				cnt++;
			}
		}
		System.out.println(cnt);

		System.out.println();
		
				
		// Q4. {3,4,7,5,1,9,4} 배열에서 최대값 출력
		System.out.print("Q4. {3,4,7,5,1,9,4} 배열에서 최대값 출력 : ");
		int max = array[0];
		
		for(int i=0; i<array.length; i++) {
			if(max < array[i]) {
				max = array[i];
			}
		}
		System.out.println(max);

		System.out.println();
				
		// Q5. {3,4,7,5,1,9,4} 배열에서 두번째 큰 수 구하기
		System.out.print("Q5. {3,4,7,5,1,9,4} 배열에서 두번째 큰 수 구하기 : ");
		int secondmax = array[0];
		
		for(int i=0; i<array.length; i++) {
			if(secondmax < array[i] && array[i] < max) {
				secondmax = array[i];
			}
		}
		System.out.println(secondmax);
		
		System.out.println();
				
		// Q6. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 출력(왼쪽은 0으로 채우기)
		// {3,4,7,5,1,9,4} -> {0,3,4,7,5,1,9,4}
		System.out.print("Q6. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 출력(왼쪽은 0으로 채우기) : ");
		int[] q6 = new int[array.length + 1];
		
		for(int i=0; i<array.length; i++) {
			q6[i+1] = array[i];
		}
		for(int i=0; i<q6.length; i++) {
			System.out.print(q6[i] + " ");
		}

		System.out.println("\n");
				
		// Q7. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 맨 끝값은 맨 처음으로 보내기
		// {3,4,7,5,1,9,4} -> {4,3,4,7,5,1,9}
		System.out.print("Q7. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 맨 끝값은 맨 처음으로 보내기 : ");
		int[] q7 = new int[array.length];
		
		for(int i=0; i<array.length; i++) {
			if(i < q7.length-1) {
				q7[i+1] = array[i];
			} else {
				q7[0] = array[i];
			}
		}
		for(int i=0; i<q7.length; i++) {
			System.out.print(q7[i] + " ");
		}
		
		System.out.println("\n");
				
		
		// Q8. 임시비밀번호 8자리 생성
		// 8-1. 숫자만
		// 8-2. 소문자만
		// 8-3. 숫자 2개 이상, 대/소문자 각 1개 이상
		
		System.out.print("Q8-1. 숫자로만 된 임시비밀번호 8자리 생성 : ");
		int[] pw = new int[8];
		for(int i=0; i<pw.length; i++) {
			pw[i] = (int)(Math.random()*10);
			System.out.print(pw[i] + " ");
		}

		System.out.println("\n");
		
		
		System.out.print("Q8-2. 소문자만 된 임시비밀번호 8자리 생성 : ");
		char[] pw2 = new char[8];
		for(int i=0; i<pw2.length; i++) {
			pw2[i] = (char)('a' + Math.random()*26); 
			System.out.print(pw2[i] + " ");
		}

		System.out.println("\n");
		
		
		System.out.print("Q8-3. 숫자 2개 이상, 대/소문자 각 1개 이상인 임시비밀번호 8자리 생성 : ");
		char[] pw3 = new char[8];
		
		//숫자 2개 만들기
		for(int i=0; i<2; i++) {
			pw3[i] = (char)('0' + (int)(Math.random()*10));
		}
		
		// 대문자 만들기
		pw3[2] = (char) ('A' + (int)(Math.random() * 26));
		
		// 소문자 만들기
		pw3[3] = (char) ('a' + (int)(Math.random() * 26));
		
		// 나머지 4글자 만들기
		for(int i=4; i<pw3.length; i++) {
			pw3[i] = (char)( '0' + (int)(Math.random()*10) );
		}

		// 출력하기
		for(int i=0; i<pw3.length; i++) {
			System.out.print(pw3[i] + " ");
		}
		
		System.out.println("\n");
		
		
		// Q9. 자리가 10개 있는 소극장의 예약 시스템
		// 자리 번호는 1~10번까지 번호의 자리가 있습니다
		// 메뉴 : "1.예약 2.모든 좌석 현황 3.잔여좌석 4.종료"
		// 만약1 : 예약이 가능하다면 "n번 자리 예약 했습니다"
		// 만약2 : 예약이 불가능하다면 "이미 예약 되어 있습니다"
		System.out.println("Q9. 자리가 10개 있는 소극장의 예약 시스템");
	
		
		System.out.println();
		
				
		// Q10. 로또 6개 생성, 단 중복 없이
		System.out.print("Q10. 로또 번호 6개 생성 : ");

			
			// 중복 검사

		
		
	}
}
