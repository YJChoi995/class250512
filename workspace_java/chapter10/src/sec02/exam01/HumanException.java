package sec02.exam01;

public class HumanException extends Exception{
	
	HumanException() {
		System.out.println("HumanExceotion 생성");
	}
	
	HumanException(String message) {
		super(message);
		System.out.println("HumanExceotion(String) 생성");
	}
	
}
