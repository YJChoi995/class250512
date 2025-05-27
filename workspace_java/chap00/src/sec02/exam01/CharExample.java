package sec02.exam01;

public class CharExample {
	public static void main(String[] args) {
		char c1 = 65;
		System.out.println("c1: " + c1); // 유니코드 A : 65
		c1 = 65+2;
		System.out.println("c1: " + c1); // 유니코드 B : 67
		
		char c2 = 'F';
		System.out.println("c2: " + c2); // 문자 F를 출력
		
		char c3 = '한';
		System.out.println("c3: " + (c3+1));
		
		
		String name = "홍길동";
		String job = "프로그래머";
		System.out.println("name: " + name);
		System.out.println("job: " + job);
		
		String s1 = "홍길동";
		String s2 = "홍\"길동\"";
		System.out.println(s1);
		System.out.println(s2);
		
		String s3 = "홍\t길동";
		String s4 = "홍\n길동";
		System.out.println(s3);
		System.out.println(s4);
		
		String s5 = s1 + "글씨" + 3 + 2 + (3+2);
		System.out.println(s5);
	}
}
