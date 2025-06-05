package sec01.exam01;

public class ArrayExample {
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
		int[] f = {4,5,7,8,2};
		for (int i=0; i<f.length; i++) {
			System.out.println("f[" + i + "] : " + f[i]);
		}
		// 무작위 숫자를 가지는 배열을 그대로 복사하여 순서대로 출력하기
		int[] f2 = new int[f.length];
		for(int i=0; i<f2.length; i++) {
			f2[i] = f[i];
			System.out.println("f2[" + i + "] : " + f2[i]);
		}
		
		
		/* 향상된 for문 */
		System.out.println("\n향상된 for문");
		
		for(int i=0; i<f.length; i++) {
			int data = f[i];
			System.out.println("data: " + data);
		}
		
		for(int data : f) {
			System.out.println("data: " + data);
		}
		
		System.out.println();
		
		/* 문제 풀기 */
		// Q1. 배열 뒤집기 : {1,2,3} -> {3,2,1}
		System.out.println("Q1. 배열 뒤집기");
		int[] a = {1,2,3};
		for (int i=0; i<a.length; i++) {
			int[] b = new int[a.length];
			b[i] = a[(a.length-1)-i];
			System.out.println("b[" + i + "] : " + b[i]);
		}
		
		System.out.println();
		
		int[] q = {3,4,7,5,1,9,4};
		
		// Q2. {3,4,7,5,1,9,4} 배열에서 홀수의 개수 찾기
		System.out.println("Q2. 홀수의 개수 찾기");
		int cnt = 0;
		for (int i=0; i<q.length; i++) {
			if (q[i]%2 == 1) {
				cnt++;
			}
		}
		System.out.println("홀수의 개수: " + cnt);
		
		System.out.println();
		
		// Q3. {3,4,7,5,1,9,4} 배열에서 4보다 큰 수의 개수 구하기
		System.out.println("Q3. 배열에서 4보다 큰 수의 개수 구하기");
		cnt = 0;
		for (int i=0; i<q.length; i++) {
			if (q[i] > 4) {
				cnt++;
			}
		}
		System.out.println("4보다 큰 수의 개수: " + cnt);
		
		System.out.println();
		
		
		// Q4. {3,4,7,5,1,9,4} 배열에서 최대값 출력
		System.out.print("Q4. 배열에서 최대값 출력: ");
		int max = q[0];
		for (int i=0; i<q.length; i++) {
			if(max < q[i]) {
				max = q[i];
			}
		}
		System.out.print(max);
	
		System.out.println("\n");
		
		
		// Q5. {3,4,7,5,1,9,4} 배열에서 두번째 큰 수 구하기
		System.out.print("Q5. 배열에서 두번째 큰 수 구하기: ");

		System.out.println("\n");
		
		
		// Q6. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 출력(왼쪽은 0으로 채우기)
		// {3,4,7,5,1,9,4} -> {0,3,4,7,5,1,9,4}
		System.out.println("Q6. 배열에서 오른쪽으로 한칸 밀어서 출력(왼쪽은 0으로 채우기)");
		int[] q6 = new int[q.length+1];
		
		for (int i=0; i<q.length; i++) {
			q6[i+1] = q[i];
		}
		for(int i=0; i<q6.length; i++) {
			System.out.print(q6[i] + " ");
		}

		System.out.println("\n");
		
		// Q7. {3,4,7,5,1,9,4} 배열에서 오른쪽으로 한칸 밀어서 맨 끝값은 맨 처음으로 보내기
		// {3,4,7,5,1,9,4} -> {4,3,4,7,5,1,9}
		System.out.println("Q7. 배열에서 오른쪽으로 한칸 밀어서 맨 끝값은 맨 처음으로 보내기");
		int[] q7 = new int[q.length];
		
		for (int i=0; i<q.length; i++) {
			if(i < q.length-1) {
				q7[i+1] = q[i];
			} else if(i == q.length-1) {
				q7[0] = q[i];
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
		
		System.out.println("Q8-1. 숫자로 된 임시비밀번호 8자리 생성");
		int[] q81 = new int[8];
		System.out.print("비밀번호: ");
		for (int i=0; i<q81.length; i++) {
			q81[i] = (int)(Math.random()*9) + 1;
			System.out.print(q81[i] + " ");
		}
		
		System.out.println("\n");
		
		System.out.println("Q8-2. 소문자로 된 임시비밀번호 8자리 생성");
		char[] q82 = new char[8];
		System.out.print("비밀번호: ");
		for (int i=0; i<q82.length; i++) {
			int q82a = (int)(Math.random()*26) + 97; // 알파벳 : 26자리, char: 아스키코드(a~z:97~122)
			q82[i] = (char) q82a;
			System.out.print(q82[i] + " ");
		}
		
		System.out.println("\n");
		
		
		
		System.out.println("Q8-3. 숫자 2개 이상, 대/소문자 각 1개 이상로 된 임시비밀번호 8자리 생성");
		char[] q83 = new char[8];
		System.out.print("비밀번호: ");
		for (int i=0; i<q83.length; i++) {
			int q83a = (int)(Math.random()*26) + 97; 
			q83[i] = (char) q83a;
			System.out.print(q83[i] + " ");
		}
		
		
		System.out.println("\n");
		
		// Q9. 자리가 10개 있는 소극장의 예약 시스템
		// 자리 번호는 1~10번까지 번호의 자리가 있습니다
		// 메뉴 : "1.예약 2.모든 좌석 현황 3.잔여좌석 4. 종료"
		// 만약1 : 예약이 가능하다면 "n번 자리 예약 했습니다"
		// 만약2 : 예약이 불가능하다면 "이미 예약 되어 있습니다"
		
		
		
		// Q10. 로또 6개 생성, 단 중복 없이
		System.out.println("Q10. 로또 6개 생성, 단 중복 없이");
		System.out.print("로또 여섯 자리: ");
		int[] rotto = new int[6];
		for (int i=0; i<6; i++) {
			int j = (int)(Math.random()*45)+1;
			int q10 = rotto[0];
			if(j != q10) {
				rotto[i] = j;
			}
			System.out.print(rotto[i] + " ");
		}
	
		
		
	}
}
