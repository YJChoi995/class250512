package sec01.exam03.override;

public class ComputerExam {
	public static void main(String[] args) {
		
		Calc calc = new Calc();
		System.out.println( calc.areaCircle(10) );
		
		Computer computer = new Computer();
		System.out.println( computer.areaCircle(10) );
		
		System.out.println( computer.plus(1, 2) );
		
	}
}
