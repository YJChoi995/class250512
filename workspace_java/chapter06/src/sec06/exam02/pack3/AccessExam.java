package sec06.exam02.pack3;

//import sec06.exam02.pack1.Access1;
import sec06.exam02.pack2.Access2;


public class AccessExam {
	public static void main(String[] args) {
		
		// public이 아니여서 사용 못 함
		// Access1 a1 = new Access1();
		
		Access2 a2 = new Access2();
//		a2.test1(); // public 아님
		a2.test2(); // public
		

	}
}
