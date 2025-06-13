package sec05.exam02_static;

public class CalcExam {
	public static void main(String[] args) {
		Calc c1 = new Calc();
		
		c1.color = "블랙";
		System.out.println("c1.pi : " + c1.pi);
		System.out.println("c1.pi : " + Calc.pi); // new를 하지 않아도 바로 사용가능
		
		
		Calc c2 = new Calc();
		c2.color = "빨강";
		System.out.println("c2.pi : " + c2.pi) ;
		

	}

}
