package sec01.exam01;

public class ExtendsExam {

	public static void main(String[] args) {

		// child를 생성해서 
		// printName 실행		
		Child child = new Child();
		child.printName();
		
		System.out.println( child.getName() );
		child.setName("바뀐 이름");
		System.out.println("setName : " + setName);
		
		
	}

}
