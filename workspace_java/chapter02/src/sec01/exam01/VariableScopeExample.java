package sec01.exam01;

public class VariableScopeExample {
	public static void main(String[] args) {
		int x = 10;
		int y = x;
		System.out.println(x);
		
		// 변수의 사용 가능 범위는 {} 괄호 안
		{
			x = 3;
			System.out.println(x);
			int z =5;
			System.out.println("z : " + z);
		}
		int z = 55; // 중괄호에서 앞 변수 z의 범위는 끝났기 때문에 다시 변수 z를 선언할 수 있음
		System.out.println("z : " + 5 );
		
		
		// 변수 값 자리 바꾸기
		{
			int x1 = 123;
			int x2 = 456;
			
			int temp1 = x1;
			x1 = x2;
			x2 = temp1;
			
			System.out.println("x1 : " + x1); // 456
			System.out.println("x2 : " + x2); // 123
		}
	}
	
}
