package sec04.exam01;

import java.io.IOException;
import java.util.Scanner;

public class PrintKeybordScannerExample {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5);
		System.out.println(6);
		
		System.out.printf("이름: %s", "김자바");
		System.out.printf("나이: %d", 25);
//		System.out.printf("이름: " + "김자바" + "나이: " + 25);
		System.out.printf("이름: %s, 나이: %d", "김자바", 25);
		System.out.printf("이름: %6s, 나이: %04d", "김자바", 25);
		System.out.println();
		
		
		/* 키보드에서 입력된 내용을 변수에 저장하기 */
		int keyCode;
		
		/* 
		 * Scanner 연습하려고 주석 처리
		try {
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			keyCode = System.in.read();
			System.out.println("keyCode: " + keyCode);
			
			
		} catch (IOException e) { e.printStackTrace(); }
		*/
		
		/* Scanner 연습 */
		Scanner scanner = new Scanner(System.in);
		
		// 엔터까지의 모든 글씨
		String inputData = scanner.nextLine();
		System.out.println("inputData: " + inputData);
		
		// 엔터쳤을 때 띄어쓰기까지의 모든 글씨
		String inputData2 = scanner.next();
		System.out.println("inputData2: " + inputData2);
		
		// 엔터쳤을 때의 숫자
		int input = scanner.nextInt();
		System.out.println("input: " + input);
		
		System.out.println("x값을 입력하시오");
		int input2 = scanner.nextInt();
		System.out.println("input2: " + input2);
	}
}
