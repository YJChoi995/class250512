package sec01.exam01;

public class VariableExchaneExam {
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		System.out.println("x: " + x + ", y: " + y);
		
		int temp = x; // 변수 temp에 변수 x 값을 저장(temp = 3)
		x = y; // 변수 x에 y값을 저장(x = 5)
		y = temp; // 변수 y에 temp값을 저장(y = 3)
	    System.out.println("x: " + x + ", y: " + y);
	}
}
